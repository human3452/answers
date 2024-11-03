import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp= Integer.parseInt(br.readLine());
        if(temp>=90) bw.write("A");
        else if(temp>=80) bw.write("B");
        else if(temp>=70) bw.write("C");
        else if(temp>=60) bw.write("D");
        else bw.write("F");
        bw.flush();
        br.close();
        bw.close();
    }

}