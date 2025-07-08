import java.util.*;


/*
 * Given an array arr[] of integers, for each element, find the closest (distance wise) to its right that has a higher frequency than the current element.
If no such element exists, return -1 for that position.
 */


//Solution :-- 
/* 
 * 1. Count the frequency of each element in the array using a HashMap.
 * 2. Use a Stack to keep track of indices of elements in the array.
 * 3. Iterate through the array:
 *   - For each element, while the stack is not empty and the frequency of the current element is greater than the frequency 
 *          of the element at the index stored at the top of the stack, pop from the stack and set the result for that index to the current element.
 * { So basically we saving the answers for the previous elements in the stack. }
 *  - Push the current index onto the stack.
 * 4. After processing all elements, if any indices remain in the stack, set their results to -1.
 * 5. Convert the result array to an ArrayList and return it.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class NextElementWithGreaterFrequency {
    class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int len = arr.length ;
        HashMap<Integer , Integer > map  =  new HashMap<>() ;
        for (int i : arr) {
            map.put(i , map.getOrDefault(i , 0 ) + 1);
        }
        Stack<Integer> stack = new Stack<>() ;
        int res [] = new int [len] ;
        Arrays.fill(res, -1);
        
        for (int i = 0 ; i < len ; i++) {
            
            while (!stack.isEmpty() &&  map.get(arr[i])  >
                map.get(arr[stack.peek()])){
                    
                    res[stack.pop()] = arr[i] ;
                }
                stack.push(i) ;
        }
        
        ArrayList<Integer> ans = new  ArrayList<Integer>() ;
        for (int i : res) {
            ans.add(i) ;
        }
        
        return ans ; 
    }
}
}