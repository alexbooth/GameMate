package com.foxo.gamemate.hudMate


import com.badlogic.gdx.graphics.Texture


open class HUDButton: HUDObject() {

    lateinit var texture: Texture

    var x = 0f
    var y = 0f
    var width = 0f
    var height = 0f

    var xStore = 0f
    var yStore = 0f
    var widthStore = 0f
    var heightStore = 0f
    var animDuration = 0.12f
    var animTime = 0f
    var animating = false

    var enabled = true

    var action : () -> Unit = {}

    override fun update(dt: Float) {
        if (enabled && animating) {
            animTime += dt
            val t = animTime/animDuration
            val tt = Math.abs(0.3f*t-0.15f) + 0.85f
            positionAt(x, y, widthStore*tt, heightStore*tt)
            if (animTime > animDuration) {
                animating = false
                positionAt(xStore, yStore, widthStore, heightStore)
            }
        }
    }

    open fun positionAt(x: Float, y: Float, width: Float, height: Float) {
        this.width = width
        this.height = height
        this.x = x
        this.y = y
    }

    override fun render() {
        batch.begin()
        spriteBlending()
        batch.shader = null
        batch.draw(texture, x - width * HUDScale / 2f, y - width * HUDScale / 2f,
                width * HUDScale, height * HUDScale)
        batch.end()
    }

    override fun tapDown(x: Float, y: Float) {
        val scale = if (popupObject) 1f else HUDScale
        if (x > this.x-width* scale /2f
                && x < this.x-width* scale /2f+width*scale
                && y > this.y-height* scale /2f
                && y < this.y-height* scale /2f+height*scale) {
            if (enabled && !animating) {
                xStore = this.x
                yStore = this.y
                heightStore = height
                widthStore = width
                animTime = 0f
                animating = true
            }
            action()
        }
    }
}