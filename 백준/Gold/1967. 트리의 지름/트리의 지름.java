import java.io.*;
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
        if(N==1){
            System.out.println(0);
            System.exit(0);
        }
        visited=new boolean[N+1];
        distance=new int[N+1];
        int root;
        for(int i=0; i<N-1; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            if(!map.containsKey(from)) map.put(from, new ArrayList<>());
            if(!map.containsKey(to)) map.put(to, new ArrayList<>());
            int dis=Integer.parseInt(st.nextToken());
            map.get(from).add(new int[] {to, dis});
            map.get(to).add(new int[]{from, dis});
        }
        root=1;
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
                if(!visited[a[0]] && map.containsKey(a[0])){
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
