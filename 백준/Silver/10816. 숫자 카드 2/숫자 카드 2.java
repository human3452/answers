import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map=new HashMap<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int temp= Integer.parseInt(st.nextToken());
            if(!map.containsKey(temp)){
                map.put(temp, 0);
            }
            map.replace(temp, map.get(temp)+1);
        }
        int M= Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int temp= Integer.parseInt(st.nextToken());
            bw.write(map.getOrDefault(temp, 0) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int A){
        if(p[A]==A) return A;
        else{
            p[A]=find(p[A]);
            return find(p[A]);
        }
    }
    //A<B
    static void union(int A, int B){
        p[find(A)]=find(B);
    }
}
