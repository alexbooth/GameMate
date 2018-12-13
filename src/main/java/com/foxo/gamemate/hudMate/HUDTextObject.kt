package com.foxo.gamemate.hudMate

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.glutils.ShaderProgram


open class HUDTextObject: HUDObject() {

    companion object {
        val fontShader = ShaderProgram(Gdx.files.internal("shaders/vert.gl"),
                Gdx.files.internal("shaders/frag.gl"))
    }

    init {
        if (!fontShader.isCompiled)
            Gdx.app.error("fontShader", "compilation failed:\n" + fontShader.log)
    }
}