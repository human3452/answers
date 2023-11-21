import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        String number=st.nextToken();
        LinkedList<Integer> staqueue=new LinkedList<>();
        st=new StringTokenizer(br.readLine());
        String delete=st.nextToken();
        int CC=delete.length();
        int[] index=new int[10];
        int[] base=new int[10];
        int[] nums=new int[10];
        for(int i=0; i<number.length(); i++){
            base[number.charAt(i)-'0']++; //이 친구랑
        }
        for(int i=0; i<delete.length(); i++){
            index[delete.charAt(i)-'0']++;
        }
        for(int i=0; i<10; i++){
            nums[i]=base[i]-index[i]; // 이 친구 이용해보자
        }
        for(int i=0; i<number.length(); i++){
            int temp=number.charAt(i)-'0';
            if(nums[temp]>0) {
                while (!staqueue.isEmpty() && temp > staqueue.peekLast() && nums[temp] > 0) {
                    int tmp=staqueue.pollLast();
                    if(base[tmp]<=nums[tmp]){
                        staqueue.addLast(tmp);
                        break;
                    }else{
                        nums[tmp]++;
                    }
                }
                staqueue.add(temp);
                base[temp]--;
                nums[temp]--;
            }else{
                base[temp]--;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!staqueue.isEmpty()) sb.append(staqueue.pollFirst());
        System.out.println(sb.toString());
    }
}
