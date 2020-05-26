package net.marksheehan.shape.backend

import net.marksheehan.shape.backend.datamodel.Point
import net.marksheehan.shape.backend.datamodel.Square
import java.lang.Double.max
import java.lang.Double.min

fun createSquareWithCorrectlyOrderedCorners(square: Square) : Square{

    val minX = min(square.topLeft.x, square.bottomRight.x)
    val maxX = max(square.topLeft.x, square.bottomRight.x)

    val minY = min(square.topLeft.y, square.bottomRight.y)
    val maxY = max(square.topLeft.y, square.bottomRight.y)

    return Square(Point(minX, maxY), Point(maxX, minY))
}

fun doSquaresOverlap(first : Square, second : Square) : Boolean {

    val leftEdgeOfFirstLeftOfRightEdgeOfSecond : Boolean = first.topLeft.x > second.bottomRight.x
    if (leftEdgeOfFirstLeftOfRightEdgeOfSecond)
        return false

    val rightEdgeOfFirstLeftOfLeftEdgeOfSecond : Boolean = first.bottomRight.x < second.topLeft.x
    if (rightEdgeOfFirstLeftOfLeftEdgeOfSecond)
        return false

    val topEdgeOfFirstIsBelowBottomEdgeOfSecond : Boolean = first.topLeft.y < second.bottomRight.y
    if (topEdgeOfFirstIsBelowBottomEdgeOfSecond)
        return false

    val bottomEdgeOfFirstIsAboveTopEdgeOfSecond : Boolean = first.bottomRight.y > second.topLeft.y
    if (bottomEdgeOfFirstIsAboveTopEdgeOfSecond)
        return false

    return true
}