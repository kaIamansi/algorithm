function solution(array, commands) {
    let arr = [];
    let temp = [];
    
    commands.forEach((item, index) => {
        temp = array.slice(item[0]-1, item[1]);
        temp.sort((a, b) => a - b);
        arr.push(temp[item[2]-1]);
    })
    
    return arr;       
}