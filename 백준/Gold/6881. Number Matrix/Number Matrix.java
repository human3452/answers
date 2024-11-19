import java.io.*;
import java.util.*;
public class Main {
    static final int[] dx={0, 1, 0, -1};
    static final int[] dy={-1, 0, 1, 0};
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int M= Integer.parseInt(st.nextToken());
        int N= Integer.parseInt(st.nextToken());
        int[] min=new int[3];
        int[][] board=new int[N][M];
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> BFS=new LinkedList<>();
        boolean[][] visited=new boolean[N][M];
        for(int i=0; i<10; i++){
            for(int j=0; j<M; j++){
                if(board[0][j]==i && board[1][j]==i){
                    BFS.add(new int[]{1,j});
                    visited=new boolean[N][M];
                    visited[1][j]=true;
                    while(!BFS.isEmpty()){
                        int[] temp=BFS.poll();
                        for(int p=0; p<4; p++){
                            int nx=temp[0]+dx[p];
                            int ny=temp[1]+dy[p];
                            if(nx>=1 && nx<N && ny>=0 && ny<M && board[nx][ny]==i && !visited[nx][ny]){
                                visited[nx][ny]=true;
                                if(nx==N-1){
                                    System.out.println("0 0 "+i);
                                    System.exit(0);
                                }
                                BFS.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        for(int i=0; i<9; i++){
            for(int k=i+1; k<10; k++) {
                for (int j = 0; j < M; j++) {
                    if ((board[0][j] == i || board[0][j]==k) && (board[1][j] == i || board[1][j]==k)) {
                        BFS.add(new int[]{1, j});
                        visited=new boolean[N][M];
                        visited[1][j] = true;
                        while (!BFS.isEmpty()) {
                            int[] temp = BFS.poll();
                            for (int p = 0; p < 4; p++) {
                                int nx = temp[0] + dx[p];
                                int ny = temp[1] + dy[p];
                                if (nx >= 1 && nx < N && ny >= 0 && ny < M && (board[nx][ny] == i || board[nx][ny]==k) && !visited[nx][ny]) {
                                    visited[nx][ny] = true;
                                    if (nx == N - 1) {
                                        System.out.println("0 "+i+" "+k);
                                        System.exit(0);
                                    }
                                    BFS.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i=0; i<8; i++){
            for(int k=i+1; k<9; k++) {
                for(int g=k+1; g<10; g++) {
                    for (int j = 0; j < M; j++) {
                        if ((board[0][j] == i || board[0][j] == k || board[0][j]==g) && (board[1][j] == i || board[1][j] == k || board[1][j]==g)) {
                            visited=new boolean[N][M];
                            BFS.add(new int[]{1, j});
                            visited[1][j] = true;
                            while (!BFS.isEmpty()) {
                                int[] temp = BFS.poll();
                                for (int p = 0; p < 4; p++) {
                                    int nx = temp[0] + dx[p];
                                    int ny = temp[1] + dy[p];
                                    if (nx >= 1 && nx < N && ny >= 0 && ny < M && (board[nx][ny] == i || board[nx][ny] == k || board[nx][ny]==g) && !visited[nx][ny]) {
                                        visited[nx][ny] = true;
                                        if (nx == N - 1) {
                                            System.out.println(i+" "+k+" "+g);
                                            System.exit(0);
                                        }
                                        BFS.add(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("-1 -1 -1");

        bw.flush();
        bw.close();
        br.close();
    }
}