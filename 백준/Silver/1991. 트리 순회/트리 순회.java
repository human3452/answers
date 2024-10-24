import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Character, char[]> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        map=new HashMap<>();
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            char tree=st.nextToken().charAt(0);
            map.put(tree, new char[]{tree, st.nextToken().charAt(0), st.nextToken().charAt(0)});
        }
        int counter=0;
        char pointer='A';
        //VLR
        VLR('A');
        //LVR
        System.out.println();
        LVR('A');
        //LRV
        System.out.println();
        LRV('A');
    }
    static void VLR(char treenode){
        System.out.print(treenode);
        char[] temp=map.get(treenode);
        if(temp[1]!='.') VLR(temp[1]);
        if(temp[2]!='.') VLR(temp[2]);
    }
    static void LVR(char treenode){
        char[] temp=map.get(treenode);
        if(temp[1]!='.') LVR(temp[1]);
        System.out.print(temp[0]);
        if(temp[2]!='.') LVR(temp[2]);
    }
    static void LRV(char treenode){
        char[] temp=map.get(treenode);
        if(temp[1]!='.') LRV(temp[1]);
        if(temp[2]!='.') LRV(temp[2]);
        System.out.print(temp[0]);
    }
}