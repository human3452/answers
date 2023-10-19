import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        for(int i=0; i<N; i++){
            pq.add(sc.nextInt());
        }
        int ans=0;
        while(true){
            int a, b;
            try{
                a=pq.poll();
                b=pq.poll();
                ans+=(a+b);
                pq.add(a+b);
            }catch (Exception e){
                System.out.println(ans);
                break;
            }
        }
    }
}