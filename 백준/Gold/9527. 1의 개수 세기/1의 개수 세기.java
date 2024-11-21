import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long A=Long.parseLong(st.nextToken());
        long B=Long.parseLong(st.nextToken())+1;
        String Abin=Long.toBinaryString(A);
        String Bbin=Long.toBinaryString(A);
        long answerA=0;
        long answerB=0;
        long ed=2;
        while(A>=(ed/2)){
            long tempA=A/ed;
            long tempB=A%ed;
            answerA+=tempA*(ed/2);
            answerA+=Math.max(0, tempB-ed/2);
            ed*=2;
        }
        ed=2;
        while(B>=(ed/2)){
            long tempA=B/ed;
            long tempB=B%ed;
            answerB+=tempA*(ed/2);
            answerB+=Math.max(0, tempB-ed/2);
            ed*=2;
        }
        System.out.println(answerB-answerA);
        bw.flush();
        bw.close();
        br.close();
    }
}