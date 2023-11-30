import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String temp[]=br.readLine().split(" ");
        int answer=0;
        for(int i=0; i<temp.length; i++){
            if(!temp[i].equals("")) answer++;
        }

        System.out.println(answer);
    }
}
