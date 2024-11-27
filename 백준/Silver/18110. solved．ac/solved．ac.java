import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        int m= (int) Math.round((double)N*0.15);
        int[] math=new int[N];
        for(int i=0; i<N; i++) math[i]= Integer.parseInt(br.readLine());
        Arrays.sort(math);
        int answer=0;
        for(int i=m; i<N-m; i++){
            answer+=math[i];
        }
        bw.write((int) Math.round((double)answer/(double)(N-2*m))+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
