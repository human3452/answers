import java.util.*;

class Main{
    static int[][] board;
    static int[] p;
    static int N, K, year;
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, -1, 0, 1};
    static Queue<int[]> oddyear;
    static Queue<int[]> evenyear;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        p=new int[K+1];
        for(int i=1; i<=K; i++){
            p[i]=i;
        }
        board=new int[N+1][N+1];
        oddyear=new LinkedList<>();
        evenyear=new LinkedList<>();
        for(int i=1; i<=K; i++){
            int x=sc.nextInt()-1;
            int y=sc.nextInt()-1;
            board[x][y]=i;
            oddyear.add(new int[]{x,y,i});//x, y, civil number
            for(int j=0; j<4; j++){
                int nx=x+dx[j];
                int ny=y+dy[j];
                if(nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny]!=0){
                    union(board[nx][ny], i);
                }
            }
        }
        check(0);
        bfs();
    }

    private static void bfs(){
        int year=1;
        while(true){
            if(year%2==1) {
                while (!oddyear.isEmpty()) {
                    int[] temp = oddyear.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = temp[0] + dx[i];
                        int ny = temp[1] + dy[i];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (board[nx][ny] == 0) {
                                board[nx][ny] = temp[2];
                                evenyear.add(new int[]{nx, ny, temp[2]});
                                for (int j = 0; j < 4; j++) {
                                    int px = nx + dx[j];
                                    int py = ny + dy[j];
                                    if (px >= 0 && px < N && py >= 0 && py < N && board[px][py] != 0 && board[px][py] != board[nx][ny]) {
                                        union(board[px][py], board[nx][ny]);
                                    }
                                }
                            } else if (board[nx][ny] != temp[2]) {
                                union(board[nx][ny], temp[2]);
                            }
                        }
                    }
                }
            }else{
                while(!evenyear.isEmpty()){
                    int[] temp=evenyear.poll();
                    for(int i=0; i<4; i++){
                            int nx=temp[0]+dx[i];
                            int ny=temp[1]+dy[i];
                            if(nx>=0 && nx<N && ny>=0 && ny<N){
                                if (board[nx][ny] == 0) {
                                    board[nx][ny]=temp[2];
                                    oddyear.add(new int[]{nx, ny, temp[2]});
                                    for(int j=0; j<4; j++){
                                        int px=nx+dx[j];
                                        int py=ny+dy[j];
                                        if(px>=0 && px<N && py>=0 && py<N && board[px][py]!=0 && board[px][py]!=board[nx][ny]){
                                            union(board[px][py], board[nx][ny]);
                                        }
                                    }
                                }else if(board[nx][ny]!=temp[2]) {
                                    union(board[nx][ny], temp[2]);
                                }
                            }
                        }
                    }
            }
            check(year);
            year++;
        }
    }
    private static void check(int year){
        for(int i=2; i<=K; i++){
            if(find(i)!=1) return;
        }
        System.out.println(year);
        System.exit(0);
    }
    private static void union(int a, int b) {
        int c=find(a);
        int d=find(b);
        p[Math.max(c, d)]=Math.min(c,d);
    }

    private static int find(int a) {
        if(p[a]==a){
            return p[a];
        }else{
            return find(p[a]);
        }
    }
}