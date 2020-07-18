function solution(food_times, k) {
    var answer = 0;
    var index = 0;
    if(food_times.reduce((a,b)=>a+b) < k)
        return -1;
    while(1) {
        if(index >= food_times.length)
            index = 0;
        if(food_times[index] > 0) {
            if(k == 0)
                return index + 1;
            food_times[index]--;
            k--;
        }
        index++;
    }
}