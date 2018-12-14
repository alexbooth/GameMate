package com.foxo.gamemate.gameMate


class NoiseMaker {
    companion object {
        private fun fract(x: Double): Double {
            return x - Math.floor(x)
        }

        private fun mix(x: Double, y: Double, a: Double): Double {
            return x*(1-a)+y*a
        }

        private fun rand(seed: Double): Double {
            return fract(Math.sin(seed) * 43758.5453123)
        }

        fun noise(x: Double): Double {
            val fl = Math.floor(x)
            val fc = fract(x)
            return mix(rand(fl), rand(fl + 1.0), fc)
        }
    }
}