import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumNumberOfTasksYouCanAssign2071 {
    /*
     * You have n tasks and m workers. Each task has a strength requirement stored in a 0-indexed integer array tasks, 
             with the ith task requiring tasks[i] strength to complete. 
             The strength of each worker is stored in a 0-indexed integer array workers,
             with the jth worker having workers[j] strength. Each worker can only be assigned to a single task and must have 
             a strength greater than or equal to the task's strength requirement (i.e., workers[j] >= tasks[i]).
    
         Additionally, you have pills magical pills that will increase a worker's strength by strength.
          You can decide which workers receive the magical pills, however, you may only give each worker at most one magical pill.
    
        Given the 0-indexed integer arrays tasks and workers and the integers pills and strength, 
                return the maximum number of tasks that can be completed.
     */
    class Solution {
        public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
            Arrays.sort(tasks);
            Arrays.sort(workers);
            int n = tasks.length, m = workers.length;
            int left = 1, right = Math.min(n, m), ans = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (canAssign(tasks, workers, mid, pills, strength)) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
        
    private boolean canAssign(int[] tasks, int[] workers, int mid, int pills, int strength) {
        int p = pills;
        int m = workers.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int ptr = m -1;
        for (int i = mid - 1; i >= 0; i--) {
            while (ptr >= m - mid && workers[ptr] + strength >= tasks[i]) {
                dq.addFirst(workers[ptr]);
                ptr--;
            }
            if (dq.isEmpty()) {
                return false;
            } else if (dq.getLast() >= tasks[i]) {
                dq.pollLast();
            } else {
                if (p == 0) {
                    return false;
                }
                p--;
                dq.pollFirst();
            }
        }
        return true;
    }

    }



}
