package com.foxo.gamemate.hudMate

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture


open class HUDPopup(width: Float, height: Float): HUDObject() {

    var width = width * HUDScale
    var height= height * HUDScale
    var showing = false
    var color = Color.WHITE
    val texture = Texture(ShapeHelper.roundedRect(width, height, 125f* HUDScale, color), true)
    var deviceWidth = Gdx.graphics.width.toFloat()
    var deviceHeight = Gdx.graphics.height.toFloat()
    var centerX = deviceWidth/2f
    var centerY = deviceHeight/2f

    init {
       texture.setFilter(Texture.TextureFilter.MipMapLinearLinear, Texture.TextureFilter.Linear)
    }

    override fun render() {
        if (showing) {
            batch.begin()
            spriteBlending()
            batch.shader = null
            batch.draw(texture, centerX-width/2f, centerY-height/2f, width, height)
            batch.end()
        }
    }
}