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
        int N= Integer.parseInt(br.readLine());
        Deque<Integer> deque=new LinkedList<>();
        for(int i=1; i<=N; i++) deque.add(i);
        while(deque.size()>1){
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }
        System.out.println(deque.pop());
        bw.flush();
        bw.close();
        br.close();
    }
}