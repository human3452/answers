import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[] temp=new int[N+1];
        Set<Integer> set=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int i=1; i<=N; i++){
            temp[i]= Integer.parseInt(br.readLine());
            set.add(temp[i]);
            set2.add(i);
        }
        if(set.equals(set2)){
            System.out.println(set.size());
            ArrayList<Integer> list=new ArrayList<>();
            list.addAll(set);
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            for(int a:list){
                System.out.println(a);
            }
            System.exit(0);
        }
        while(true){
            Set<Integer> tempset=new HashSet<>();
            for(int a:set){
                tempset.add(temp[a]);
            }
            if(tempset.equals(set)){
                System.out.println(set.size());
                ArrayList<Integer> list=new ArrayList<>();
                list.addAll(set);
                list.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                });
                for(int a:list){
                    System.out.println(a);
                }
                break;
            }else{
                set=tempset;
            }
        }
    }
}