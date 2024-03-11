import java.util.*;

public class customSortStr791 {

    // have more time complexity ..
    public String customSortString(String order, String s) {
        int  n = s.length() ;
        Character [] ans  = new Character[n]  ;
        for (int i =0 ;i < n ;i++) ans[i] = s.charAt(i);

        Arrays.sort(ans , (ch1 , ch2) ->{ 
            return order.indexOf(ch1) - order.indexOf(ch2) ;
        }) ;
        String req = "";
        for (Character ch : ans) req += ch ;
        return req ; 
    }

    // trying better one ...
    public String customSortString2(String order, String s) { 
        int [] count = new int[26] ;
        for (int i = 0; i < s.length(); i++) ++count[(int) (s.charAt(i) - 'a')] ;
        
        StringBuilder sb  = new StringBuilder() ;
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i) ;
            int idx = (int) (c - 'a') ;
            int pos=  count[idx] ;
            count[idx] = 0 ;
            if (pos > 0) 
                for (int j = 0; j < pos; j++) 
                    sb.append(c);      
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0){
                char ch = (char) (i + 'a') ;
                for (int j = 0; j < count[i]; j++) sb.append(ch);
            }  
        }
        return sb.toString() ;
    }


    
}
