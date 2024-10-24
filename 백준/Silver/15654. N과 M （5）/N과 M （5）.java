import java.io.*;
import java.util.*;

public class Main {
    static int[] temp;
    static int[] temp2;
    static int N,M;
    static HashSet<Integer> set=new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        temp=new int[M];
        temp2=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) temp2[i]= Integer.parseInt(st.nextToken());
        Arrays.sort(temp2);
        f2(0,0);
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
            for(int i=start; i<N; i++){
                if(set.contains(temp2[i])) continue;
                set.add(temp2[i]);
                temp[depth]=temp2[i];
                f2(0, depth+1);
                set.remove(temp2[i]);

            }
        }
    }
}