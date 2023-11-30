import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int A= Integer.parseInt(st.nextToken());
            if(A==0) break;
            int B= Integer.parseInt(st.nextToken());
            System.out.println(A+B);
        }

    }
}
