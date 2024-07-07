import java.util.*;


 
public class WaterBottles1518 {

    /*
     * There are numBottles water bottles that are initially full of water.
     *  You can exchange numExchange empty water bottles from the market with one full water bottle.
     * 
     * The operation of drinking a full water bottle turns it into an empty bottle.
     * 
     * Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.
     */
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int ans = numBottles ;
            int div = numBottles / numExchange ;
            ans += div ;
            int remain = numBottles % numExchange ;
            while ( div >= 1){
                int curr = (div + remain) / numExchange ;
                remain = (div + remain) % numExchange ;
                ans += curr ; 
                div = curr ; 
            }
            return ans ;
        } 
    }
    
}