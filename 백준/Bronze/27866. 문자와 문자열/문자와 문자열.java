import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        String A=st.nextToken();
        st=new StringTokenizer(br.readLine());
        int B= Integer.parseInt(st.nextToken());
        System.out.println(A.charAt(B-1));
    }
}
