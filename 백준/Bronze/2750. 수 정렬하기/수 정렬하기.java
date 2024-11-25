import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        int[] board=new int[N];
        for(int i=0; i<N; i++) board[i]= Integer.parseInt(br.readLine());
        Arrays.sort(board);
        for(int i=0; i<N; i++) bw.write(board[i]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
