import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken())+ Integer.parseInt(br.readLine());
        while(M>=60){
            M-=60;
            N++;
        }
        while(N>=24) N-=24;
        bw.write(N+" "+M);
        bw.flush();
        bw.close();
        br.close();
    }
}