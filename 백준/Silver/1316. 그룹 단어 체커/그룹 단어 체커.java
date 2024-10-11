import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        st1=new StringTokenizer(br.readLine(), " ");
        int N=Integer.parseInt(st1.nextToken());
        int answer=0;
        outer:for(int i=0; i<N; i++) {
            st1 = new StringTokenizer(br.readLine(), " ");
            String test=st1.nextToken();
            Map<Integer, Boolean> map=new HashMap<Integer, Boolean>();
            int before=test.charAt(0)-'0';
            map.put(before, true);
            for(int j=1; j<test.length(); j++){
                int present=test.charAt(j)-'0';
                if(map.containsKey(present)&& !map.get(present)) continue outer;
                if(present!=before){
                    map.put(before, false);
                    map.put(present, true);
                }
                before=present;
            }
            answer++;
        }
        System.out.print(answer);
    }
}