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
        int[] board=new int[100001];
        Queue<Integer> queue=new LinkedList<>();
        if(N==M){
            System.out.println(0);
            System.exit(0);
        }
        queue.add(N);
        while(true){
            int temp=queue.poll();
            if(temp<=50000){
                board[temp*2]=board[temp];
                if(temp*2==M) break;
                queue.add(temp*2);
            }
            if(temp!=0 && board[temp-1]==0){
                board[temp-1]=board[temp]+1;
                if(temp-1==M) break;
                queue.add(temp-1);
            }
            if(temp!=100000 && board[temp+1]==0){
                board[temp+1]=board[temp]+1;
                if(temp+1==M) break;
                queue.add(temp+1);
            }
        }
        System.out.println(board[M]);
    }

}
