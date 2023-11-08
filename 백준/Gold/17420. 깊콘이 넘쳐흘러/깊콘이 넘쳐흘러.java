import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class gifticon implements Comparable<gifticon>{
        int deadline, plan;
        gifticon(int b){
            deadline=b;
        }
        public void setPlan(int c){
            plan=c;
        }
        @Override
        public int compareTo(gifticon o) {
            return this.plan-o.plan;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        PriorityQueue<gifticon> pq=new PriorityQueue<>();
        PriorityQueue<gifticon> pq2=new PriorityQueue<>(new Comparator<gifticon>() {
            @Override
            public int compare(gifticon o1, gifticon o2) {
                if (o1.deadline==o2.deadline){
                    return o1.plan-o2.plan;
                }else {
                    return o1.deadline-o2.deadline;
                }
            }
        });
        int N= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        gifticon[] gt=new gifticon[N];
        for(int i=0; i<N; i++){
            gt[i]=new gifticon(Integer.parseInt(st.nextToken()));
        }

        st=new StringTokenizer(br.readLine());
        long answer=0;
        for(int i=0; i<N; i++){
            gt[i].setPlan(Integer.parseInt(st.nextToken()));
            if(gt[i].plan>gt[i].deadline){
                int temp= (int) Math.ceil((double) (gt[i].plan-gt[i].deadline)/30.0);
                gt[i].deadline+=temp*30;
                answer+=temp;
            }
            pq.add(gt[i]);
            pq2.add(gt[i]);
        }
        while(!pq.isEmpty()){
            gifticon base=pq.poll();
            gifticon compare=pq2.poll();
            while(base.plan<compare.plan){
                compare.deadline+=30;
                pq2.add(compare);
                answer++;
                compare=pq2.poll();
            }
        }

        System.out.println(answer);
    }
}
