import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        int[] max=pq.poll();
        int answer=max[1];
        int start=max[0], end=max[0];
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            if(temp[0]<start){
                answer+=(start-temp[0])*temp[1];
                start=temp[0];
            }else if(temp[0]>end){
                answer+=(temp[0]-end)*temp[1];
                end=temp[0];
            }
        }
        System.out.print(answer);
    }
}