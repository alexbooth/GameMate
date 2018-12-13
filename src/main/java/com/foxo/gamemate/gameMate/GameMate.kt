package com.foxo.gamemate.gameMate

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Matrix4



open class GameMate(val gameHeight: Float,
                    val gameWidth: Float,
                    val cam: OrthographicCamera,
                    val renderer: Renderer,
                    val batch: SpriteBatch,
                    val playServices: PlayServices): InputProcessor {

    var deviceWidth = Gdx.graphics.width.toFloat()
    var deviceHeight = Gdx.graphics.height.toFloat()

    var gameProjection = renderer.projectionMatrix.cpy()
    var hudProjection = Matrix4().setToOrtho2D(0f,0f,
            Gdx.graphics.width.toFloat(),
            Gdx.graphics.height.toFloat())

    init {
        GameObject.renderer = renderer
        GameObject.batch = batch
    }

    fun defaultBlending() {
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
    }

    fun spriteBlending() {
        Gdx.gl.glBlendFunc(GL20.GL_ONE, GL20.GL_ONE_MINUS_SRC_ALPHA)
        batch.setBlendFunction(GL20.GL_ONE, GL20.GL_ONE_MINUS_SRC_ALPHA)
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        return false
    }

    override fun keyTyped(character: Char): Boolean {
        return false
    }

    override fun scrolled(amount: Int): Boolean {
        return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        return false
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun keyDown(keycode: Int): Boolean {
        if(keycode == Input.Keys.BACK) {
            //Gdx.app.exit()
        }
        return false
    }
}