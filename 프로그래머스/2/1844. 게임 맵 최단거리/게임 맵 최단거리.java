import java.util.*;
class Solution {
    static final int[] dx={0, 1, 0, -1};
    static final int[] dy={1, 0, -1, 0};
    public int solution(int[][] maps) {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            for(int i=0; i<4; i++){
                int nx=temp[0]+dx[i];
                int ny=temp[1]+dy[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length && maps[nx][ny]==1){
                    maps[nx][ny]=maps[temp[0]][temp[1]]+1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        if(maps[maps.length-1][maps[0].length-1]<=1) return -1; 
        return maps[maps.length-1][maps[0].length-1];
    }
}