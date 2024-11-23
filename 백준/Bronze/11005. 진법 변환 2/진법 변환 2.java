import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int B= Integer.parseInt(st.nextToken());
        char[] radix=new char[B];
        if(B<10){
            for(int i=0; i<B; i++){
                radix[i]=(char)(i+'0');
            }
        }else {
            for (int i = 0; i < 10; i++) {
                radix[i] = (char) (i + '0');
            }
            for (int i = 10; i < B; i++) {
                radix[i] = (char) (i + 'A' - 10);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(N>=B){
            sb.append(radix[N%B]);
            N/=B;
        }
        sb.append(radix[N]);
        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
        br.close();
    }
}