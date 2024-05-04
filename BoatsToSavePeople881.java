import java.util.Arrays;

public class BoatsToSavePeople881 {
    /*
     * You are given an array people where people[i] is the weight of the ith person,
     *  and an infinite number of boats where each boat can carry a maximum weight of limit.
     *  Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
     * 
     * Return the minimum number of boats to carry every given person.
     */

    class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans  = 0 ;
        Arrays.sort(people) ;
        int i =people.length-1 ;
        int s = 0;
        while (s <= i){
            if(people[s] + people[i] <= limit) 
                s++;
            i--;
            ans++;
        }
        return ans ;
        
    }
}
}
