import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        if(N==M){
            System.out.println(0);
            System.exit(0);
        }
        Queue<Integer> oddSecond=new LinkedList<>();
        Queue<Integer> evenSecond=new LinkedList<>();
        oddSecond.add(N);
        int cnt=0;
        boolean oddCheck[]=new boolean[500001];
        boolean evenCheck[]=new boolean[500001];
        outer:while(true){
            while (!oddSecond.isEmpty()){
                int temp=oddSecond.poll();
                int minus=temp-1;
                int plus=temp+1;
                int multiply=temp*2;
                if(minus>=0 && !oddCheck[minus]){
                    oddCheck[minus]=true;
                    evenSecond.add(minus);
                }
                if(plus<=500000 && !oddCheck[plus]){
                    oddCheck[plus]=true;
                    evenSecond.add(plus);
                }
                if(multiply<=500000 && !oddCheck[multiply]){
                    oddCheck[multiply]=true;
                    evenSecond.add(multiply);
                }
            }
            cnt++;
            M+=cnt;
            if(M>500000) {
                cnt=-1;
                break;
            } else if (oddCheck[M]) {
                break;
            }
            while (!evenSecond.isEmpty()){
                int temp=evenSecond.poll();
                int minus=temp-1;
                int plus=temp+1;
                int multiply=temp*2;
                if(minus>=0 && !evenCheck[minus]){
                    evenCheck[minus]=true;
                    oddSecond.add(minus);
                }
                if(plus<=500000 && !evenCheck[plus]){
                    evenCheck[plus]=true;
                    oddSecond.add(plus);
                }
                if(multiply<=500000 && !evenCheck[multiply]){
                    evenCheck[multiply]=true;
                    oddSecond.add(multiply);
                }
            }
            cnt++;
            M+=cnt;
            if(M>500000) {
                cnt=-1;
                break;
            }else if (evenCheck[M]) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
