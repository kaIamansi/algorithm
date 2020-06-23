fun skillTree(skill: String, skill_trees: Array<String>): Int
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
                this[it.index] = count++
            }
        }

fun isCollectSkillTree(alphabetArr: Array<Int?>, skill: String): Boolean {
    var count = 1
    skill.forEach {
        if (alphabetArr[it.index] ?: 0 > count) {
            return false
        } else if(alphabetArr[it.index] ?: 0 == count) {
            count++
        }
    }
    return true
}

//https://programmers.co.kr/learn/courses/30/lessons/49993
