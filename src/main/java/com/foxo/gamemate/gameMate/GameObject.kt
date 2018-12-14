package com.foxo.gamemate.gameMate

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

interface GameObject {

    companion object {
        lateinit var renderer: ShapeRenderer
        lateinit var batch: SpriteBatch
    }

    fun render()
    fun update(dt: Float)
}