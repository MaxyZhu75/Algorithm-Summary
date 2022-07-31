class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int pair = 0;
        for(int i=0; i<time.length; i++) {
            int remainder = time[i] % 60;
            pair += count[remainder==0 ? 0 : 60-remainder]; // 余数之和为60的组队！！！
            count[remainder]++;
        }
        return pair;
    }
}