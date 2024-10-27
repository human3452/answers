import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int a= Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0; i<a; i++) pq.add(Integer.parseInt(br.readLine()));
        while(!pq.isEmpty()) bw.write(pq.poll()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}