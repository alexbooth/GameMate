package com.foxo.gamemate.hudMate

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.TextureRegion


enum class Anchor {
    LEFT, RIGHT, CENTER
}


class HUDFont(text_ : String=""): HUDTextObject() {

    val layout = GlyphLayout()
    private var font: BitmapFont

    private var centerX = 0f
    private var centerY = 0f

    //private var rightX = 0f

    private var lastText = ""

    var anchor: Anchor = Anchor.CENTER
        set(value) {
            field = value
            centerText()
        }

    var x: Float = Gdx.graphics.width.toFloat()
        set(value) {
            field = value
            centerText()
        }

    var y: Float = Gdx.graphics.height.toFloat()
        set(value) {
            field = value
            centerText()
        }

    var text: String = text_
        set(value) {
            field = value
            if (value != lastText) {
                lastText = value
                centerText()
            }
        }

    var size: Float = 1f
        set(value) {
            field = value
            centerText()
        }

    var color: Color = Color.WHITE
        set(value) {
            field = value
            setColor(color.r, color.g, color.b, color.a)
        }

    init {
        val texture = Texture(Gdx.files.internal("fonts/custom.png"), true)
        texture.setFilter(Texture.TextureFilter.MipMapLinearLinear, Texture.TextureFilter.Linear)
        font = BitmapFont(Gdx.files.internal("fonts/custom.fnt"), TextureRegion(texture), false)
        centerText()
    }

    private fun centerText() {
        font.data.setScale(size * HUDScale)
        layout.setText(font, text)
        centerX = x - (layout.width / 2f)
        centerY = y + (layout.height / 2f)
    }

    fun setColor(r: Float, g: Float, b: Float, a: Float) {
        font.setColor(r, g, b, a)
    }

    override fun render() {
        batch.begin()
        defaultBlending()
        batch.shader = HUDTextObject.fontShader
        when (anchor) {
            Anchor.CENTER -> font.draw(batch, text, centerX, centerY)
            Anchor.LEFT   -> font.draw(batch, text, x, centerY)
            Anchor.RIGHT  -> font.draw(batch, text, centerX, centerY)
        }
        batch.shader = null
        batch.end()
    }
}