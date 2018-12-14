package com.foxo.gamemate.hudMate

import kotlin.math.roundToInt
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.*
import com.badlogic.gdx.graphics.glutils.FrameBuffer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.foxo.gamemate.gameMate.Renderer
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.math.Matrix4


enum class Orientation {
    UP, DOWN, LEFT, RIGHT
}


class ShapeHelper {
    companion object {
        fun roundedRect(width: Float, height: Float, radius: Float, color: Color): Pixmap {
            val projectionMatrix = Matrix4()
            projectionMatrix.setToOrtho2D(0f, 0f, width*2f, height*2f)

            val frameBuffer = FrameBuffer(Pixmap.Format.RGBA8888, width.toInt()*2, height.toInt()*2, false)
            frameBuffer.begin()

            Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 0f)
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)

            val renderer = Renderer()
            renderer.projectionMatrix = projectionMatrix
            renderer.color = color
            renderer.begin(ShapeRenderer.ShapeType.Filled)
            renderer.roundedRect(0f,0f, width*2f, height*2f, radius*2f)
            renderer.end()

            val pixmap = ScreenUtils.getFrameBufferPixmap(0, 0, width.toInt()*2, height.toInt()*2)
            frameBuffer.end()
            return pixmap
        }
        fun circle(radius: Float, color: Color): Pixmap {
            val r = radius.roundToInt()
            val pixmap = Pixmap(r*2, r*2, Pixmap.Format.RGBA8888)
            pixmap.setColor(color)
            pixmap.fillCircle(r, r, r)
            return pixmap
        }
        fun triangle(base: Float, height: Float, o: Orientation, color: Color): Pixmap {
            if (o == Orientation.UP) {
                val w = base.roundToInt()
                val h = height.roundToInt()
                val pixmap = Pixmap(w, h, Pixmap.Format.RGBA8888)
                pixmap.setColor(color)
                pixmap.fillTriangle(w/2, 0, 0, h, w, h)
                return pixmap
            }
            else if (o == Orientation.DOWN) {
                val w = base.roundToInt()
                val h = height.roundToInt()
                val pixmap = Pixmap(w, h, Pixmap.Format.RGBA8888)
                pixmap.setColor(color)
                pixmap.fillTriangle(0, 0, w / 2, h, w, 0)
                return pixmap
            }
            else if (o == Orientation.LEFT) {
                val h = base.roundToInt()
                val w = height.roundToInt()
                val pixmap = Pixmap(w, h, Pixmap.Format.RGBA8888)
                pixmap.setColor(color)
                pixmap.fillTriangle(0, h/2, w, h, w, 0)
                return pixmap
            }
            else if (o == Orientation.RIGHT) {
                val h = base.roundToInt()
                val w = height.roundToInt()
                val pixmap = Pixmap(w, h, Pixmap.Format.RGBA8888)
                pixmap.setColor(color)
                pixmap.fillTriangle(0, 0, 0, h, w, h/2)
                return pixmap
            }
            return Pixmap(1, 1, Pixmap.Format.RGBA8888)
        }
        fun merge(p0: Pixmap, p1: Pixmap): Pixmap {
            val w = Math.max(p0.width, p1.width)
            val h = Math.max(p0.height, p1.height)
            val pixmap = Pixmap(w, h, Pixmap.Format.RGBA8888)
            pixmap.drawPixmap(p0, Math.abs(p0.width-w)/2, Math.abs(p0.height-h)/2)
            pixmap.drawPixmap(p1, Math.abs(p1.width-w)/2, Math.abs(p1.height-h)/2)
            return pixmap
        }
    }
}