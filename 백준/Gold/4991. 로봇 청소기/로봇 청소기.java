
import java.util.*;
class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int[][] distance;
    static int[][] board;
    static ArrayList<int[]> arrayList;
    static int W,H,min;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        outer:while(true){
            W=sc.nextInt();
            H=sc.nextInt();
            sc.nextLine();
            arrayList=new ArrayList<>();
            if(W==0) break;
            board=new int[H][W];
            int x=0;
            int y=0;
            int virus=1;
            for(int i=0; i<H; i++){
                String a=sc.nextLine();
                for(int j=0; j<W; j++){
                    switch (a.charAt(j)){
                        case '*':
                            arrayList.add(new int[]{i,j});
                            board[i][j]=virus;
                            virus++;
                            break;
                        case 'x':
                            board[i][j]=-50;
                            break;
                        case 'o':
                            x=i;
                            y=j;
                            break;
                    }
                }
            }
            arrayList.add(new int[]{x,y});
            //거리 구하기
            distance=new int[virus][virus];
            for(int i=0; i<virus; i++){
                if(bfs(i)){
                    System.out.println(-1);
                    continue outer;
                }
            }
            //완전순열?
            min=Integer.MAX_VALUE;
            dep(0, 0, 0, distance.length-1);
            System.out.println(min);
        }
    }
    static void dep(int depth, int dist, int bit, int before){
        if(dist>=min) return;
        if(depth==distance.length-1){
            min=Math.min(dist, min);
            return;
        }
        for(int i=0; i<distance.length-1; i++){
            if(((1<<i)&bit)==0){
                bit+=1<<i;
                dist+=distance[before][i];
                dep(depth+1, dist, bit, i);
                bit-=1<<i;
                dist-=distance[before][i];
            }
        }
    }
    static boolean bfs(int start){
        boolean flag=false;
        Queue<int[]> queue=new LinkedList<>();
        boolean[][] check=new boolean[H][W];
        check[arrayList.get(start)[0]][arrayList.get(start)[1]]=true;
        queue.add(new int[]{arrayList.get(start)[0], arrayList.get(start)[1], 0});
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            for(int i=0; i<4; i++){
                int nx=temp[0]+dx[i];
                int ny=temp[1]+dy[i];
                if(nx>=0 && nx<H && ny>=0 && ny<W && board[nx][ny]!=-50 && !check[nx][ny]){
                    if(board[nx][ny]>0){
                        flag=true;
                        distance[board[nx][ny]-1][start]=temp[2]+1;
                        distance[start][board[nx][ny]-1]=temp[2]+1;
                    }
                    check[nx][ny]=true;
                    queue.add(new int[] {nx, ny, temp[2]+1});
                }
            }
        }
        return !flag;
    }
}
