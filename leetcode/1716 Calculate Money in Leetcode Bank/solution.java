class Solution {
    public int totalMoney(int n) {
        int week = n/7;
        int leftDays = n%7;
        int sum = 0;
        for (int i=1; i<=week; i++) {
            int thisWeek = 7*i+1+2+3+4+5+6;
            sum += thisWeek;
        }
        if (leftDays != 0) {
            for (int i=0; i<leftDays; i++){
                int lastWeek = (week+1)+i;
                sum += lastWeek;
            }
        }
       return sum;
    }
}