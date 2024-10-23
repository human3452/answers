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
             answer+= (temp.charAt(i)-'a'+1)*Math.pow(31,i);
        }
         System.out.print(answer%1234567891);
    }
}