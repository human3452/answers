import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class gifticon implements Comparable<gifticon>{
        int plan;
        long deadline;
        gifticon(long b){
            deadline=b;
        }
        public void setPlan(int c){
            plan=c;
        }
        @Override
        public int compareTo(gifticon o) {
            if(this.plan==o.plan)
            return (int) (this.deadline-o.deadline);
            else return this.plan-o.plan;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        PriorityQueue<gifticon> pq=new PriorityQueue<>();
        int N= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        gifticon[] gt=new gifticon[N];
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<N; i++){
            gt[i]=new gifticon(Integer.parseInt(st.nextToken()));
        }

        st=new StringTokenizer(br.readLine());
        long answer=0;

        for(int i=0; i<N; i++){
            int plan=Integer.parseInt(st.nextToken());
            if(map.containsKey(plan)){
                map.put(plan, map.get(plan)+1);
            }else{
                map.put(plan, 1);
            }
            gt[i].setPlan(plan);
            pq.add(gt[i]);
        }
        long max=0;
        gifticon base;
        while(!pq.isEmpty()){
            base=pq.peek();
            max=Math.max(max,base.plan);
            long tempmax=max;
            for(int i=0; i<map.get(base.plan); i++){
                base=pq.poll();
                if(base.deadline<max){
                    int temp= (int) Math.ceil((double)(max-base.deadline)/30.0);
                    answer+=temp;
                    base.deadline+=temp*30;
                }
                tempmax=Math.max(base.deadline, tempmax);
            }
            max=tempmax;
        }
        System.out.println(answer);
    }
}
