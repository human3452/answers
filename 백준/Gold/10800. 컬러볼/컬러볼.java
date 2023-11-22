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
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]==o2[2]){
                    return o1[1]-o2[1];
                }
                return o1[2]-o2[2];
            }
        });
        long sum=0;
        long[] answer=new long[N]; // 0: 플레이어 이전 합
        long[] colors=new long[N+1];
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            pq.add(new int[]{i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}); // 0:플레이어 번호, 1: 공 색깔, 2: 공 크기
        }
        int[] before=new int[3];
        int counter=1;
        while (!pq.isEmpty()){
            int[] temp= pq.poll();
            if(before[2]==temp[2]){
                if(before[1]!=temp[1]){
                    answer[temp[0]]=sum-(colors[temp[1]]+counter*temp[2]);
                }else {
                    answer[temp[0]]=answer[before[0]];
                }
                counter++;
            }else{
                counter=1;
                answer[temp[0]]=sum-colors[temp[1]];
            }
            colors[temp[1]]+=temp[2];
            sum+=temp[2];
            before[0]=temp[0];
            before[1]=temp[1];
            before[2]=temp[2];
        }

        for(int i=0; i<N; i++){
            System.out.println(answer[i]);
        }
    }
}
