package com.foxo.gamemate.hudMate

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture


class HUDTextButton(width: Float, height: Float, text: String, backColor: Color, textColor: Color): HUDButton() {

    var font = HUDFont(text)

    var textSize: Float = 1f
        set(value) {
            field = value
            font.size = textSize
            fontSizeStore = textSize
        }
    var fontSizeStore = 1f

    init {
        this.width = width
        this.height = height
        val rect = ShapeHelper.roundedRect(width, height, 50f*HUDScale, backColor)
        texture = Texture(rect, true)
        texture.setFilter(Texture.TextureFilter.MipMapLinearLinear, Texture.TextureFilter.Linear)
        font.color = textColor
        font.size = textSize
        fontSizeStore = textSize
    }

    fun positionAt(x: Float, y: Float) {
        this.x = x
        this.y = y
        font.x = x
        font.y = y
    }

    override fun update(dt: Float) {
        if (animating) {
            animTime += dt
            val t = animTime/animDuration
            val tt = Math.abs(0.3f*t-0.15f) + 0.85f
            positionAt(x, y, widthStore*tt, heightStore*tt)
            font.size = fontSizeStore*tt
            if (animTime > animDuration) {
                animating = false
                textSize = fontSizeStore
                positionAt(xStore, yStore, widthStore, heightStore)
            }
        }
    }

    override fun render() {
        batch.begin()
        spriteBlending()
        batch.shader = null
        if (!enabled)
            batch.setColor(0.4f, 0.4f, 0.4f, 1f)
        else
            batch.setColor(1f, 1f, 1f, 1f)
        batch.draw(texture, x-width/2f, y-height/2f, width, height)
        batch.setColor(1f, 1f, 1f, 1f)
        batch.end()
        font.render()
    }
}