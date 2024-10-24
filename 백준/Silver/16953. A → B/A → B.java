import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Character, char[]> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long N= Integer.parseInt(st.nextToken());
        long M= Integer.parseInt(st.nextToken());
        Queue<long[]> BFS=new LinkedList<>();
        BFS.add(new long[]{N, 1});
        while(!BFS.isEmpty()){
            long[] temp=BFS.poll();
            long A=temp[0]*2;
            long B=temp[0]*10+1;
            if(A==M || B==M) {
                System.out.println(temp[1]+1);
                System.exit(0);
            }
            if(A<M) BFS.add(new long[]{A, temp[1]+1});
            if(B<M) BFS.add(new long[]{B, temp[1]+1});
        }
        System.out.println(-1);
    }
}