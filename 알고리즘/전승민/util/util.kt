/*
if action return null, target == mid
if action return true, target > mid
if action return false, target < mid
 */
fun <T>binarySearch(array : List<T>, left : Int, right : Int, target : T, action : (target : T, point : T) -> Boolean?) : Pair<T?, Int> {
    val mid = (left+right)/2
    if(left>=right && array[left]!=target) return array[mid] to -1
    else if(action(target, array[mid])==null) return array[mid] to mid
    else if(action(target, array[mid])!!) return binarySearch(array, mid+1, right, target, action)
    else return binarySearch(array, left, mid-1, target, action)
}

fun <T>lowerBound(array : List<T>, left : Int, right : Int, target : T, action : (target : T, point : T) -> Boolean) : Pair<T?, Int> {
    val mid = (left+right)/2
    if(left>=right && !action(target, array[left])) return array[mid] to mid
    else if(left>=right && action(target, array[mid])) return array[mid] to -1
    else if(action(target, array[mid])) return lowerBound(array, mid+1, right, target, action)
    else return lowerBound(array, left, mid, target, action)
}