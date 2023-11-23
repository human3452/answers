import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> negative=new PriorityQueue<>();
        PriorityQueue<Integer> positive=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            int temp= Integer.parseInt(st.nextToken());
            if(temp>0) positive.add(temp);
            else negative.add(temp);
        }
        long answer=0;
        while(!positive.isEmpty()){
            long a=positive.poll();
            if(!positive.isEmpty() && a*positive.peek()>a+positive.peek()){
                answer+=a*(long)positive.poll();
            }else{
                answer+=a;
            }
        }
        while(!negative.isEmpty()){
            long a=negative.poll();
            if(!negative.isEmpty() && a*negative.peek()>a+negative.peek()){
                answer+=a*(long)negative.poll();
            }else{
                answer+=a;
            }
        }
        System.out.println(answer);
    }
}
