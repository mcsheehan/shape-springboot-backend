package net.marksheehan.shape.backend

import net.marksheehan.shape.backend.datamodel.Point
import net.marksheehan.shape.backend.datamodel.Rectangle
import java.lang.Double.max
import java.lang.Double.min

fun createRectangleWithCorrectlyOrderedCorners(rectangle: Rectangle) : Rectangle{

    val minX = min(rectangle.topLeft.x, rectangle.bottomRight.x)
    val maxX = max(rectangle.topLeft.x, rectangle.bottomRight.x)

    val minY = min(rectangle.topLeft.y, rectangle.bottomRight.y)
    val maxY = max(rectangle.topLeft.y, rectangle.bottomRight.y)

    return Rectangle(Point(minX, maxY), Point(maxX, minY))
}

fun doRectangesOverlap(first : Rectangle, second : Rectangle) : Boolean {

    // For a demonstration of why these logical expressions determine whether there is an overlap goto:
    // https://silentmatt.com/rectangle-intersection/

    val leftEdgeOfFirstLeftOfRightEdgeOfSecond : Boolean = first.topLeft.x < second.bottomRight.x

    val rightEdgeOfFirstRightOfLeftEdgeOfSecond : Boolean = first.bottomRight.x > second.topLeft.x

    val topEdgeOfFirstIsBelowBottomEdgeOfSecond : Boolean = first.topLeft.y < second.bottomRight.y

    val bottomEdgeOfFirstIsAboveTopEdgeOfSecond : Boolean = first.bottomRight.y > second.topLeft.y

    if (leftEdgeOfFirstLeftOfRightEdgeOfSecond &&
            rightEdgeOfFirstRightOfLeftEdgeOfSecond &&
            topEdgeOfFirstIsBelowBottomEdgeOfSecond &&
            bottomEdgeOfFirstIsAboveTopEdgeOfSecond){
        return true
    }

    return false

}