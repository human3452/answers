import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        boolean[] visited=new boolean[y+1];
        if(x==y) return 0;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x, 0});
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            if(temp[0]==y){
                return temp[1];
            }
            int twice=temp[0]*2;
            int triple=temp[0]*3;
            int plus=temp[0]+n;
            if(twice<=y){
                if(!visited[twice]){
                    queue.add(new int[]{twice, temp[1]+1});
                    visited[twice]=true;
                }
            }
            if(triple<=y){
                if(!visited[triple]){
                    queue.add(new int[]{triple, temp[1]+1});
                    visited[triple]=true;
                }
            }
            if(plus<=y){
                if(!visited[plus]){
                    queue.add(new int[]{plus, temp[1]+1});
                    visited[plus]=true;
                }
            }
        }
        return -1;
    }
}