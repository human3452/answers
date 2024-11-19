import java.io.*;
import java.util.*;
public class Main {
    static int min=Integer.MAX_VALUE;
    static final int[] dx={0, 1, 0, -1};
    static final int[] dy={-1, 0, 1, 0};
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        boolean[][][] visited=new boolean[N][M][64];
        char[][] board=new char[N][M];
        Queue<int[]> BFS=new LinkedList<>();
        for(int i=0; i<N; i++){
            String temp=br.readLine();
            for(int j=0; j<M; j++){
                board[i][j]=temp.charAt(j);
                if(board[i][j]=='0'){
                    BFS.add(new int[]{i, j, 0, 0});// x, y, key, distance
                    visited[i][j][0]=true;
                }
            }
        }

        while(!BFS.isEmpty()){
            int[] temp=BFS.poll();
            for(int i=0; i<4; i++){
                int nx=temp[0]+dx[i];
                int ny=temp[1]+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny]!='#' && !visited[nx][ny][temp[2]]){
                    visited[nx][ny][temp[2]]=true;
                    if(board[nx][ny]=='1'){
                        min=Math.min(min, temp[3]+1);
                    }else if(board[nx][ny]-'a'>=0 && board[nx][ny]-'a'<6){
                        visited[nx][ny][temp[2]]=true;
                        if(((int)Math.pow(2, board[nx][ny]-'a') & temp[2])==0){
                            BFS.add(new int[]{nx, ny, temp[2]+(int)Math.pow(2, board[nx][ny]-'a'), temp[3]+1});
                        }else{
                            BFS.add(new int[]{nx, ny, temp[2], temp[3]+1});
                        }
                    }else if(board[nx][ny]-'A'>=0 && board[nx][ny]-'A'<6){
                        if(((int)Math.pow(2, board[nx][ny]-'A') & temp[2])!=0){
                            visited[nx][ny][temp[2]]=true;
                            BFS.add(new int[]{nx, ny, temp[2], temp[3]+1});
                        }
                    }else{
                        BFS.add(new int[]{nx, ny, temp[2], temp[3]+1});
                    }
                }
            }
        }
        if(min==Integer.MAX_VALUE) min=-1;
        System.out.println(min);
        bw.flush();
        bw.close();
        br.close();
    }
}