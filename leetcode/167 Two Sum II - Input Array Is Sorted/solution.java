class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int p1 = 0; // 最简单的双指针练习题！！！
        int p2 = n-1;
        int[] result = new int[2];
        while (p1 < p2) {
            int sum = numbers[p1] + numbers[p2];
            if (sum == target) {
                result[0] = p1+1;
                result[1] = p2+1;
                return result;
            } else if (sum < target) {
                p1++;
            } else {
                p2--;
            }
        }
        return result;
    }
}