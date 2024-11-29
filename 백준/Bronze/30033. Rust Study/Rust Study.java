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
        int N= Integer.parseInt(br.readLine());
        int[] A=new int[N];
        int[] B=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i]= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) B[i]= Integer.parseInt(st.nextToken());
        int answer=0;
        for(int i=0; i<N; i++){
            if(B[i]>=A[i]) answer++;
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
