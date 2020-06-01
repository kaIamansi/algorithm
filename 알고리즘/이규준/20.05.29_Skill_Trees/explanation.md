# 20/05/29
- 정답 코드
```python
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

```
- 원래 코드 1
```python
def solution(s, st):
	answer = 0
	s = list(s)
	for i in range(len(st)):
		flag = 0
		for j in range(1, len(s)):
			for k in range(len(st[i])):
				if s[j - 1] is st[i][k]:
					flag = 1
					cnt = 1
					break
				elif s[j] is st[i][k]:
					if cnt != 1:
						break
					else:
						break
		if flag != 0:
			answer += 1
	print(answer)
	return answer
```

- 원래 풀이 2
```python
def solution(skill, skill_trees):
	answer = 0
	flag = 0
	for skill_tree in skill_trees:
		temp = 0
		for j in skill:
			if j in skill_tree:
				if skill[0] not in skill_tree:
					break
				else :
					temp = skill_tree.index(j)
				if temp > skill_tree.index(j):
					break
				temp = skill_tree.index(j)
		else:answer += 1
```

### 풀이
 

```python
for j in skill_trees[i]:
    if j in skill:
	    temp += j
```
- 스킬 트리에서 한글자씩 스킬의 문자열에 비교한다.
- 스킬에 존재하는 문자가 발견 되면 temp에 저장한다.

```python
len_tp = len(temp)
	if temp == skill[0: len_tp]:
		answer += 1
```
- temp의 길이만큼 스킬을 슬라이싱하여 문자열이 같은지 검사한다.


### 오답노트
- 원래 코드1은 skill의 [i] , [i + 1]을 skill_trees[j][k]에 비교하는 것
- 오답이유
    - 스킬의 길이가 4 이상이고, 스킬의 마지막수가 스킬트리의 맨앞일 때 (ex. s = "ASDF", skt = "FGGASD") 예외처리 불가능

- 원래 코드2는 인덱스번호로 비교 
- 오답이유
    - 머리이상으로 인한 구현불능
