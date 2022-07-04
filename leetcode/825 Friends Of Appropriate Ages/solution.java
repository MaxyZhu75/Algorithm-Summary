class Solution {
    public int numFriendRequests(int[] ages) { // 计数 + 前缀和 ！！！
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        int[] pSum = new int[121];
        for (int i=1; i<=120; i++) {
            pSum[i] = pSum[i-1] + count[i];
        }
        int result = 0; // 三个条件合并为：0.5*ages[x]+7 < ages[y] <= ages[x] ！！！
        for (int i=15; i<=120; i++) { // 已知15岁以下的x是找不到满足上式的y的！！！
            if (count[i] > 0) {
                int lower = (int)(i * 0.5 + 7); // 细节：向下取整！！！
                result += count[i] * (pSum[i]-pSum[lower]-1); // 细节：pSum下标与ages下标相差1；末尾减1为减去x本身！！！
            }
        }
        return result;
    }
}