import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<int[]>> map=new HashMap<>();
    static boolean[] visited;
    static int[] distance;
    static int mac=-1;
    static int pointer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A= Integer.parseInt(br.readLine());
        String B=br.readLine();
        bw.write(A*Character.getNumericValue(B.charAt(2))+"\n");
        bw.write(A*Character.getNumericValue(B.charAt(1))+"\n");
        bw.write(A*Character.getNumericValue(B.charAt(0))+"\n");
        bw.write((A* Integer.parseInt(B))+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
