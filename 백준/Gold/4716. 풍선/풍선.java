import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N= Integer.parseInt(st.nextToken());
            if(N==0) break;
            long A=Integer.parseInt(st.nextToken());
            long B= Integer.parseInt(st.nextToken());
            PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    int abs= (int) Math.abs(o1[1]-o1[2])-(int)Math.abs(o2[1]-o2[2]);
                    if(abs==0){
                        return (int) (o1[1]-o2[1]);
                    }
                    return -abs;
                }
            });
            for(int i=0; i<N; i++){
                st=new StringTokenizer(br.readLine());
                pq.add(new long[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
            }
            long answer=0;
            while(!pq.isEmpty()){
                long[] temp=pq.poll();
                if(temp[1]<=temp[2]){
                    //A먼저
                    if(A<temp[0]){
                        answer+=(A*temp[1]+ (temp[0] - A) *temp[2]);
                        A=0;
                    }else{
                        answer+=(temp[0] *temp[1]);
                        A-=temp[0];
                    }
                }else{
                    //B먼저
                    if(B<temp[0]){
                        answer+=(B *temp[2]+ (temp[0] - B) * temp[1]);
                        B=0;
                    }else{
                        answer+=(temp[0] *temp[2]);
                        B-=temp[0];
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
