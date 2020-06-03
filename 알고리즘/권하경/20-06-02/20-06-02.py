def solution(board, moves):
    answer = 0
    arr = []
    for element in moves:
      for items in board:
        if items[element-1]:
          arr.append(items[element-1])
          items[element-1]=0
          break
        
      if len(arr)>1 and arr[len(arr)-1]==arr[len(arr)-2]:
        arr.pop()
        arr.pop()
        answer+=1
                
    return answer*2