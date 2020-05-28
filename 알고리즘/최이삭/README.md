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

+ 한 명 빼고 전부 완주했대요.

  + 동명이인일 수 있음.

  + participant를 순회하면서 Object를 이용해서 이름을 key로, value를 그 이름을 가진 사람 수로 저장

  + completion을 순회하면서 Object에서 completion의 사람 이름을 확인 후 감산.

  + value가 0이 된 key는 삭제하고 남아있는 key가 정답이 됨.
