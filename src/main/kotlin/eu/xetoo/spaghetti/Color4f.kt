package eu.xetoo.spaghetti

class Color4f @JvmOverloads constructor(r: Float, g: Float, b: Float, a: Float = 1f) {
    val r: Float
    val g: Float
    val b: Float
    val a: Float
    val intValue: Int

    companion object {
        val ZERO = Color4f(0f, 0f, 0f, 0f)
        fun fromColor(color: Int): Color4f {
            val alpha = (color and -0x1000000 ushr 24) / 255f
            return fromColor(color, alpha)
        }

        fun fromColor(color: Int, alpha: Float): Color4f {
            val r = (color and 0x00FF0000 ushr 16) / 255f
            val g = (color and 0x000FF000 ushr 8) / 255f
            val b = (color and 0x000000FF) / 255f
            return Color4f(r, g, b, alpha)
        }

        fun fromColor(color: Color4f, alpha: Float): Color4f {
            return Color4f(color.r, color.g, color.b, alpha)
        }
    }

    init {
        var r = r
        var g = g
        var b = b
        var a = a
        if (r == -0.0f) {
            r = 0.0f
        }
        if (g == -0.0f) {
            g = 0.0f
        }
        if (b == -0.0f) {
            b = 0.0f
        }
        if (a == -0.0f) {
            a = 0.0f
        }
        this.r = r
        this.g = g
        this.b = b
        this.a = a
        /*
        this.r = MathHelper.clamp(r, 0f, 1f);
        this.g = MathHelper.clamp(g, 0f, 1f);
        this.b = MathHelper.clamp(b, 0f, 1f);
        this.a = MathHelper.clamp(a, 0f, 1f);
        */intValue =
            (a * 0xFF).toInt() shl 24 or ((r * 0xFF).toInt() shl 16) or ((g * 0xFF).toInt() shl 8) or (b * 0xFF).toInt()
    }
}