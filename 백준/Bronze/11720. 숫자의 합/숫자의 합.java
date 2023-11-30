import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        String temp=st.nextToken();
        int answer=0;
        for(int i=0; i<N; i++){
            answer+=temp.charAt(i)-'0';
        }
        System.out.println(answer);
    }
}
