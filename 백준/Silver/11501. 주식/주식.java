import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc<T; tc++){
            int N=sc.nextInt();
            int board[] =new int[N];
            for(int i=0; i<N; i++){
                board[i]=sc.nextInt();
            }
            int point=board[N-1];
            long answer=0;
            for(int i=N-2; i>=0; i--){
                if(board[i]>point){
                    point=board[i];
                }else{
                    answer+=(point-board[i]);
                }
            }
            System.out.println(answer);
        }
    }
}
