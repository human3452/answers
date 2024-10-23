import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
         String temp=br.readLine();
         long answer=0;
         for(int i=0; i<N; i++){
             long a=temp.charAt(i)-'a'+1;
             for(int j=0; j<i; j++){
                 a=(a*31)%1234567891;
             }
             answer+=a;
             answer%=1234567891;
        }
         System.out.print(answer%1234567891);
    }
}