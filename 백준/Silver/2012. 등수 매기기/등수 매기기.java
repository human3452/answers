import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }
        long answer=0;
        for(int i=1; i<=N; i++){
            answer+=Math.abs(pq.poll()-i);
        }
        System.out.println(answer);
    }
}
