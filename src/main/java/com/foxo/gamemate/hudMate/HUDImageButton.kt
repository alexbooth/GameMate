package com.foxo.gamemate.hudMate

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture


class HUDImageButton(): HUDButton() {

    constructor(t: Texture): this() {
        texture = t
        texture.setFilter(Texture.TextureFilter.MipMapLinearLinear,
                               Texture.TextureFilter.Linear)
    }

    constructor(pixmap: Pixmap): this() {
        texture = Texture(pixmap, true)
        texture.setFilter(Texture.TextureFilter.MipMapLinearLinear, Texture.TextureFilter.Linear)
    }

    constructor(imgPath: String): this() {
        texture = Texture(Gdx.files.internal(imgPath), true)
        texture.setFilter(Texture.TextureFilter.MipMapLinearLinear, Texture.TextureFilter.Linear)
    }

    override fun render() {
        batch.begin()
        spriteBlending()
        batch.shader = null
        val scale = if (popupObject) 1f else HUDScale
        batch.draw(texture, x-width* scale /2f, y-width* scale /2f,
                width * scale, height * scale)
        batch.end()
    }
}