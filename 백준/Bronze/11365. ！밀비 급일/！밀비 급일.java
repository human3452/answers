import java.io.*;
import java.util.*;
public class Main {
    static final int[] dx={0, 1, 0, -1};
    static final int[] dy={-1, 0, 1, 0};
    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String temp=br.readLine();
            if(temp.equals("END")) break;
            StringBuilder sb = new StringBuilder();
            sb.append(temp);
            bw.write(sb.reverse().toString()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}