def solution(skill, skill_trees):
	answer = 0

	for i in range(len(skill_trees)):
		temp = ""
		for j in skill_trees[i]:

			if j in skill:
				temp += j

		len_tp = len(temp)
		if temp == skill[0: len_tp]:
			answer += 1

	return answer
