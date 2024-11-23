import java.io.*;
import java.util.*;
public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, -1, 0, 1};
    static int limit, D, P, max=-1;
    static int[] bar;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        D= Integer.parseInt(st.nextToken());
        P= Integer.parseInt(st.nextToken());
        limit= (int) Math.pow(10, D);
        bar=new int[7];
        dup(0, -1);
        System.out.println(max);
        bw.flush();
        bw.close();
        br.close();
    }
    static void dup(int depth, int start){
        if(depth==7){
            calc();
        }else{
            for(int i=start+1; i<P+7-(6-depth); i++){
                bar[depth]=i;
                dup(depth+1, i);
            }
        }
    }

    static void calc(){
        int temp=1;
        for(int j=0; j<bar[0]; j++){
            temp*=2;
            if(temp>=limit) return;
        }
        if(temp>=limit) return;
        for(int i=0; i<6; i++){
            for(int j=0; j<bar[i+1]-bar[i]-1; j++){
                temp*=(i+3);
                if(temp>=limit) return;
            }
        }
        for(int j=0; j<P+6-bar[6]; j++){
            temp*=9;
            if(temp>=limit) return;
        }
        if(max<temp) {
            max= (int) temp;
        }
    }
}