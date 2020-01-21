package eu.xetoo.spaghetti

import net.minecraft.util.math.Box
import net.minecraft.util.math.Direction

fun Box.minX(): Double = getMin(Direction.Axis.X)

fun Box.maxX(): Double = getMax(Direction.Axis.X)

fun Box.minY(): Double = getMin(Direction.Axis.Y)

fun Box.maxY(): Double = getMax(Direction.Axis.Y)

fun Box.minZ(): Double = getMin(Direction.Axis.Z)

fun Box.maxZ(): Double = getMax(Direction.Axis.Z)