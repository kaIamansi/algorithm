# 20/05/30 ~ 06/01
- 정답이고 싶었던 코드
```python
def semi_solution(genres, plays, sorted_dict):
    answer = []
    
    for key in sorted_dict.keys():
        if len(sorted_dict[key]) == 2:
            answer.append(plays.index(sorted_dict[key][0]))
            plays[plays.index(sorted_dict[key][0])] = 500000
        else :                                       
            for i in range(len(sorted_dict[key]) - 2, len(sorted_dict[key]) - 4,  -1):
                for j in range(len(genres)):
                    if sorted_dict[key][i] == plays[j] and key == genres[j]:
                        #answer.append(plays.index(sorted_dict[key][i]))
                        answer.append(j)
                        plays[j] = 5000000
                        break
    return answer
    
def sort_dict(album_dict):
    for key in album_dict.keys():
        album_dict[key].append(sum(album_dict[key]))
        album_dict[key] = sorted(album_dict[key])
    
    album_dict = dict(sorted(album_dict.items(), key=lambda e : e[-1], reverse=True))
    
    return album_dict

def create_dict(genres, plays):
    album_dict = {}
    
    for key, value in zip(genres, plays):
        if key in album_dict:
            album_dict[key].append(value)
            
        else :
            album_dict[key] = [value]
    
    return album_dict
    
def solution(genres, plays):
    album_dict = create_dict(genres, plays)
    sorted_dict = sort_dict(album_dict)
    answer = semi_solution(genres, plays, sorted_dict)
    
    
    return answer
```


### 풀이
 

```python
def create_dict(genres, plays):
    album_dict = {}
    
    for key, value in zip(genres, plays):
        if key in album_dict:
            album_dict[key].append(value)
            
        else :
            album_dict[key] = [value]
    
    return album_dict
```
- 장르와 횟수를 장르를 기준으로 횟수가 중복가능하게 dictionary형으로 만들었다.


```python
def sort_dict(album_dict):
    for key in album_dict.keys():
        album_dict[key].append(sum(album_dict[key]))
        album_dict[key] = sorted(album_dict[key])
    
    album_dict = dict(sorted(album_dict.items(), key=lambda e : e[-1], reverse=True))
    
    return album_dict
```
- 1.dict으로 만든 앨범의 각각의 value 끝에 해당 key의 value들을 더해 추가한다.
- 2.value끝에 합계를 기준으로 정렬 key값을 정렬
- 3.key값이 정렬된 dict의 value를 다시 정렬

```python
def semi_solution(genres, plays, sorted_dict):
    answer = []
    
    for key in sorted_dict.keys():
        if len(sorted_dict[key]) == 2:
            answer.append(plays.index(sorted_dict[key][0]))
            plays[plays.index(sorted_dict[key][0])] = 500000
        else :                                       
            for i in range(len(sorted_dict[key]) - 2, len(sorted_dict[key]) - 4,  -1):
                for j in range(len(genres)):
                    if sorted_dict[key][i] == plays[j] and key == genres[j]:
                        #answer.append(plays.index(sorted_dict[key][i]))
                        answer.append(j)
                        plays[j] = 5000000
                        break
    return answer
```
- 정렬된 dict의 key의 value를 역순으로 2번씩만 value의 값과 일치하고 key와 장르의 이름이 동일할 때만 answer에 index를 추가하고 해당 play를 5000000으로 바꿔줌

### 오답노트
- 이유를 모르겠음...