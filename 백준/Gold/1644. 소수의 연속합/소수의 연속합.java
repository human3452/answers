import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println(0);
            System.exit(0);
        }
        if(N==2){
            System.out.println(1);
            System.exit(0);
        }
        boolean[] isnotprime=new boolean[N+1];
        isnotprime[0]=true;
        isnotprime[1]=true;
        for(int i=2; i*i<=N; i++){
            if(!isnotprime[i]){
                for(int j=i*i; j<=N; j+=i) {
                    isnotprime[j] = true;
                }
            }
        }
        for(int i=2; i*i<=N; i++){
            if(!isnotprime[i]){
                for(int j=i*i; j<=N; j+=i) {
                    isnotprime[j] = true;
                }
            }
        }
        ArrayList<Integer> prime=new ArrayList<>();
        for(int i=2; i<=N ;i++){
            if(!isnotprime[i]) prime.add(i);
        }
        //투 포인터
        int start=0, end=0;
        int sum=2;
        int answer=0;
        while(end!=prime.size()-1){
            if(sum<N){
                end++;
                sum+=prime.get(end);
            }else if(sum>N){
                sum-=prime.get(start);
                start++;
            }else{
                answer++;
                end++;
                sum+=prime.get(end);
            }
        }
        while(sum>=N){
            if(sum>N){
                sum-=prime.get(start);
                start++;
            }else{
                answer++;
                break;
            }
        }
        System.out.println(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}