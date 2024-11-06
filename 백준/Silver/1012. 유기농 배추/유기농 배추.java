import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int M= Integer.parseInt(st.nextToken());
            int N= Integer.parseInt(st.nextToken());
            int K= Integer.parseInt(st.nextToken());
            boolean[][] board=new boolean[M][N];
            for(int i=0; i<K; i++){
                st=new StringTokenizer(br.readLine());
                board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=true;
            }
            int answer=0;
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(board[i][j]){
                        answer++;
                        board[i][j]=false;
                        Queue<int[]> queue=new LinkedList<>();
                        queue.add(new int[]{i,j});
                        while(!queue.isEmpty()){
                            int[] temp=queue.poll();
                            for(int k=0; k<4; k++){
                                int nx=temp[0]+dx[k];
                                int ny=temp[1]+dy[k];
                                if(nx>=0 && nx<M && ny>=0 && ny<N && board[nx][ny]){
                                    board[nx][ny]=false;
                                    queue.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
