function solution(arr) {
    let answer = new Array();

    answer = arr.filter((item, index, array) => {
        return item != array[index+1];
    });

    return answer;
}