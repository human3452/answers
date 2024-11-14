import java.io.*;
import java.util.*;
public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int[][] board=new int[N][M];
        int cheese=0;
        HashSet<Integer> outside=new HashSet<>();
        outside.add(0);
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j]= Integer.parseInt(st.nextToken());
                cheese+=board[i][j];
            }
        }
        Queue<int[]> queue=new LinkedList<>();
        //BFS
        for(int i=0; i<M; i++){
            if(board[0][i]==0){
                board[0][i]=-1;
                queue.add(new int[]{0, i});
                while(!queue.isEmpty()){
                    int[] temp=queue.poll();
                    for(int j=0; j<4; j++){
                        int nx=temp[0]+dx[j];
                        int ny=temp[1]+dy[j];
                        if(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny]==0){
                            board[nx][ny]=-1;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            if(board[N-1][i]==0){
                board[N-1][i]=-1;
                queue.add(new int[]{N-1, i});
                while(!queue.isEmpty()){
                    int[] temp=queue.poll();
                    for(int j=0; i<4; i++){
                        int nx=temp[0]+dx[j];
                        int ny=temp[1]+dy[j];
                        if(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny]==0){
                            board[nx][ny]=-1;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        for(int i=1; i<N-1; i++){
            if(board[i][0]==0){
                board[i][0]=-1;
                queue.add(new int[]{i, 0});
                while(!queue.isEmpty()){
                    int[] temp=queue.poll();
                    for(int j=0; i<4; i++){
                        int nx=temp[0]+dx[j];
                        int ny=temp[1]+dy[j];
                        if(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny]==0){
                            board[nx][ny]=-1;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            if(board[i][M-1]==0){
                board[i][M-1]=-1;
                queue.add(new int[]{i, M-1});
                while(!queue.isEmpty()){
                    int[] temp=queue.poll();
                    for(int j=0; i<4; i++){
                        int nx=temp[0]+dx[j];
                        int ny=temp[1]+dy[j];
                        if(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny]==0){
                            board[nx][ny]=-1;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        //이제 치즈를 봅시다.
        int time=0;
        while(true){
            time++;
            Queue<int[]> BFS=new LinkedList<>();
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(board[i][j]==1){
                        int counter=0;
                        for(int k=0; k<4; k++){
                            int nx=i+dx[k];
                            int ny=j+dy[k];
                            if(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny]==-1) counter++;
                        }
                        if(counter>=2) {
                            BFS.add(new int[]{i,j});
                            cheese--;
                        }
                    }
                }
            }
            if(cheese==0) break;
            while(!BFS.isEmpty()){
                int[] temp=BFS.poll();
                board[temp[0]][temp[1]]=-1;
                for(int i=0; i<4; i++){
                    int nx=temp[0]+dx[i];
                    int ny=temp[1]+dy[i];
                    if(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny]==0){
                        board[nx][ny]=-1;
                        BFS.add(new int[]{nx, ny});
                    }
                }
            }

        }
        System.out.println(time);
        bw.flush();
        bw.close();
        br.close();
    }
}