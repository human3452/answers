import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pq.add(new int[]{Integer.parseInt(st.nextToken()), i});
        }
        int counter=0;
        int start=pq.poll()[0];
        int[] answer=new int[N];
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            if(start==temp[0]){
                answer[temp[1]]=counter;
            }else{
                answer[temp[1]]=++counter;
                start=temp[0];
            }
        }
        for(int i=0; i<N-1; i++) bw.write(answer[i]+" ");
        bw.write(answer[N-1]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
