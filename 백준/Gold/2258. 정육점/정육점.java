import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o2[0]-o1[0];
                }
                return  o1[1]-o2[1];
            }
        });
        int sum=0;
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            int w=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            sum+=w;
            pq.add(new int[]{w, p});
        }
        if(sum<M){
            System.out.println(-1);
            System.exit(0);
        }
        int weight=0;
        int answer=0;
        int before=0;
        boolean flag=false;
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            if(before==temp[1]){
                if(!flag) {
                    answer += temp[1];
                    weight += temp[0];
                    if (weight >= M) {
                        flag = true;
                    }
                }
            }else{
                if(flag){
                    answer=Math.min(answer, temp[1]);
                    break;
                }else{
                    answer=temp[1];
                    weight+=temp[0];
                    if (weight >= M) {
                        break;
                    }
                }
            }
            before=temp[1];
        }

        System.out.println(answer);
    }
}
