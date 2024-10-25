import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
    static boolean[] visited;
    static int[] V;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            int X= Integer.parseInt(st.nextToken());
            int Y= Integer.parseInt(st.nextToken());
            int Z= Integer.parseInt(st.nextToken());
            if(X==0) break;
            pq.add(X);
            pq.add(Y);
            pq.add(Z);
            X=pq.poll();
            Y=pq.poll();
            Z=pq.poll();
            if(X+Y<=Z) System.out.println("Invalid");
            else if(X==Z) System.out.println("Equilateral");
            else if(X==Y || Y==Z) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
    }

}