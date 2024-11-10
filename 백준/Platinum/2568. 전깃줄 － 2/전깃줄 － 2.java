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
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        int[][] LCS=new int[N][2];
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<N; i++){
            int[] temp=pq.poll();
            LCS[i][0]=temp[0];
            LCS[i][1]=temp[1];
        }
        //최장 증가 수열(DP)
        int[] LIS=new int[N];
        int[] record=new int[N];
        int pointer=0;
        LIS[0]=LCS[0][1];
        for(int i=1; i<N; i++){
            if(LIS[pointer]<LCS[i][1]){
                pointer++;
                LIS[pointer]=LCS[i][1];
                record[i]=pointer;
            }else if(LIS[0]>LCS[i][1]){
                LIS[0]=LCS[i][1];
                record[i]=0;
            } else {
                int start = 0;
                int end = pointer;
                while (start < end) {
                    int middle = (start + end) / 2;
                    if (LIS[middle] < LCS[i][1]) {
                        start=middle+1;
                    } else {
                        end=middle;
                    }
                }
                LIS[start]=LCS[i][1];
                record[i]=start;
            }
        }
        bw.write((N-(pointer+1))+"\n");
        int[] answer=new int[pointer+1];
        for(int i=N-1; i>=0; i--){
            if(record[i]==pointer){
                answer[pointer]=LCS[i][1];
                pointer--;
            }
        }
        pointer=0;
        for(int i=0; i<N; i++){
            if(answer.length==pointer){
                bw.write(LCS[i][0]+"\n");
                continue;
            }
            if(answer[pointer]==LCS[i][1]){
                pointer++;
            }else{
                bw.write(LCS[i][0]+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
