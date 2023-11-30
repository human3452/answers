import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] answer=new int[10];
        int B= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        B*= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        B*= Integer.parseInt(st.nextToken());
        String B2=String.valueOf(B);
        for(int i=0; i<B2.length(); i++){
            answer[B2.charAt(i)-'0']++;
        }
        for(int i=0; i<10; i++){
            System.out.println(answer[i]);
        }
    }
}
