import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class problem implements Comparable<problem>{
        int deadline, reward;
        problem(int a, int b){
            deadline=a;
            reward=b;
        }
        @Override
        public int compareTo(problem o) {
            if(this.reward==o.reward){
                return this.deadline-o.deadline;
            }else{
                return o.reward-this.reward;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int[] answer=new int[N+1];
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=1; i<=N; i++){
            set.add(i);
        }
        PriorityQueue<problem> pq=new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            problem temp=new problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pq.add(temp);
        }
        int ans=0;
        while(!pq.isEmpty()){
            problem temp=pq.poll();
            if (set.floor(temp.deadline) != null) {
                int temp2= set.floor(temp.deadline);
                ans+=temp.reward;
                set.remove(temp2);
            }
        }
        System.out.println(ans);
    }
}
