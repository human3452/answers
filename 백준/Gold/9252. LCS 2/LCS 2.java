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
        bw.write(max+"\n");
        if(max!=0){
            StringBuilder sb=new StringBuilder();
            int x=A.length();
            int y=B.length();
            while(x>0 && y>0 && max>0){
                if(board[x-1][y]==board[x][y]){
                    x--;
                }else if(board[x][y-1]==board[x][y]){
                    y--;
                }else{
                    x--;
                    y--;
                    max--;
                    sb.append(A.charAt(x));
                }
            }
            bw.write(sb.reverse().toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}