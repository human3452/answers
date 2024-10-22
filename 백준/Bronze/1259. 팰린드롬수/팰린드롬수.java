import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        outer:while(true){
            String temp=br.readLine();
            if(temp.equals("0")) break;
            for(int i=0; i<temp.length()/2; i++){
                if(temp.charAt(i)!=temp.charAt(temp.length()-(i+1))){
                    System.out.println("no");
                    continue outer;
                }
            }
            System.out.println("yes");
        }
    }
}