import java.util.*;
import java.util.Map;


public class OpenTheLock752 {
    /*You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: 
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around:
     for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
     
     The lock initially starts at '0000', a string representing the state of the 4 wheels.
     
     You are given a list of deadends dead ends, meaning if the lock displays any of these codes, 
     the wheels of the lock will stop turning and you will be unable to open it.
     
     Given a target representing the value of the wheels that will unlock the lock, 
     return the minimum total number of turns required to open the lock, or -1 if it is impossible.

  */

  class Solution {
    public int openLock(String[] deadends, String target) {

        /*for next  Slot calculation  */
        Map<Character, Character> nextSlot = Map.of(
            '0', '1', 
            '1', '2', 
            '2', '3', 
            '3', '4', 
            '4', '5', 
            '5', '6', 
            '6', '7', 
            '7', '8', 
            '8', '9', 
            '9', '0'
        );

        /*previous Slot calculation */
        Map<Character, Character> prevSlot = Map.of(
            '0', '9', 
            '1', '0', 
            '2', '1', 
            '3', '2', 
            '4', '3', 
            '5', '4', 
            '6', '5', 
            '7', '6', 
            '8', '7', 
            '9', '8'
        );


        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> pendingCombination = new LinkedList<String>() ;
        int ans = 0 ;

        /*initial combination is dead-end:  */
        if (visited.contains("0000")) return -1 ;

        pendingCombination.add("0000");
        visited.add("0000") ;

        // Applying BFS :-

        while (!pendingCombination.isEmpty()){
            int currCount = pendingCombination.size() ;
            for (int i = 0; i < currCount; i++) {
                String currStr = pendingCombination.poll();
                
                if (currStr.equals(target)) return ans;

                // Searching for all four wheel :-
                
                for (int j = 0; j < 4 ; j += 1){
                    StringBuilder newCombination = new StringBuilder(currStr) ;
                    newCombination.setCharAt(j, nextSlot.get(newCombination.charAt(j)));

                    if (!visited.contains(newCombination.toString())){
                        pendingCombination.add(newCombination.toString());
                        visited.add(newCombination.toString());
                    }

                    newCombination = new StringBuilder(currStr) ;
                    newCombination.setCharAt(j, prevSlot.get(newCombination.charAt(j)));

                    if (!visited.contains(newCombination.toString())){
                        pendingCombination.add(newCombination.toString());
                        visited.add(newCombination.toString());
                    }   
                }
            }

            ans+=1;
        }
        return -1 ;
    }
}
    
class optimalSolution {
    public int openLock(String[] deadends, String target) {
        int[] pow10 = {1, 10, 100, 1000};
        int[] visit = new int[10000]; // 0: not visited, 1: visited through forward direction, -1: visited through backward direction, 2: deadends
        for(String dead: deadends) {
            visit[Integer.parseInt(dead)] = 2;
        }
        int src = 0, dest = Integer.parseInt(target), steps = 0, dir = 1;
        if(visit[src] == 2 || visit[dest] == 2) return -1;
        if(src == dest) return 0;
        Queue<Integer> forward = new LinkedList<>(), backward = new LinkedList<>();
        forward.add(src);
        visit[src] = 1;
        backward.add(dest);
        visit[dest] = -1;
        while(!forward.isEmpty() && !backward.isEmpty()) {
            if(forward.size() > backward.size()) {
                Queue<Integer> tmp = forward; forward = backward; backward = tmp;
                dir = -dir;
            }
            steps++;
            int size = forward.size();
            while(size-- > 0) {
                int cur = forward.poll();
                for(int p: pow10) {
                    int d = (cur / p) % 10;
                    for(int i = -1; i <= 1; i += 2) {
                        int z = d + i;
                        z = z == -1 ? 9 : (z == 10 ? 0 : z);
                        int next = cur + (z - d) * p;
                        if(visit[next] == -dir) return steps;
                        if(visit[next] == 0) {
                            forward.add(next);
                            visit[next] = dir;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

    
}
