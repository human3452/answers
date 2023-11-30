import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int B= Integer.parseInt(st.nextToken());
        for(int i=1; i<=B; i++){
            for(int j=1; j<=B-i; j++) System.out.print(" ");
            for(int j=B-i+1; j<=B; j++) System.out.print("*");
            System.out.println();
        }
    }
}
