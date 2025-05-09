


public class LargestNumberInKSwaps {
    /*
     * Given a number k and string s of digits denoting a positive integer,
             *  build the largest number possible by performing swap operations on the digits of s at most k times.
     */

     class Solution {
        String max = "";
    
        public String findMaximumNum(String s, int k) {
            max = s;
            findMaximumNumUtil(s.toCharArray(), k, 0);
            return max;
        }
    
        private void findMaximumNumUtil(char[] arr, int k, int index) {
            if (k == 0 || index == arr.length) {
                return;
            }
    
            char maxChar = arr[index];
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i] > maxChar) {
                    maxChar = arr[i];
                }
            }
    
            if (maxChar != arr[index]) {
                for (int i = index + 1; i < arr.length; i++) {
                    if (arr[i] == maxChar) {
                        swap(arr, index, i);
                        String current = new String(arr);
                        if (current.compareTo(max) > 0) {
                            max = current;
                        }
                        findMaximumNumUtil(arr, k - 1, index + 1);
                        swap(arr, index, i); // backtrack
                    }
                }
            } else {
                findMaximumNumUtil(arr, k, index + 1);
            }
        }
    
        private void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
}
