import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    static int[] candy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String temp=br.readLine();
            bw.write(temp.charAt(0)+""+temp.charAt(temp.length()-1)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
