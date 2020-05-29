def solution(skill, skill_trees):
    answer = len(skill_trees)

    for input_skills in skill_trees:
        index = 0

        for input_skill in input_skills:
            if input_skill in skill and input_skill is not skill[index]:
                answer -= 1
                break

            if len(skill) == index:
                break

            if input_skill == skill[index]:
                index += 1

    return answer