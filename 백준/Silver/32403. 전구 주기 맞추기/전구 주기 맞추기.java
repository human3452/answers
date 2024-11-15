import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int T= Integer.parseInt(st.nextToken());
        TreeSet<Integer> set=new TreeSet<>();
        set.add(1);
        set.add(T);
        for(int i=2; i<T; i++){
            if(T%i==0) set.add(i);
        }
        st=new StringTokenizer(br.readLine());
        int answer=0;
        for(int i=0; i<N; i++){
            int min=10001;
            int temp= Integer.parseInt(st.nextToken());
            if(set.ceiling(temp)!=null){
                min=Math.min(set.ceiling(temp)-temp, min);
            }
            if(set.floor(temp)!=null){
                min=Math.min(temp-set.floor(temp), min);
            }
            answer+=min;
        }
        System.out.println(answer);
    }
}
