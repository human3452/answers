import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            int N= Integer.parseInt(br.readLine());
            int[] eLIS =new int[N+1];
            for(int i=0; i<N; i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                eLIS[Integer.parseInt(st.nextToken())]= Integer.parseInt(st.nextToken());
            }
            int min=eLIS[1];
            int answer=1;
            for(int i=2; i<=N; i++){
                if(eLIS[i]<min){
                    min=eLIS[i];
                    answer++;
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}