import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st1.nextToken());
        Queue<Integer> queue=new LinkedList<>();
        boolean exist[]=new boolean[26];
        outer:for (int i = 0; i < N; i++) {
            String A=br.readLine();
            boolean flag=true;
            for(int j=0; j<A.length(); j++){
                if(flag){
                    int temp=A.charAt(j)-'A';
                    if(temp>26) temp=A.charAt(j)-'a';
                    if(!exist[temp]){
                        exist[temp]=true;
                        for(int k=0; k<A.length(); k++){
                            if(j==k){
                                System.out.print("[");
                                System.out.print(A.charAt(k));
                                System.out.print("]");
                            }else System.out.print(A.charAt(k));
                        }
                        System.out.println();
                        continue outer;
                    }
                    flag=false;
                }else{
                    if(A.charAt(j)==' ') flag=true;
                }
            }
            for(int j=0; j<A.length(); j++){
                if(A.charAt(j)==' ') continue;
                int temp=A.charAt(j)-'A';
                if(temp>26) temp=A.charAt(j)-'a';
                if(!exist[temp]){
                    exist[temp]=true;
                    for(int k=0; k<A.length(); k++){
                        if(j==k){
                            System.out.print("[");
                            System.out.print(A.charAt(k));
                            System.out.print("]");
                        }else System.out.print(A.charAt(k));
                    }
                    System.out.println();
                    continue outer;
                }
            }
            System.out.println(A);
        }
    }
}