import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int piece=1;
        int answer=0;
        while(piece<N) piece*=2;
        System.out.print(piece+" ");
        if(piece!=N) {
            while (N != 0) {
                piece /= 2;
                if (N - piece >= 0) {
                    N -= piece;
                }
                answer++;
            }
        }
        System.out.print(answer);
    }
}