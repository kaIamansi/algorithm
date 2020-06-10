function dfs(a, c, v, n) {
  if(c[v] === true) return;
  else {
      c[v] = true;
      for(let i = 0; i < n; i++) {
          if(a[v][i] === 1) {
              dfs(a, c, i, n);      
          }
      }
  }
}

function solution(n, computers) {
  let answer = 0;
  let check = [];
  for(let i = 0; i < n; i++) {
      check.push(false)
  }
  
  for(let i = 0; i < n; i++) {
      if(check[i] === false) {
          dfs(computers, check, i, n);
          answer++;
      }
  }
  return answer;
}