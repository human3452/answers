import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int answer=0;
        PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        PriorityQueue<String> pq2=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        ArrayList<String> ab=new ArrayList<>();
        for(int i=0; i<N; i++) pq.add(br.readLine());
        for(int i=0; i<M; i++) pq2.add(br.readLine());
        while(!pq.isEmpty() && !pq2.isEmpty()){
            if(pq.peek().equals(pq2.peek())){
                answer++;
                ab.add(pq.poll());
                pq2.poll();
            }else{
                if(pq.peek().compareTo(pq2.peek())<0) pq.poll();
                else pq2.poll();
            }
        }
        Collections.sort(ab);
        System.out.println(answer);
        for(int i=0; i<answer; i++) System.out.println(ab.get(i));
        bw.flush();
        bw.close();
        br.close();
    }
}