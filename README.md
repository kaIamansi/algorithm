# algorithm

# 알고리즘 스터디

## 주의! 
## 커밋 전 항상 **git status** --> **git pull** or **git fetch**

## 규칙
- 매일 **7시 40분(10교시)** 스터디
- 못풀어도 막힌 풀이를 얘기하기
- 이미 풀었던 문제라면 다른 언어로 시도해보기

## 벌칙
### 다음날 **7시 40분**까지 
#### 벌칙은 고의로 안풀었을 시, 협의를 통해 찬성이 과반수 *이상* 일 때 수행

- 김기강 : 노트북, 핸드폰 배경화면 ***일본 애니메이션***으로 바꾸기
- 권하경 : ***왼손***만 쓰기
- 김해건 : ***핸드폰***압수
- 이규준 : ***앞머리까기***다니기
- 전승민 : ***찍찍***거리기

## 최초설정 
- git init
- git pull --> 이후 git fetch 도 가능
- git add {file name}
- git commit -m {commitmessage}
- git remote add origin https://github.com/kaIamansi/algorithm.git
-git push -u origin master

## 에러 발생시
- mac과 windows 충돌로 인한 CRLF 에러 해결법
### windows 
```
git config --global core.autocrlf true
```
### mac
```
git config --global core.autocrlf input
```