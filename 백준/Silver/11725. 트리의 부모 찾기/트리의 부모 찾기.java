import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
    static boolean[] visited;
    static int[] V;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int P= Integer.parseInt(br.readLine());
        V=new int[P+1];
        visited=new boolean[P+1];
        for(int i=0; i<P-1; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
                map.get(from).add(to);
            }else{
                map.get(from).add(to);
            }
            if (!map.containsKey(to)) {
                map.put(to, new ArrayList<>());
                map.get(to).add(from);
            }else{
                map.get(to).add(from);
            }
        }
        visited[1]=true;
        VLR(1);
        for(int i=2; i<=P; i++) System.out.println(V[i]);
    }
    static void VLR(int A){
        visited[A]=true;
        if(map.containsKey(A)){
            for(int a:map.get(A)){
                if(!visited[a]){
                    V[a]=A;
                    VLR(a);
                }
            }
        }
    }
}