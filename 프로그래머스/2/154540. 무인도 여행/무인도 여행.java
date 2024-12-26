import java.util.*;
class Solution {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, -1, 0, 1};
    public int[] solution(String[] maps) {
        ArrayList<Integer> list=new ArrayList<>();
        boolean[][] visited=new boolean[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j)!='X' && !visited[i][j]){
                    visited[i][j]=true;
                    int temporary=maps[i].charAt(j)-'0';
                    Queue<int[]> queue=new LinkedList<>();
                    queue.add(new int[] {i,j});
                    while(!queue.isEmpty()){
                        int[] temp=queue.poll();
                        for(int k=0; k<4; k++){
                            int nx=temp[0]+dx[k];
                            int ny=temp[1]+dy[k];
                            if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length() && !visited[nx][ny] && maps[nx].charAt(ny)!='X'){
                                temporary+=maps[nx].charAt(ny)-'0';
                                visited[nx][ny]=true;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                    list.add(temporary);
                }
            }
        }
        if(list.size()==0){
            return new int[] {-1};
        }
        Collections.sort(list);
        int[] answer=new int[list.size()];
        for(int i=0; i<answer.length; i++) answer[i]=list.get(i);
        return answer;
    }
}