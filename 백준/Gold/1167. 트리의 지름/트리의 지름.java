import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<int[]>> map=new HashMap<>();
    static boolean[] visited;
    static int[] distance;
    static int mac=-1;
    static int pointer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        visited=new boolean[N+1];
        distance=new int[N+1];
        int root=0;
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            root=from;
            int to= Integer.parseInt(st.nextToken());
            while(to!=-1){
                if(!map.containsKey(from)) map.put(from, new ArrayList<>());
                map.get(from).add(new int[] {to, Integer.parseInt(st.nextToken())});
                to= Integer.parseInt(st.nextToken());
            }
        }
        visited[root]=true;
        getMaxDistance(root);
        root=pointer;
        mac=-1;
        visited=new boolean[N+1];
        distance=new int[N+1];
        visited[root]=true;
        getMaxDistance(root);
        System.out.println(mac);
    }
    static void getMaxDistance(int root){
        Stack<Integer> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            int temp=stack.pop();
            for(int[] a:map.get(temp)){
                if(!visited[a[0]]){
                    distance[a[0]]=distance[temp]+a[1];
                    if(distance[a[0]]>mac){
                        mac=distance[a[0]];
                        pointer=a[0];
                    }
                    visited[a[0]]=true;
                    stack.add(a[0]);
                }
            }
        }
    }
}
