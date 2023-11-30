import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            System.out.println(Integer.parseInt(st.nextToken())+ Integer.parseInt(st.nextToken()));
        }

    }
}
