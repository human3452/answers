import java.util.*;
class Solution {
    static int[] subtree;
    static HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        subtree=new int[n+1];
        visited=new boolean[n+1];
        for(int i=0; i<wires.length; i++){
            if(!map.containsKey(wires[i][0])) map.put(wires[i][0], new ArrayList<Integer>());
            if(!map.containsKey(wires[i][1])) map.put(wires[i][1], new ArrayList<Integer>());
            map.get(wires[i][0]).add(wires[i][1]);
            map.get(wires[i][1]).add(wires[i][0]);
        }
        visited[1]=true;
        dp(1);
        int min=99999999;
        for(int i=0; i<wires.length; i++){
            int tmp=Math.min(subtree[wires[i][0]], subtree[wires[i][1]]);
            min=Math.min(min, Math.abs(tmp-(n-tmp)));
        }
        return min;
    }
    public void dp(int root){
        int temp=1;
        for(int a:map.get(root)){
            if(!visited[a]){
                visited[a]=true;
                dp(a);
                temp+=subtree[a];
            }
        }
        subtree[root]=temp;
    }
}