import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean[] temp=new boolean[31];
        for(int i=0; i<28; i++){
            temp[Integer.parseInt(br.readLine())]=true;
        }
        for(int i=1; i<=30; i++){
            if(!temp[i]){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}