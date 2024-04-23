import java.util.* ;
import java.util.Map;

public class MinimumHeightTrees310 {
    /*
     * A tree is an undirected graph in which any two vertices are connected by exactly one path.
     *  In other words, any connected graph without simple cycles is a tree.
     
     * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi]
     *  indicates that there is an undirected edge between the two nodes ai and bi in the tree,
     *  you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h.
     *  Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

     Return a list of all MHTs' root labels. You can return the answer in any order.
     
     The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
     */


    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1) return Collections.singletonList(0) ;

            int [] cnt = new int[n];

            Map<Integer , List<Integer>> adjMatrix = new HashMap<>() ;
            for (int []edge : edges){
                cnt[edge[0]]++;
                cnt[edge[1]]++;
                adjMatrix.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                adjMatrix.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }

            Queue<Integer> visited = new LinkedList<>();
            for (int i = 0; i < n; i++) 
                    if (cnt[i] == 1 )
                        visited.add(i);

            int remain = n ;
            while (remain > 2){
                int size = visited.size() ;
                remain -= size ;
                for (int i = 0; i < size; i++) {
                    int node = visited.poll() ;
                    for (int neigh : adjMatrix.get(node))
                        if (--cnt[neigh] == 1)
                            visited.add(neigh);
                }     
            }
            return new ArrayList<>(visited);
        }

    }
}
