package net.marksheehan.shape.backend.datamodel

data class Point(val x : Double, val y : Double){

    override fun toString(): String {
        return "[$x, $y]"
    }

}
