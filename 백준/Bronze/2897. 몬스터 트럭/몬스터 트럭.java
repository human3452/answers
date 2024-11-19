import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        char[][] board=new char[N][M];
        for(int i=0; i<N; i++){
            String temp=br.readLine();
            for(int j=0; j<M; j++){
                board[i][j]=temp.charAt(j);
            }
        }
        int[] answer=new int[5];
        for(int i=0; i<N-1; i++){
            inner:for(int j=0; j<M-1; j++){
                int temp=0;
                for(int inX=0; inX<2; inX++){
                    for(int inY=0; inY<2; inY++){
                        switch(board[i+inX][j+inY]){
                            case '#':
                                continue inner;
                            case 'X':
                                temp++;
                        }
                    }
                }
                answer[temp]++;
            }
        }
        for(int i=0; i<5; i++){
            bw.write(answer[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}