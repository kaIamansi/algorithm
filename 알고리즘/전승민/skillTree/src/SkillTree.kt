fun solution(skill: String, skill_trees: Array<String>): Int
        = with(checkSkillSequence(skill)) {
    var result = 0
    for (s: String in skill_trees) {
        if (isCollectSkillTree(this, s)) result++
    }
    result
}

fun checkSkillSequence(skill: String): Array<Int?> =
        arrayOfNulls<Int>(26).apply {
            var count = 1
            skill.forEach {
                this[getAlphabetIndex(it)] = count++
            }
        }

fun getAlphabetIndex(c: Char) = c.toInt() - 65

fun isCollectSkillTree(alphabetArr: Array<Int?>, skill: String): Boolean {
    var count = 1
    skill.forEach {
        if (alphabetArr[getAlphabetIndex(it)] ?: 0 > count) {
            return false
        } else if(alphabetArr[getAlphabetIndex(it)] ?: 0 == count) {
            count++
        }
    }
    return true
}

//https://programmers.co.kr/learn/courses/30/lessons/49993
