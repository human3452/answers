import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] joined;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        st1=new StringTokenizer(br.readLine(), " ");
        int N=Integer.parseInt(st1.nextToken());
        st1=new StringTokenizer(br.readLine(), " ");
        int M=Integer.parseInt(st1.nextToken());
        joined=new int[N+1];
        boolean answer=true;
        for(int i=1; i<=N; i++){
            joined[i]=i;
        }
        //union
        for(int i=1; i<=N; i++){
            st1=new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                if(Integer.parseInt(st1.nextToken())==1){
                    union(i,j);
                }
            }
        }
        //find
        st1=new StringTokenizer(br.readLine(), " ");
        int start=Integer.parseInt(st1.nextToken());
        while(st1.hasMoreTokens()){
            int b=Integer.parseInt(st1.nextToken());
            if(find(start)!=find(b)){
                answer=false;
                break;
            }
        }
        if(answer) System.out.print("YES");
        else System.out.print("NO");
    }

    static void union(int a, int b){
        if(a<b){
            joined[find(b)]=find(a);
        }else{
            joined[find(a)]=find(b);
        }
    }
    static int find(int a){
        if(joined[a]!=a){
            return find(joined[a]);
        }
        return a;
    }
}