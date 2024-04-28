
public class SumOfDistancesInTree834 {
    /*
     * There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
     * 
     * You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is
       an edge between nodes ai and bi in the tree.

     * Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
     * 
     */
 
            class Solution {
                int[][] graph;
                int[] count;
                int[] res;
                int N;
                
                public int[] sumOfDistancesInTree(int N, int[][] edges) {
                    this.N = N;
                    this.res = new int[N];
                    this.graph = new int[N][];
                    this.count = new int[N];
                    
                    for (int[] e : edges) {
                        ++count[e[0]];
                        ++count[e[1]];
                    }
                    for (int i = 0; i < N; i++) {
                        graph[i] = new int[count[i]];
                    }
                    for (int[] e : edges) {
                        graph[e[0]][--count[e[0]]] = e[1];
                        graph[e[1]][--count[e[1]]] = e[0];
                    }
                    dfs1(0, -1);
                    dfs2(0, -1);
                    return res;
                }
                public void dfs1(int cur, int parent) {
                    count[cur] = 1;
                    for (int child : graph[cur]) {
                        if (child != parent) {
                            dfs1(child, cur);
                            count[cur] += count[child];
                            res[cur] += res[child] + count[child];
                        }
                    }
                }
                public void dfs2(int cur, int parent) {
                    for (int child : graph[cur]) {
                        if (child != parent) {
                            res[child] = res[cur] + N - 2 * count[child];
                            dfs2(child, cur);
                        }
                    }
                }
            }
            
        }
   