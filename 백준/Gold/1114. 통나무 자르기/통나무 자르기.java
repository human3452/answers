import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int L= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        int C= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        HashSet<Integer> set=new HashSet<>();
        for(int i=1; i<=K; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        set.add(0);
        set.add(L);
        Integer[] spot=set.toArray(new Integer[0]);
        Arrays.sort(spot);
        int left=0;
        int right=L;
        int first=spot.length-1;
        outer:while(left<=right){
            int current=spot.length-1;
            int pointer=current-1;
            int middle=(left+right)/2;
            int cnt=0;
            int tempfirst=spot.length-1;
            while(pointer!=-1){
                if(spot[current]-spot[pointer]>middle){
                    if(current-pointer==1){
                        left=middle+1;
                        continue outer;
                    }
                    current=pointer+1;
                    tempfirst=current;
                    cnt++;
                    continue;
                }else if(spot[current]-spot[pointer]==middle){
                    current=pointer;
                    if(pointer!=0){
                        tempfirst=current;
                        cnt++;
                    }
                }
                pointer--;
            }
            if(cnt<=C){
                if(cnt<C){
                    first=1;
                }else{
                    first=tempfirst;
                }
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        System.out.println(left+" "+spot[first]);
    }
}
