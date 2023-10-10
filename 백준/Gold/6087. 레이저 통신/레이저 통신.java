
import java.util.*;
class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W=sc. nextInt();
        int H=sc.nextInt();
        int board[][]=new int[H][W];
        int destination[][] = new int[2][2];
        sc.nextLine();
        int cnt=0;
        for(int i=0; i<H; i++){
            String a=sc.nextLine();

            for(int j=0; j<W; j++){
                switch (a.charAt(j)){
                    case 'C':
                        destination[cnt][0]=i;
                        destination[cnt][1]=j;
                        board[i][j]= Integer.MAX_VALUE;
                        cnt++;
                        break;
                    case '*':
                        board[i][j]=-1;
                        break;
                    default:
                        board[i][j]=Integer.MAX_VALUE;
                        break;
                }
            }
        }
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0; i<4; i++){
            int nx=destination[0][0]+dx[i];
            int ny=destination[0][1]+dy[i];
            if(nx>=0 && nx<H && ny>=0 && ny<W && board[nx][ny]!=-1){
                if(nx==destination[1][0] && ny==destination[1][1]){
                    System.out.println(0);
                    System.exit(0);
                }
                board[nx][ny]=0;
                queue.add(new int[] {nx, ny, i, 0}); // x, y, 방향, 꺾은 수
            }
        }
        int max=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] temp= queue.poll();
            if(temp[3]>=max) continue;
            for(int i=0; i<4; i++){
                int nx=temp[0]+dx[i];
                int ny=temp[1]+dy[i];
                if(nx>=0 && nx<H && ny>=0 && ny<W && board[nx][ny]!=-1 && Math.abs(i-temp[2])!=2){
                    if(board[nx][ny]<=temp[3]) continue;
                    if(i-temp[2]==0){
                        if(nx==destination[1][0] && ny==destination[1][1]){
                            max=temp[3];
                            board[nx][ny]=temp[3];
                            continue;
                        }
                            queue.add(new int[]{nx, ny, i, temp[3]});
                            board[nx][ny]=temp[3];
                    }else{
                        if(nx==destination[1][0] && ny==destination[1][1]){
                            max=temp[3]+1;
                            board[nx][ny]=temp[3]+1;
                            continue;
                        }
                            queue.add(new int[]{nx, ny, i, temp[3]+1});
                            board[nx][ny]=temp[3]+1;
                    }
                }
            }
        }
        System.out.println(board[destination[1][0]][destination[1][1]]);
    }
}
