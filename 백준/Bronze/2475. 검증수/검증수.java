import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int number=0;
        while(st.hasMoreTokens()){
            number+= Math.pow(Integer.parseInt(st.nextToken()),2);
        }
        System.out.println(number%10);
    }
}
