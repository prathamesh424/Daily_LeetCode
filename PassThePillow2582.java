import java.util.*;


public class PassThePillow2582 {

    /*
     * There are n people standing in a line labeled from 1 to n.
     *  The first person in the line is holding a pillow initially.
     *  Every second, the person holding the pillow passes it to the next person standing in the line.
     *  Once the pillow reaches the end of the line, the direction changes, 
     * and people continue passing the pillow in the opposite direction.
     * 
     * For example, once the pillow reaches the nth person they pass it to the n - 1th person,
     *  then to the n - 2th person and so on.
     * 
     * Given the two positive integers n and time, 
     * return the index of the person holding the pillow after time seconds.
     */

    class Solutoin {
        // by iteration
        public int passThePillow(int n , int time){ 
            int idx = 1 ;
            int curr = 0 ;
            int dir = 1 ;
            while (curr < time){
                if (0 < idx + dir && n >= idx + dir){
                    idx += dir; 
                    curr++;
                }
                else dir *= -1 ;
            }
            return idx ;
        }
            // By Math and Observation ..
        public int OPtimal (int n  , int time) {
            int div = time / (n -1) ;
            int remain = time %  (n-1) ;
            if (div % 2 == 0) return remain+1 ;
            return n -remain ;
        }
    }
}
