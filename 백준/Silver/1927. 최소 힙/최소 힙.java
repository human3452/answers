import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int temp= Integer.parseInt(br.readLine());
            if(temp==0){
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }else{
             pq.add(temp);
            }
        }
    }
}