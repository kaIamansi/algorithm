## algorithm workspace



# 2020/05/27

[소스코드](./TileOrnament.js)

+ 정사각형의 타일을 합쳐서 나선 모양처럼 점점 큰 타일을 붙인 형태의 작품을 만들었다고 함.

  + 정사각형 한 변의 크기는 1, 1, 2, 3, 5, 8로 계속 나열 됨.

  + a<sub>n</sub> = a<sub>n-1</sub> + a<sub>n-2</sub>

  + 피보나치 수열과 같음.

    

  + 우리가 구하는 것은 N번째의 한 변의 크기가 아닌, N번째의 둘레를 구하는 것.

  + 직사각형의 둘레는 (가로+세로)*2

    

  + 따라서 N+1번째의 한 변의 크기와 N번째의 한 변의 크기를 구하면 해결됩니다.

# 2020/05/28

[소스코드](./UncompletedPlayer.js)

+ 들어오지 못한 놈 색출.

  + 동명이인일 수 있음.

  + participant를 순회하면서 Object를 이용해서 이름을 key로, value를 그 이름을 가진 사람 수로 저장

  + completion을 순회하면서 Object에서 completion의 사람 이름을 확인 후 감산.

  + value가 0이 된 key는 삭제하고 남아있는 key가 정답이 됨.


# 2020/05/29

[소스코드](./SkillTree.js)

+ 찍을 수 있는 스킬트리 찾기.

  + skill_trees에서 skill에 있는 순서에 맞게 인덱스를 부여함

  + skill_trees를 순회 시 인덱스가 0에서 부터 1씩 증가하는 꼴이 아니면 flag를 false로 설정하여 답이 아님을 알림

  + skill_trees를 순회 하면서 현재 skill_trees[i]의 값이 최대 인덱스라면 종료 후 answer 증가

# 2020/06/01

[소스코드](./BestAlbum.js)

+ 장르 당 최대 2개씩 앨범 찾기.

  + 가장 많이 재생된 장르를 기준으로 추천.

  + 장르 중 가장 많이 상위 재생된 곡 2개 인덱스.

# 2020/06/02

[소스코드](./ClawMachineGame.js)

+ board에서 열 별로 처음으로 인형이 존재하는 인덱스를 저장.

+ moves를 순회하면서 위에서 만들어진 인덱스를 참조하여 인형을 꺼냄.

+ 인형을 꺼냈다면 인덱스를 증가.

+ 현 인형과 이전 인형이 같다면 pop() 2회와 정답 2증가

# 2020/06/03

[소스코드](./Origami.js)

+ 규칙을 찾아보니 이전 배열에서 0을 추가하고 이전 배열의 mid를 1로 설정해서 추가하면 풀리는 문제였음.

# 2020/06/08

[소스코드](./Printer.js)

+ 배열의 0번 인덱스와 그 배열에서 0번 인덱스보다 큰 값이 있는지 없는지 판단하여 분기를 나눔.

  + 만약 0번 인덱스보다 큰 값이 없고, target의 location의 값이 0이라면 print순서를 찾았으니 재귀 탈출.

  + 0번 인덱스보다 큰 값은 없으나, target의 location의 값이 0이 아니라면 프린트 횟수를 증가한 후 location의 값을 1 줄이고 재귀 수행.

  + 만약 0번 인덱스보다 큰 값이 있고, target의 location의 값이 0이라면 맨 뒤로 이동하는 값을 넣고 재귀 수행.

  + 0번 인덱스보다 큰 값이 있으나, target의 location의 값이 0이 아니라면 location의 값을 1 줄이고 재귀 수행.

  + 결국 모든 재귀가 수행되고 나서 정답을 도출할 수 있음.

# 2020/06/09

[소스코드](./WorkoutClothes.js)

+ 체육복 도둑맞은 사람 번호와 여분 체육복을 가지고 있는 번호를 key로 두는 Object를 만듦.

+ 체육복 도둑맞은 사람 번호 배열을 순회하면서 엘리먼트 값을 이용해 Object를 참조

  + 먼저 잃어버린 사람이 여분 옷을 가지고 있는지 체크

  + 이후 잃어버린 사람의 앞번호가 여분 옷을 가지고 있고, 앞번호가 체육복을 잃어버리진 않았는지 체크

  + 위 조건에 부합하지 않으면 이후 잃어버린 사람의 뒷 버호가 여분 옷을 가지고 있고, 뒷 번호가 체육복을 잃어버리진 않았는지 체크

+ 이 과정을 다 진행 후 lost_obj의 keys.lenght를 구한 뒤 n에서 빼주면 정답.

# 2020/06/10

[소스코드 (JS)](./Network/Network.js)
[소스코드 (Python)](./Network/Network.py)

+ dps를 이용하여 풀이.

  + 이미 2차원 배열 (인접리스트)로 인자가 넘겨오기에 따로 그래프를 만들 필요 없음.

  + dps를 이용하여 탐색할 때, 해당 원소를 다녀갔는지 확인하기 위해 visit을 사용, 현 원소의 위치를 확인하기 위해 index 사용.

  + 해당 index를 참조했다면 visit[index] = true로 만들어 줌으로 다녀감을 확인함.

  + computers[i][j]를 참조하면서 1이라면 연결된 것으로 간주하게 되니 j에 해당하는 행부터 dps를 다시 돌림.

  + 연결된 모든 자료들의 탐색 끝났다면, 연결되지 않는 인덱스를 참조하여 count를 증가시킴.

  + 그렇게 모든 탐색이 끝나고 정답이 출력.

# 2020/06/12

[소스코드](./WordTranslate.js)

+ dps를 이용하여 풀이.

  + 따로 인접 리스트나 인접 행렬로 만들지 않았음.

  + 배열을 순회하면서 visit이 false이면서 차이나는 문자가 1자라면 해당 문자에서 dps 탐색을 진행함.

  + 들어갈 때는 true, 순회 후 나올 떄는 false로 바꿔주면서 해당 문자열에서 다른 길을 찾을 수 있도록 함.

  + 초기 최대 access는 51이고, 나올 수 없는 숫자임. 순회하면서 타겟을 발견하면 1을 리턴하면서 접근 횟수 만큼 1씩 더한 값과 비교하여 최소 접근 횟수를 리턴

  + 최후 리턴 값이 51이면 타겟을 발견하지 못한 것으로 간주하고 0 리턴

# 2020/06/25

[소스코드](./SteppingStoneCrossing.js)

+ 이진 탐색을 이용한 풀이.
  + 1~200,000,000이 answer가 될 수 있는 범위임.
  + 이진 탐색을 통해 0이 연속으로 k개 만큼 나타나면 right의 값을 바꾸고, 나타나지 않는다면 left의 값을 바꿈으로 조건을 달성하는 최소 값을 찾아낸다.

# 2020-07-09

## 폰켓몬

[소스코드](./Phoneketmon.js)

+ 배열을 Set에 넣음.
  + 원 배열의 크기 / 2가 Set.size보다 작으면 Set.size를, 아니라면 원 배열의 크기 / 2를 반환.

## 단어 끝말잇기

[소스코드](./EnglishWordChaining.js)

+ 단어를 Map에 넣고, Map에 등재된 것을 입력한다면 그에 맞는 답을 출력.
  + 순환 횟수에서 n을 나눈 나머지를 구하면 n번째 사람임을 알 수 있고,
  순환 횟수에서 n을 나눈 몫을 구하면 몇 번째 차례임을 알 수 있음.

## 숫자 야구

[소스코드](./NumberBaseball.js)

+ 123~987까지 순환
  + 0이 들어가거나 겹치는 수가 있다면 조건 탈출.
  + 모든 조건에 부합하다면 카운팅.