import java.util.* ;

public class LexicographicalNumbers386 {
    class Solution {
        public List<Integer> lexicalOrder(int n) { 
            List<Integer> result = new ArrayList<>();
            for(int i = 1; i <= 9; i++) {
                dfs(i, n, result);
            }
            return result;
        }

        private void dfs(int i, int n, List<Integer> result) {
            if(i > n) return;
            result.add(i);
            for(int j = 0; j <= 9; j++) {
                dfs(i * 10 + j, n, result);
            }
        }

    }


    // improve performance : -
    class SolutionOptimal {
        public List<Integer> lexicalOrder(int n) { 
                List<Integer> result = new ArrayList<>();
                for(int i = 1; i <= 9; i++) {
                    dfs(i, n, result);
                }
                return result;
            }
            private void dfs(int i, int n, List<Integer> result) {
                if(i > n) return;
                result.add(i);
                for(int j = 0; j <= 9; j++) {
                    int next = i*10 + j ;
                    if(next <= n) dfs(next, n, result); 
                    else break ;
                }
            }
    }
}
