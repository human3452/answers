import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int Q=Integer.parseInt(st.nextToken());
        boolean[] places=new boolean[N];
        int pointer=1;
        st=new StringTokenizer(br.readLine());
        TreeMap<Integer, Boolean> map=new TreeMap<>();
        for(int i=1; i<=N; i++){
            if(Integer.parseInt(st.nextToken())==1){
                places[i%N]=true;
                map.put(i%N, true);
            }
        }
        for(int i=0; i<Q; i++){
            st=new StringTokenizer(br.readLine());
            switch(Integer.parseInt(st.nextToken())){
                case 1:
                    int temp=Integer.parseInt(st.nextToken())%N;
                    if(map.containsKey(temp)){
                        map.remove(temp);
                    }else{
                        map.put(temp, true);
                    }
                    break;
                case 2:
                    pointer=(pointer+Integer.parseInt(st.nextToken()))%N;
                    break;
                case 3:
                    if(map.size()==0){
                        System.out.println(-1);
                        break;
                    }
                    int ceiling=-1;
                    if(map.ceilingKey(pointer)!=null){
                        ceiling=map.ceilingKey(pointer)-pointer;
                    }else{
                        ceiling=N-pointer+ map.firstKey();
                    }
                    System.out.println(ceiling);
                    break;
            }
        }

    }

}
