import java.io.*;
import java.util.*;
public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        p=new int[N+1];
        for(int i=1; i<=N; i++) p[i]=i;
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        HashSet<Integer> set= new HashSet<>();
        for(int i=1; i<=N; i++) find(i);
        for(int i=1; i<=N; i++){
            set.add(p[i]);
        }
        bw.write(set.size()+"");
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int A){
        if(p[A]==A){
            return A;
        }else{
            p[A]=find(p[A]);
            return find(p[A]);
        }
    }

    static void union(int A, int B){
        if(A<B){
            p[find(B)]=find(A);
        }else{
            p[find(A)]=find(B);
        }
    }
}