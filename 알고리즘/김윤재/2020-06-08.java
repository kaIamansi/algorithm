import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;


public class Solution {
    private static int MaxQueueElement(Queue<Integer> queue){
        Optional<Integer> max = queue.stream()
                .max(Comparable::compareTo);

        if(max.isPresent()){
            return max.get();
        }
        return -1;
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int priority : priorities) {
            queue.offer(priority);
        }

        while (!queue.isEmpty()) {
            int peekQueue = queue.peek();
            int maxElement = MaxQueueElement(queue);

            if (location == 0 && peekQueue == maxElement) {
                answer += 1;
                return answer;

            } else if (peekQueue == maxElement) {
                queue.poll();
                answer += 1;

            } else {
                int pollQueue = queue.poll();
                queue.offer(pollQueue);
                if (location == 0) {
                    location = queue.size();
                }
            }

            location--;
        }

        return answer;
    }
}

