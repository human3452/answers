import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        p=new int[N];
        for(int i=0; i<N; i++) p[i]=i;
        for(int i=1; i<=M; i++){
            st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            if(find(from)==find(to)){
                System.out.println(i);
                System.exit(0);
            }
            union(from, to);
        }
        System.out.println(0);
//        bw.flush();
//        bw.close();
//        br.close();
    }
    static void union(int a, int b){
        if(a>b){
            p[find(a)]=find(b);
        }else{
            p[find(b)]=find(a);
        }
    }
    static int find(int A){
        if(p[A]==A) return p[A];
        else{
            p[A]=find(p[A]);
            return find(p[A]);
        }
    }
}