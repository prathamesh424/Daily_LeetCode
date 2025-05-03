 
public class MinimumDominoRotationsForEqualRow1007 {
    /*
     * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
    
    We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
    
    Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
    
    If it cannot be done, return -1.
    
    
     */

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int len = tops.length ;
        int req = Integer.MAX_VALUE;                                  
        for (int common = 1 ; common <= 6 ;common++){
            int topRotations = 0, bottomRotations = 0;
            for (int i = 0 ; i < len ; i++){
                if (tops[i] != common && bottoms[i] != common){
                    topRotations = Integer.MAX_VALUE;
                    bottomRotations = Integer.MAX_VALUE;
                    break;
                } else if (tops[i] != common){
                    topRotations++;
                } else if (bottoms[i] != common){
                    bottomRotations++;
                }
            }
            req = Math.min(req, Math.min(topRotations, bottomRotations));
        }
        return req > 0 ? req != Integer.MAX_VALUE? req: -1 : 0;
    }
}
}
