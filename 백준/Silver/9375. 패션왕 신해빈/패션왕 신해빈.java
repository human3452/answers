import java.io.*;
import java.util.*;

public class Main {
    static class node{

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            int M= Integer.parseInt(br.readLine());
            HashMap<String, Integer> map=new HashMap<>();
            for(int i=0; i<M; i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                String Item=st.nextToken();
                String Category=st.nextToken();
                if(!map.containsKey(Category)) map.put(Category, 1);
                else map.replace(Category, map.get(Category)+1);
            }
            int answer=1;
            for(int a:map.values()) answer*=(a+1);
            System.out.println(answer-1);
        }
    }
}