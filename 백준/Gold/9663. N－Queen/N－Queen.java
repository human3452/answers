import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    static int[] plus;
    static int[] minus;
    static int[] str;
    static int answer=0, N;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        plus=new int[N];
        minus=new int[N];
        str=new int[N];
        dup(0);
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
    static void dup(int depth){
        if(depth==N){
            answer++;
            return;
        }else {
            outer:for (int i = 0; i < N; i++) {
                for(int j=0; j<depth; j++){
                    if(depth-i==minus[j] || depth+i==plus[j] || i==str[j]) continue outer;
                }
                minus[depth]=depth-i;
                plus[depth]=depth+i;
                str[depth]=i;
                dup(depth+1);
            }
        }
    }
}