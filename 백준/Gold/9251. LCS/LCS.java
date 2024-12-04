import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String A=br.readLine();
        String B=br.readLine();
        int[][] board=new int[A.length()+1][B.length()+1];
        int max=0;
        for(int i=0; i<A.length(); i++){
            int temp=A.charAt(i)-'0';
            for(int j=0; j<B.length(); j++){
                if(temp==B.charAt(j)-'0'){
                    board[i+1][j+1]=board[i][j]+1;
                    max=Math.max(board[i+1][j+1], max);
                }else{
                    board[i+1][j+1]=Math.max(board[i+1][j], board[i][j+1]);
                }
            }
        }
        System.out.println(max);
        bw.flush();
        bw.close();
        br.close();
    }
}