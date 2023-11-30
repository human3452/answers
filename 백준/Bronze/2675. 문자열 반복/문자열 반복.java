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
            int P= Integer.parseInt(st.nextToken());
            String word=st.nextToken();
            for(int j=0; j<word.length(); j++){
                for(int k=0; k<P; k++){
                    System.out.print(word.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
