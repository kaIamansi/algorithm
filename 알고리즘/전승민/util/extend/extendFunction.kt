package extend

import java.util.ArrayList

infix fun <A,B,C>Pair<A,B>.to(value : C) = Triple(this.first, this.second, value)

infix fun Int.getMidWith(b: Int) = (this + b) / 2

fun ArrayList<Int>.addNullableInt(number : Int?) = if(number!=null) this.add(number) else false
