import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        HashSet<Integer> set=new HashSet<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) set.add(Integer.parseInt(st.nextToken()));
        int P= Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<P; i++){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                bw.write(1+"\n");
            }else bw.write(0+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
