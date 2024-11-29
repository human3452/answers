import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<int[]>> map=new HashMap<>();
    static boolean[] visited;
    static int[] distance;
    static int mac=-1;
    static int pointer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            int N= Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) pq.add(Integer.parseInt(st.nextToken()));
            int answer=0;
            while(pq.size()>=3){
                pq.poll();
                pq.poll();
                answer+=pq.poll();
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
