import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    static int[] candy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String temp=br.readLine();
        int te=1;
        for(int i=0; i<=temp.length()/2; i++){
            if(temp.charAt(i)!=temp.charAt(temp.length()-i-1)){
                te=0;
                break;
            }
        }
        System.out.println(te);
        bw.flush();
        bw.close();
        br.close();
    }
}
