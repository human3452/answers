import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        HashMap<String, String> map=new HashMap<>();
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        for(int i=0; i<M; i++){
            bw.write(map.get(br.readLine())+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}