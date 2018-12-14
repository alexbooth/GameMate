package com.foxo.gamemate.gameMate

import java.util.*

class AnimatedSampler {

    var sampleSpace = ArrayList<Int>()
    var action : () -> Unit = {}
    var onComplete : () -> Unit = {}
    var result = -1

    private var randoming = false
    private var nextActionTime = 0L
    var iters = 1
    var maxIters = 35
    private var maxIdx = 0

    fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) +  start

    fun random(replacement: Boolean=false) {
        if (randoming)
            return
        else {
            randoming = true
            iters = 1
            result = -1
            maxIdx = sampleSpace.size-1
        }
        nextActionTime = System.currentTimeMillis() + iters.toLong() * 10
    }

    fun update() {
        if (!randoming) return
        if (System.currentTimeMillis() > nextActionTime) {
            nextActionTime += iters.toLong() * 10
            iters++
            if (iters > maxIters) {
                randoming = false
                val resultIdx = (0..maxIdx).random()
                result = sampleSpace[resultIdx]
                sampleSpace.removeAt(resultIdx)
                onComplete()
            } else {
                action()
            }
        }
    }

}