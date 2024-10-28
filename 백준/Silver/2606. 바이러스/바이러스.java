import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());
        p=new int[T+1];
        int V= Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++) p[i]=i;
        for(int i=0; i<V; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int answer=0;
        for(int i=2; i<=T; i++) if(find(i)==find(1)) answer++;
        System.out.println(answer);
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