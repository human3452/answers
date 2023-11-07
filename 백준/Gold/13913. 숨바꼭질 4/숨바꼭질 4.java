import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int[][] board=new int[100001][2];
        Queue<Integer> queue=new LinkedList<>();
        if(N==M){
            System.out.println(0);
            System.out.print(M);
            System.exit(0);
        }
        queue.add(M);
        while(true){
            int temp=queue.poll();
            if(temp%2==0 && board[temp/2][0]==0 && temp/2 !=M){
                board[temp/2][0]=board[temp][0]+1;
                board[temp/2][1]=temp;
                if(temp/2==N) break;
                queue.add(temp/2);
            }
            if(temp!=0 && board[temp-1][0]==0 && temp-1!=M){
                board[temp-1][0]=board[temp][0]+1;
                board[temp-1][1]=temp;
                if(temp-1==N) break;
                queue.add(temp-1);
            }
            if(temp!=100000 && board[temp+1][0]==0 && temp+1!=M){
                board[temp+1][0]=board[temp][0]+1;
                board[temp+1][1]=temp;
                if(temp+1==N) break;
                queue.add(temp+1);
            }
        }
        System.out.println(board[N][0]);
        while(N!=M){
            System.out.print(N+" ");
            N=board[N][1];
        }
        System.out.print(N);
    }

}
