import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words=new String[3];
        for(int i=0; i<3; i++){
            words[i]=br.readLine();
            try{
                Integer.parseInt(words[i]);
            }catch (Exception e){
                continue;
            }
            int answer=Integer.parseInt(words[i])+3-i;
            String an=f1(answer);
            if(an==null) System.out.print(answer);
            else System.out.print(an);
            System.exit(0);
        }
        outer:for(int i=1; i<=20; i++){
            for(int j=i; j<i+3; j++){
                if(!f1(j).equals(words[j-i]))continue outer;
            }
            int answer=Integer.parseInt(words[i])+3-i;
            String an=f1(answer);
            if(an==null) System.out.print(answer);
            else System.out.print(an);
            System.exit(0);
        }
    }
    static String f1(int answer){
        if(answer%3==0){
            if(answer%5==0) return "FizzBuzz";
            else return "Fizz";
        }else if(answer%5==0) return "Buzz";
        return null;
    }
}