import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int x= Integer.parseInt(st.nextToken());
        int y= Integer.parseInt(st.nextToken());
        int w= Integer.parseInt(st.nextToken());
        int h= Integer.parseInt(st.nextToken());
        System.out.println(Math.min(Math.min(x, y), Math.min(w-x, h-y)));
        bw.flush();
        bw.close();
        br.close();
    }
}
