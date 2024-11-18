import java.io.*;
import java.util.*;
public class Main {
    static final int[] dx={0, 1, 0, -1};
    static final int[] dy={-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int temp=Integer.parseInt(st.nextToken());
            if(temp<M) bw.write(temp+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}