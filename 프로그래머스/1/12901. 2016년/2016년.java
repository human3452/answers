import java.time.*;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        LocalDate date=LocalDate.of(2016, a, b);
        System.out.println(date);
        DayOfWeek week=date.getDayOfWeek();
        int d = week.getValue();
        switch(d){
            case 1:
                return "MON";
            case 2:
                return "TUE";
            case 3:
                return "WED";
            case 4:
                return "THU";
            case 5:
                return "FRI";
            case 6:
                return "SAT";
            case 7:
                return "SUN";
        }
        return answer;
    }
}