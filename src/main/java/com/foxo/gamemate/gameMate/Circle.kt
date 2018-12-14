package com.foxo.gamemate.gameMate

import com.badlogic.gdx.math.Vector2
import com.foxo.gamemate.gameMate.GameObject.Companion.renderer


open class Circle(x: Float, y: Float, var r: Float): GameObject {

    var pos = Vector2(x, y)

    override fun update(dt: Float) {}
    override fun render() {
        renderer.circle(pos.x, pos.y, r)
    }
}