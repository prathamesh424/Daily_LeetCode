import java.util.Arrays;

public class bagOfTokens948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0 ;
        int l = 0 , e = tokens.length -1 ;
        Arrays.sort(tokens) ;

        while (l <= e) {
            if (power >= tokens[l]){
                power -= tokens[l];
                l+= 1 ;
                score +=1;
            }
            else if(l < e && score >0) {
                score-=1;
                power += tokens[e] ;
                e-=1;
            }
            else  {return score ;}
        }
        return score ;
    }

    public static void main(String[] args) {
        
    }
}
