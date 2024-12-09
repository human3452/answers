import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long N= Long.parseLong(st.nextToken());
        long M= Long.parseLong(st.nextToken());
        long S= Long.parseLong(st.nextToken());

        System.out.println(N+M+S);
        bw.flush();
        bw.close();
        br.close();
    }
}