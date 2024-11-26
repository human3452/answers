import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int A= Integer.parseInt(st.nextToken());
        Queue<String>[] queue=new Queue[201];
        for(int i=1; i<=200; i++) queue[i]=new LinkedList<>();
        for(int i=0; i<A; i++){
            st=new StringTokenizer(br.readLine());
            queue[Integer.parseInt(st.nextToken())].add(st.nextToken());
        }
        for(int i=1; i<=200; i++){
            while(!queue[i].isEmpty()){
                bw.write(i+" "+queue[i].poll()+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
