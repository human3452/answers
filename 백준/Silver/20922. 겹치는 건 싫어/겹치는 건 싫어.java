import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        HashMap<Integer, Deque<Integer>> map=new HashMap<>();
        int max=0;
        int pointer=1;
        for(int i=1; i<=N; i++){
            int temp= Integer.parseInt(st.nextToken());
            if(!map.containsKey(temp)){
                map.put(temp, new LinkedList());
                map.get(temp).add(i);
            }else {
                if(map.get(temp).size()>=K){
                    if(pointer==1){
                        max=i-1;
                    }else{
                        max=Math.max(max,i-pointer);
                    }
                    pointer=Math.max(pointer, map.get(temp).pollFirst()+1);
                }else{

                }
                map.get(temp).add(i);
            }
        }
        max=Math.max(max,N-pointer+1);
        System.out.print(max);
    }
}