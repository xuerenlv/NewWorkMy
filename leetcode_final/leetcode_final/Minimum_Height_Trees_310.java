package leetcode_final;

import java.util.*;

/**
 * Created by Xuehj on 16/7/8.
 */
public class Minimum_Height_Trees_310 {
    public static void main(String[] a){


    }
}


class Solution_Minimum_Height_Trees_310 {

    public List<Integer> findMinHeightTrees_2(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove((Integer) i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> con_edge[] = new ArrayList[n];
        for(int i =0;i<edges.length;i++){
            if(con_edge[edges[i][0]]==null)
                con_edge[edges[i][0]] = new ArrayList<>();
            if(con_edge[edges[i][1]]==null)
                con_edge[edges[i][1]] = new ArrayList<>();

            con_edge[edges[i][0]].add(edges[i][1]);
            con_edge[edges[i][1]].add(edges[i][0]);
        }

        int small = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            int now_height = HightFromN(i,con_edge);
            if(now_height<small){
                res.clear();
                res.add(i);
                small=now_height;
            }else if(now_height==small){
                res.add(i);
            }
        }

        return res;
    }


    int HightFromN(int root,ArrayList<Integer> con_edge[]){
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        int hight = 0;
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()){
            hight++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                int now_start = queue.poll();
                if(con_edge[now_start]==null)
                    continue;
                for(int j : con_edge[now_start]){
                    if(!visited.contains(j)){
                        visited.add(j);
                        queue.add(j);
                    }
                }
            }
        }

        return  hight;
    }

}
