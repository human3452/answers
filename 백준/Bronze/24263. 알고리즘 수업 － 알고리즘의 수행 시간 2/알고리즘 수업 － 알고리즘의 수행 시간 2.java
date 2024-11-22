import java.io.*;
import java.util.*;
public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        bw.write(N+"\n");
        bw.write(1+"");
        bw.flush();
        bw.close();
        br.close();
    }
}