import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int A= Integer.parseInt(st.nextToken());
        int B= Integer.parseInt(st.nextToken());

        int GCD=getGCD(A, B);
        if(A<B) GCD=getGCD(B, A);
        System.out.println(GCD);
        System.out.print(A*B/GCD);
    }
    static int getGCD(int A, int B){
        if(A%B==0){
            return B;
        }else{
            return getGCD(B, A%B);
        }
    }
}