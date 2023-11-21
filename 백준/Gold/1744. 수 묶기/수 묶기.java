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
        PriorityQueue<Integer> positive=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative=new PriorityQueue<>();
        int answer=0;
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            int temp= Integer.parseInt(st.nextToken());
            if(temp>0){
                positive.add(temp);
            }else{
                negative.add(temp);
            }
        }
        while(!positive.isEmpty()){
            if(positive.size()==1){
                int a=positive.poll();
                answer+=a;
                break;
            }
            int a=positive.poll();
            int b=positive.poll();
            answer+=Math.max(a*b, a+b);
        }
        while(!negative.isEmpty()){
            if(negative.size()==1){
                int a=negative.poll();
                answer+=a;
                break;
            }
            int a=negative.poll();
            int b=negative.poll();
            answer+=Math.max(a*b, a+b);
        }
        System.out.println(answer);
    }
}
