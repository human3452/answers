import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    static int[] candy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int K= Integer.parseInt(br.readLine());
        System.out.println(N+K);
    }
}
