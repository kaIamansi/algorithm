# algorithm

# 알고리즘 스터디

## 규칙.

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
