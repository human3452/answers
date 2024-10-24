import java.io.*;
import java.util.*;

public class Main {
    static int[] temp;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        temp=new int[M];
        f2(1,0);
        bw.flush();
        bw.close();
        br.close();
    }
    static void f2(int start, int depth){
        if(depth==M){
            for(int i=0; i<M; i++){
                System.out.print(temp[i]+" ");
            }
            System.out.println();
        }else{
            for(int i=start; i<=N; i++){
                temp[depth]=i;
                f2(i, depth+1);
            }
        }
    }
}