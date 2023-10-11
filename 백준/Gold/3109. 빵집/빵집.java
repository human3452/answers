import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int[] dx={1, 0, -1};
    static boolean board[][];
    static int H, W;
    static int answer=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        H=sc.nextInt();
        W=sc.nextInt();
        board =new boolean[H][W];
        sc.nextLine();
        for(int i=0; i<H; i++){
            String a=sc.nextLine();
            for(int j=0; j<W; j++){
                if(a.charAt(j)=='x'){
                    board[i][j]=true;
                }
            }
        }
        for(int i=0; i<H; i++){
            bfs(i);
        }
        System.out.println(answer);
    }

    private static void bfs(int start) {
        int x=start;
        int y=0;
        Stack<int[]> stack=new Stack<>();
        stack.add(new int[] {x,y});
        while(!stack.isEmpty()){
            int temp[]=stack.pop();
            board[temp[0]][temp[1]]=true;
            for(int i=0; i<3; i++){
                int nx=temp[0]+dx[i];
                int ny=temp[1]+1;
                if(nx>=0 && nx<H && ny>=0 && ny<W && !board[nx][ny]){
                    stack.add(new int[]{nx, ny});
                    if(ny==W-1){
                        answer++;
                        return;
                    }
                }
            }
        }
    }

}