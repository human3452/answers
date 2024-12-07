import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static final int[] dx={1, 0, -1, 0};
    static final int[] dy={0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        char[][] board=new char[N][N];
        boolean[][] visited=new boolean[N][N];
        for(int i=0; i<N; i++) {
            String A=br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j]=A.charAt(j);
            }
        }
        //그냥 구하기
        Queue<int[]> BFS=new LinkedList<>();
        int answer=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    answer++;
                    visited[i][j]=true;
                    char standard=board[i][j];
                    BFS.add(new int[]{i, j});
                    while(!BFS.isEmpty()){
                        int[] temp=BFS.poll();
                        for(int delta=0; delta<4; delta++){
                            int nx=temp[0]+dx[delta];
                            int ny=temp[1]+dy[delta];
                            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && board[nx][ny]==standard){
                                visited[nx][ny]=true;
                                BFS.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        int secondanswer=0;
        visited=new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    secondanswer++;
                    visited[i][j]=true;
                    boolean isBlue= board[i][j] == 'B';
                    BFS.add(new int[]{i, j});
                    while(!BFS.isEmpty()){
                        int[] temp=BFS.poll();
                        for(int delta=0; delta<4; delta++){
                            int nx=temp[0]+dx[delta];
                            int ny=temp[1]+dy[delta];
                            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && isBlue==(board[nx][ny]=='B')){
                                visited[nx][ny]=true;
                                BFS.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        bw.write(answer+" "+secondanswer);
        bw.flush();
        bw.close();
        br.close();
    }
}