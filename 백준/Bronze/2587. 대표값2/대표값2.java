import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int[] board=new int[5];
        int answer=0;
        for(int i=0; i<5; i++) {
            board[i]= Integer.parseInt(br.readLine());
            answer+=board[i];
        }
        Arrays.sort(board);
        bw.write(answer/5+"\n");
        bw.write(board[2]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
