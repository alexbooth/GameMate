package com.foxo.gamemate.hudMate

import com.foxo.gamemate.gameMate.GameMate
import java.util.*


open class HUDView(private val game: GameMate) {

    private val renderer = game.renderer
    val batch = game.batch

    private val hudObjects = ArrayList<HUDObject>()

    init {
        HUDObject.renderer = renderer
        HUDObject.batch = batch
    }

    fun add(obj: HUDObject) {
        hudObjects.add(obj)
    }

    fun update(dt: Float) {
        hudObjects.forEach { it.update(dt) }
    }

    fun render() {
        // Project to screen coordinates
        renderer.projectionMatrix = game.hudProjection
        batch.projectionMatrix = game.hudProjection

        // Render all hud objects
        hudObjects.forEach { it.render() }

        // Restore projections to game coordinates
        renderer.projectionMatrix = game.gameProjection
        batch.projectionMatrix = game.gameProjection
    }

    fun tapDown(x: Float, y: Float) {
        hudObjects.forEach { it.tapDown(x, y) }
    }
}