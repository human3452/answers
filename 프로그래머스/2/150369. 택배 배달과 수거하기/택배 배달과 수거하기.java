class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverPointer=n-1;
        int pickupPointer=n-1;
        while(deliverPointer>=0 && deliveries[deliverPointer]==0) deliverPointer--;
        while(pickupPointer>=0 && pickups[pickupPointer]==0) pickupPointer--;
        boolean flag=false;
        while(deliverPointer+pickupPointer>-2){
            if(deliverPointer>=pickupPointer) flag=true;
            else flag=false;
            int count=0;
            if(flag){
                answer+=(deliverPointer+1)*2;
                while(count<cap && deliverPointer>=0){
                    if(deliveries[deliverPointer]==0){
                        deliverPointer--;
                    }else{
                        count++;
                        deliveries[deliverPointer]--;
                    }
                }
                count=0;
                while(deliverPointer>=0 && deliveries[deliverPointer]==0) deliverPointer--;
                while(count<cap && pickupPointer>=0){
                    if(pickups[pickupPointer]==0){
                        pickupPointer--;
                    }else{
                        count++;
                        pickups[pickupPointer]--;
                    }
                }
                while(pickupPointer>=0 && pickups[pickupPointer]==0) pickupPointer--;
            }else{
                answer+=(pickupPointer+1)*2;
                while(count<cap && deliverPointer>=0){
                    if(deliveries[deliverPointer]==0){
                        deliverPointer--;
                    }else{
                        count++;
                        deliveries[deliverPointer]--;
                    }
                }
                count=0;
                while(deliverPointer>=0 && deliveries[deliverPointer]==0) deliverPointer--;
                while(count<cap && pickupPointer>=0){
                    if(pickups[pickupPointer]==0){
                        pickupPointer--;
                    }else{
                        count++;
                        pickups[pickupPointer]--;
                    }
                }
                while(pickupPointer>=0 && pickups[pickupPointer]==0) pickupPointer--;
            }
        }
        return answer;
    }
}