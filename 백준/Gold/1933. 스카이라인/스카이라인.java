import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        ArrayList<int[]> pq=new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            pq.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
        PriorityQueue<int[]> pq2=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });
        pq.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o2[1]-o1[1];
                return o1[0] - o2[0];
            }
        });
        int pointer=0;
        int curt=-1;
        int[] temp2 = {-1, -1, -1};
        int[] temp = {-1, -1, -1};
        while(pointer<pq.size() || !pq2.isEmpty()){
            if(pointer<N && (pq2.isEmpty() || pq.get(pointer)[0]<pq2.peek()[1])){
                temp=pq.get(pointer++);
                if(pq2.isEmpty() || temp[1]>pq2.peek()[0]){
                    if(temp2[0]==temp[1] && temp2[1]==temp[0]){
                        pq2.add(new int[] {temp[1], temp[2]});
                        continue;
                    }
                    pq2.add(new int[] {temp[1], temp[2]});
                    bw.write(temp[0]+" "+temp[1]+" ");
                }
                else{
                    pq2.add(new int[] {temp[1], temp[2]});
                }
            }else{
                temp2=pq2.poll();
                while(!pq2.isEmpty() && pq2.peek()[1]<=temp2[1]) pq2.poll();
                if(pq2.isEmpty()) {
                    if(pointer<N && pq.get(pointer)[0]==temp2[1]) continue;
                    bw.write(temp2[1]+" "+0+" ");
                    continue;
                }
                if(temp2[0]==pq2.peek()[0]) continue;
                else{
                    if(pointer<N && pq.get(pointer)[0]==temp2[1]) continue;
                    bw.write(temp2[1]+" "+pq2.peek()[0]+" ");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}