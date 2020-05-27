package net.marksheehan.shape.backend

import net.marksheehan.shape.backend.datamodel.Point
import net.marksheehan.shape.backend.datamodel.Rectangle
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RectangleOverlapLogicKtTest {

    @Test
    fun sameRectangleReturnsOverlap(){
        val rectange1 = Rectangle(Point(0.0,0.0), Point(1.0,1.0))
        val rectange2 = Rectangle(Point(0.0,0.0), Point(1.0,1.0))

        assertTrue(doRectangesOverlap(rectange1,rectange2))
    }

    @Test
    fun differentOrderingOfSameRectanglesReturnsSameResult(){
        val rectange1 = Rectangle(Point(0.0,0.0), Point(1.0,1.0))
        val rectange2 = Rectangle(Point(2.0,0.0), Point(2.0,1.0))

        val result1 = doRectangesOverlap(rectange1,rectange2)
        val result2 = doRectangesOverlap(rectange2, rectange1)

        assertTrue(result1 == result2)
    }

    @Test
    fun Rectangle2LeftOfRectange1ReturnsFalse(){
        val rectange1 = Rectangle(Point(0.0,0.0), Point(1.0,1.0))
        val rectange2 = Rectangle(Point(-2.0,0.0), Point(-1.0,1.0))

        assertFalse(doRectangesOverlap(rectange1,rectange2))
    }

    @Test
    fun Rectangle2RightOfRectange1ReturnsFalse(){
        val rectange1 = Rectangle(Point(0.0,0.0), Point(1.0,1.0))
        val rectange2 = Rectangle(Point(2.0,0.0), Point(3.0,1.0))

        assertFalse(doRectangesOverlap(rectange1,rectange2))
    }

    @Test
    fun Rectangle2BelowRectange1OnRectangle1BoundryReturnsFalse(){
        val rectange1 = Rectangle(Point(0.0,0.0), Point(1.0,1.0))
        val rectange2 = Rectangle(Point(2.0,1.0), Point(3.0,2.0))

        assertFalse(doRectangesOverlap(rectange1,rectange2))
    }

    @Test
    fun Rectangle2FullyInsideRectangle1ReturnsTrue(){
        val rectange1 = Rectangle(Point(0.0,0.0), Point(1.0,1.0))
        val rectange2 = Rectangle(Point(0.5,0.5), Point(0.7,0.7))

        assertTrue(doRectangesOverlap(rectange1,rectange2))
    }

    @Test
    fun Rectangle2PartiallyInsideRectangle1ReturnsTrue(){
        val rectange1 = Rectangle(Point(0.0,0.0), Point(1.0,1.0))
        val rectange2 = Rectangle(Point(0.5,0.5), Point(1.5,1.5))

        assertTrue(doRectangesOverlap(rectange1,rectange2))
    }

}