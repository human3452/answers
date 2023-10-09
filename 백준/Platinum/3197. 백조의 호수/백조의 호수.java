import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    static int[][] board;
    static int[] p;
    static Queue<int[]> queue;
    static int count, R, C;
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, -1, 0, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        board=new int[R][C];
        int[][] swans=new int[2][2];
        count=1;
        for(int i=0; i<R; i++){
            StringTokenizer st2=new StringTokenizer(br.readLine());
            String alpha=st2.nextToken();
            for(int j=0; j<C; j++){
                char a=alpha.charAt(j);
                switch(a){
                    case '.':
                        board[i][j]=-1;
                        break;
                    case 'L':
                        board[i][j]=count;
                        swans[count-1][0]=i;
                        swans[count-1][1]=j;
                        count++;
                        break;
                }
            }
        }
        //0은 벽, 물은 -1;
        //백조의 근처 물 구하기
        queue=new LinkedList<>();
        Queue<int[]> queue1=new LinkedList<>();
        queue1.add(new int[]{swans[0][0], swans[0][1], 1});
        queue1.add(new int[]{swans[1][0], swans[1][1], 2});
        while(!queue1.isEmpty()){
           int[] alpha=queue1.poll();
           for(int i=0; i<4; i++){
               int nx=alpha[0]+dx[i];
               int ny=alpha[1]+dy[i];
               if(nx>=0 && nx<R && ny>=0 && ny<C && board[nx][ny]!=alpha[2]){
                   if(board[nx][ny]==0){
                       queue.add(new int[]{alpha[0],alpha[1],alpha[2],0});
                   }else {
                       if (board[nx][ny] != -1) {
                           System.out.println(0);
                           System.exit(0);
                       }
                       board[nx][ny] = alpha[2];
                       queue1.add(new int[]{nx, ny, alpha[2]});
                   }
               }
           }
        }
        queue1.clear();
        // 이제, 얼음이 녹을 곳을 찾아봅시다.
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j]==-1){
                    board[i][j]=count;
                    bfs(i,j);
                }
            }
        }
        p=new int[count+1];
        for(int i=1; i<=count; i++){
            p[i]=i;
        }
        int cnt=0;
        //이제, 얼음을 녹여봅시다.
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            if(cnt!=temp[3]){
                //여기에는 union find 알고리즘 사용하기
                if(find(1)==find(2)){
                    System.out.println(cnt+1);
                    System.exit(0);
                }
                cnt++;
            }
            for(int i=0; i<4; i++){
                int nx=temp[0]+dx[i];
                int ny=temp[1]+dy[i];
                if(nx>=0 && nx<R && ny>=0 && ny<C) {
                    if(board[nx][ny]==0){
                        board[nx][ny]=temp[2];
                        queue.add(new int[]{nx,ny,temp[2],temp[3]+1});
                        for(int ad=0; ad<4; ad++){
                            int px=nx+dx[ad];
                            int py=ny+dy[ad];
                            if(px>=0 && px<R && py>=0 && py<C && board[px][py]>0 && board[px][py]!=board[nx][ny]){
                                union(board[px][py], board[nx][ny]);
                            }
                        }
                    }else if(board[nx][ny]!=temp[2]){
                        union(board[nx][ny],temp[2]);
                    }
                }
            }

        }
//        System.out.println(cnt);

    }

    private static int find(int a) {
        if(p[a]==a){
            return p[a];
        }else{
            return find(p[a]);
        }
    }

    private static void union(int a, int b) {
        int c=find(a);
        int d=find(b);
        p[Math.max(c,d)]=Math.min(c,d);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue1=new LinkedList<>();
        queue1.add(new int[]{r,c,count});
        while(!queue1.isEmpty()){
            int temp[]=queue1.poll();
            boolean flag=true;
            for(int i=0; i<4; i++){
                int nx=temp[0]+dx[i];
                int ny=temp[1]+dy[i];
                if(nx>=0 && nx<R && ny>=0 && ny<C && board[nx][ny]<=0){
                    if(board[nx][ny]==0){
                        queue.add(new int[]{temp[0], temp[1], count, 0}); //x, y, region, days
                        flag=false;
                    }else{
                        board[nx][ny] = temp[2];
                        queue1.add(new int[]{nx, ny, temp[2]});
                    }
                }
            }
        }
        count++;
    }
}