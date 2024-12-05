import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.zip.Inflater;


public class Main {
    static final int INF=100000000;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String A=br.readLine();
        int answer=0;
        for(int i=0; i<A.length(); i++){
           int temp=(A.charAt(i)-'A');
           if(temp/3<=4){
                answer+=temp/3+3;
           }else if(temp>=15 && temp<=18){
               answer+=8;
           }else if(temp>=22){
               answer+=10;
           }else{
               answer+=9;
           }
        }
        System.out.println(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}