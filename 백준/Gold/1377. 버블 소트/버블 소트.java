import java.io.*;
import java.util.*;
public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        int[] array=new int[N];
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                else return o1[0]-o2[0];
            }
        });
        for(int i=1; i<=N; i++){
            int temp= Integer.parseInt(br.readLine());
            pq.add(new int[] {temp, i});
        }
        int max=0;
        for(int i=1; i<=N; i++){
            int[] temp=pq.poll();
            max=Math.min(max, i-temp[1]);
        }
        System.out.println(-(max-1));
        bw.flush();
        bw.close();
        br.close();
    }
}