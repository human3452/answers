import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int G= Integer.parseInt(br.readLine());
        int P= Integer.parseInt(br.readLine());
        TreeMap<Integer, Boolean> map=new TreeMap<>();
        for(int i=0; i<=G; i++) map.put(i, true);
        for(int i=0; i<P; i++){
            int plane= Integer.parseInt(br.readLine());
            if(map.containsKey(plane)){
                map.remove(plane);
            }else{
                int ceil=map.floorKey(plane);
                if(ceil==0){
                    System.out.println(i);
                    System.exit(0);
                }
                map.remove(ceil);
            }
        }
        System.out.println(P);
        bw.flush();
        bw.close();
        br.close();
    }
}