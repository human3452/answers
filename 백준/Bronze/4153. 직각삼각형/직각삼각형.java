import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            int z= Integer.parseInt(st.nextToken());
            if(x==0 && y==0 && z==0) break;
            pq.add(x);
            pq.add(y);
            pq.add(z);
            if(Math.pow(pq.poll(),2)+Math.pow(pq.poll(),2)==Math.pow(pq.poll(),2)) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}