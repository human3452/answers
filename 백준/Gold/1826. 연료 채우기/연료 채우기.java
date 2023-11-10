import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class station implements Comparable<station>{
        int location, fuel;
        station(int a, int b){
            location=a;
            fuel=b;
        }
        @Override
        public int compareTo(station o) {
            if(this.fuel==o.fuel){
                return this.location-o.location;
            }
            return o.fuel-this.fuel;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        TreeSet<station> set=new TreeSet<>();
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            set.add(new station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st=new StringTokenizer(br.readLine());
        int destination= Integer.parseInt(st.nextToken());
        int currentFuel= Integer.parseInt(st.nextToken());
        int answer=0;
        outer:while (currentFuel<destination) {
            for (station a : set) {
                if(currentFuel>=a.location){
                    currentFuel+=a.fuel;
                    set.remove(a);
                    answer++;
                    continue outer;
                }
            }
            answer=-1;
            break;
        }
        System.out.println(answer);
    }
}