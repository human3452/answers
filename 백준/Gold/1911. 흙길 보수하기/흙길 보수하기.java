import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class puddle implements Comparable<puddle>{
        int from, to;
        puddle(int a, int b){
            from=a;
            to=b;
        }

        @Override
        public int compareTo(puddle o) {
            return this.from-o.from;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int L= Integer.parseInt(st.nextToken());
        PriorityQueue<puddle> pq=new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            pq.add(new puddle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int pointer=0;
        int answer=0;
        while(!pq.isEmpty()){
            puddle temp=pq.poll();
            pointer=Math.max(temp.from,pointer);
            if(pointer>=temp.to) continue;
            int tp= (int) Math.ceil((double)(temp.to-pointer)/(double)L);
            answer+=tp;
            pointer+=tp*L;
        }
        System.out.println(answer);
    }
}
