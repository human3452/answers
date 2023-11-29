import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int[][] board;
    static long answer=0, rainbow=0;
    static ArrayList<int[]> maxList;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        board=new int[N][N];
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        while(true){
            maxList=new ArrayList<>();
            rainbow=0;
            //가장 큰 친구 찾기
            find();
            //만약 블록 없으면 탈출
            if(maxList.size()<2) break;
            //지우기
            answer+=Math.pow(maxList.size(), 2);
            for(int i=0; i< maxList.size(); i++){
                int[] temp=maxList.get(i);
                board[temp[0]][temp[1]]=-2;
            }
            //중력
            falling();
            //회전회오리ㅣㅣㅣㅣㅣㅣ
            spin();
            falling();
        }
        System.out.println(answer);
    }

    private static void spin() {
        int[][] newboard=new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                newboard[N-1-j][i]=board[i][j];
            }
        }
        board=newboard;
    }

    private static void falling() {
        for(int i=0; i<N; i++){
            Stack<Integer> stack=new Stack<>();
            for(int j=0; j<N; j++){
                switch (board[j][i]){
                    case -1:
                        int pointer=j-1;
                        while(!stack.isEmpty()){
                            board[pointer][i]=stack.pop();
                            pointer--;
                        }
                        break;
                    case -2:
                        break;
                    default:
                        stack.add(board[j][i]);
                        board[j][i]=-2;
                        break;
                }
            }
            int pointer=N-1;
            while(!stack.isEmpty()){
                board[pointer][i]=stack.pop();
                pointer--;
            }
        }
    }

    private static void find() {
        boolean visited[][]=new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j]>0){
                    //bfs
                    ArrayList<int[]> queue=new ArrayList<>();
                    queue.add(new int[]{i,j});
                    int pointer=0;
                    int base=board[i][j];
                    visited[i][j]=true;
                    Queue<int[]> restore=new LinkedList<>();
                    while(pointer<queue.size()){
                        int[] temp=queue.get(pointer);
                        for(int gear=0; gear<4; gear++){
                            int nx=temp[0]+dx[gear];
                            int ny=temp[1]+dy[gear];
                            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                                if(board[nx][ny]==0){
                                    restore.add(new int[]{nx,ny});
                                    queue.add(new int[]{nx,ny});
                                    visited[nx][ny]=true;
                                }else if(board[nx][ny]==base){
                                    queue.add(new int[]{nx,ny});
                                    visited[nx][ny]=true;
                                }
                            }
                        }
                        pointer++;
                    }
                    if(maxList.size()<queue.size()){
                        maxList=queue;
                        rainbow= restore.size();
                    }else if(maxList.size()== queue.size()){
                        if(rainbow<=restore.size()){
                            maxList=queue;
                            rainbow= restore.size();
                        }
                    }
                    while(!restore.isEmpty()){
                        int[] temp= restore.poll();
                        visited[temp[0]][temp[1]]=false;
                    }
                }
            }
        }
    }
}
