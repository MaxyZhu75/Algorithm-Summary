class Solution {
    public long minimumHealth(int[] damage, int armor) { // 贪心抵消max或armor的伤害！！！
        long max = 0, sum = 0;
        for (int current : damage) {
            sum += current;
            max = Math.max(max, current);
        }
        return (long) sum - Math.min(max, armor) + 1; // 存活需要剩一滴血！！！
    }
}