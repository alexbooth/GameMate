package com.foxo.gamemate.hudMate

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture


class HUDImage(imgPath : String): HUDObject() {

    private val img = Texture(Gdx.files.internal(imgPath), true)
    private var centerX = 0f
    private var centerY = 0f
    private var rightX = 0f



    var anchor: Anchor = Anchor.CENTER
        set(value) {
            field = value
            centerImage()
        }

    var width: Float = 100f
        set(value) {
            field = value
            centerImage()
        }
    var height: Float = 100f
        set(value) {
            field = value
            centerImage()
        }

    var x: Float = Gdx.graphics.width.toFloat()
        set(value) {
            field = value
            centerImage()
        }

    var y: Float = Gdx.graphics.height.toFloat()
        set(value) {
            field = value
            centerImage()
        }

    var size: Float = 1f
        set(value) {
            field = value
            centerImage()
        }

    init {
        img.setFilter(Texture.TextureFilter.MipMapLinearLinear, Texture.TextureFilter.Linear)
        centerImage()
    }

    fun centerImage() {
        centerX = x - (width* HUDScale / 2f)
        centerY = y - (height* HUDScale / 2f)
    }

    override fun render() {
        batch.begin()
        defaultBlending()
        batch.shader = null
        when (anchor) {
            Anchor.CENTER -> batch.draw(img, centerX, centerY, width* HUDScale, height* HUDScale)
            Anchor.LEFT   -> batch.draw(img, x, centerY, width* HUDScale, height* HUDScale)
            Anchor.RIGHT  -> batch.draw(img, centerX, centerY, width* HUDScale, height* HUDScale)
        }
        batch.end()
    }
}