import java.util.*;
class Solution {
    static final int[] dx={0, 1, 0, -1};
    static final int[] dy={1, 0, -1, 0};
    public int solution(String[] board) {
        boolean[][] visited=new boolean[board.length][board[0].length()];
        int x=0, y=0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length(); j++){
                if(board[i].charAt(j)=='R'){
                    x=i;
                    y=j;
                    break;
                }
            }
        }
        visited[x][y]=true;
        Queue<int[]> BFS=new LinkedList<>(); // 0-x, 1-y, 2-depth, 3-gear
        for(int i=0; i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length() && board[nx].charAt(ny)!='D'){
                BFS.add(new int[] {x, y, 1, i});
            }
        }
        while(!BFS.isEmpty()){
            int[] temp=BFS.poll();
            while(temp[0]+dx[temp[3]]>=0 && temp[0]+dx[temp[3]]<board.length && temp[1]+dy[temp[3]]>=0 && temp[1]+dy[temp[3]]<board[0].length() && board[temp[0]+dx[temp[3]]].charAt(temp[1]+dy[temp[3]])!='D'){
                temp[0]+=dx[temp[3]];
                temp[1]+=dy[temp[3]];
            }
            if(visited[temp[0]][temp[1]]) continue;
            if(board[temp[0]].charAt(temp[1])=='G') return temp[2];
            visited[temp[0]][temp[1]]=true;
            for(int i=0; i<4; i++){
                if(temp[3]%2==i%2) continue;
                int nx=temp[0]+dx[i];
                int ny=temp[1]+dy[i];
                if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length() && board[nx].charAt(ny)!='D'){
                    BFS.add(new int[] {temp[0], temp[1], temp[2]+1, i});
                }
            }
        }
        return -1;
    }
}