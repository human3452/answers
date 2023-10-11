
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Main {
    static int[] dx={0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy={0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int H=sc.nextInt();
        int W=sc.nextInt();
        int[][] board=new int[H][W];
        ArrayList<int[]> arrayList=new ArrayList<>();
        int x = 0,y = 0;
        sc.nextLine();
        int cnt=0;
        for (int i=0; i<H; i++){
            String a=sc.nextLine();
            for(int j=0; j<W; j++){
                if(a.charAt(j)=='I'){
                    x=i;
                    y=j;
                    board[i][j]=-1;
                }else if(a.charAt(j)=='R'){
                    cnt++;
                    board[i][j]=cnt;
                    arrayList.add(new int[] {i, j});
                }
            }
        }
        String moveText=sc.nextLine();
        for(int i=0; i<moveText.length(); i++){
            Stack<int[]> stack=new Stack<>();
            int gear=moveText.charAt(i)-'0';
            board[x][y]++;
            x+=dx[gear];
            y+=dy[gear];
            if(board[x][y]!=0){
                System.out.println("kraj "+(i+1));
                System.exit(0);
            }
            board[x][y]--;
            //미친 로봇 움직일 차례
            for(int j=0; j<arrayList.size(); j++){
                int rob[]=arrayList.get(j);
                if(rob[1]==-1) continue;
                board[rob[0]][rob[1]]=0;
                if(rob[0]<x){
                    if(rob[1]<y){
                        rob[0]+=dx[3];
                        rob[1]+=dy[3];
                    }else if (rob[1]>y){
                        rob[0]+=dx[1];
                        rob[1]+=dy[1];
                    }else{
                        rob[0]+=dx[2];
                        rob[1]+=dy[2];
                    }
                }else if(rob[0]>x){
                    if(rob[1]<y){
                        rob[0]+=dx[9];
                        rob[1]+=dy[9];
                    }else if (rob[1]>y){
                        rob[0]+=dx[7];
                        rob[1]+=dy[7];
                    }else{
                        rob[0]+=dx[8];
                        rob[1]+=dy[8];
                    }
                }else{
                    if(rob[1]<y){
                        rob[0]+=dx[6];
                        rob[1]+=dy[6];
                    }else if (rob[1]>y){
                        rob[0]+=dx[4];
                        rob[1]+=dy[4];
                    }
                }
                arrayList.set(j, rob);
            }
            for(int j=0; j<arrayList.size(); j++){
                int rob[]=arrayList.get(j);
                if(rob[1]==-1) continue;
                switch (board[rob[0]][rob[1]]){
                    case -1:
                        System.out.println("kraj "+(i+1));
                        System.exit(0);
                    case 0:
                        board[rob[0]][rob[1]]=j+1;
                        break;
                    default:
                        if(board[rob[0]][rob[1]]!=-3) {
                            arrayList.set(board[rob[0]][rob[1]] - 1, new int[]{-1, -1});
                        }
                        arrayList.set(j, new int[] {-1, -1});
                        stack.add(new int[]{rob[0],rob[1]});
                        board[rob[0]][rob[1]]=-3;
                }
            }
            while(!stack.isEmpty()){
                int[] temp=stack.pop();
                board[temp[0]][temp[1]]=0;
            }
        }
        //결과 출력
        for(int i=0; i<H; i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0; j<W; j++){
                char a='?';
                switch (board[i][j]){
                    case -1:
                        a='I';
                        break;
                    case 0:
                        a='.';
                        break;
                    default:
                        a='R';
                        break;
                }
                sb.append(a);
            }
            System.out.println(sb);
        }
    }



}
