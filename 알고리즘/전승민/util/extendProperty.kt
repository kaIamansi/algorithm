val Int.nagative : Int
    get() = this * -1

val Char.index : Int
    get() = (this.toUpperCase() - 65).toInt()