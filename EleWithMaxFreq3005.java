public class EleWithMaxFreq3005 {


    public int maxFrequencyElements(int[] nums) {
        int [] arr = new int [101] ;
        int highfrq = 0;
        int count = 0;
        int max = 0 ;
            // counting highest frequency , max element 
        for (int num : nums) {
            arr[num]++ ;
            highfrq = Math.max (highfrq , arr[num]);
            max = Math.max(max , num) ;
        }
        // loop till max element to find the count of same frquency elements ..

        for (int i = 0 ;  i < max +1 ; i++ ){
            if (highfrq == arr[i]) {
                count++ ;
            }
        }
            // returning the ans count * highest frequncy ....
            
        return count*highfrq ;
    }

    public static void main(String[] args) {
        
    }
}
