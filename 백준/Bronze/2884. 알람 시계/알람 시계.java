import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int hour= Integer.parseInt(st.nextToken());
        int minute= Integer.parseInt(st.nextToken());
        minute-=45;
        if(minute<0){
            minute+=60;
            hour--;
            if(hour<0){
                hour+=24;
            }
        }
        bw.write(hour+" "+minute);
        bw.flush();
        bw.close();
        br.close();
    }
}
