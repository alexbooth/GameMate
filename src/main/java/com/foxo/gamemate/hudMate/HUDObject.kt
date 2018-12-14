package com.foxo.gamemate.hudMate

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.foxo.gamemate.gameMate.Renderer


open class HUDObject {

    companion object {
        lateinit var renderer: Renderer
        lateinit var batch: SpriteBatch

        @JvmField var HUDScale = 1f

        fun defaultBlending() {
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
            batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
        }

        fun spriteBlending() {
            Gdx.gl.glBlendFunc(GL20.GL_ONE, GL20.GL_ONE_MINUS_SRC_ALPHA)
            batch.setBlendFunction(GL20.GL_ONE, GL20.GL_ONE_MINUS_SRC_ALPHA)
        }
    }

    open var popupObject = false
    open fun render() {}
    open fun update(dt: Float) {}
    open fun tapDown(x: Float, y: Float) {}
}