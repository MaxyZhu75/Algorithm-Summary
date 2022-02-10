class Solution { // 方法一：数组计数；该方法空间复杂度为O(n)，Go语言写的方法二空间复杂度为O(1)！！！
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] record = new int[n+1];
        int[] result = new int[2];
        for (int num : nums) {
            record[num]++;
        }

        for (int i=1; i<n+1; i++) {
            if (record[i] == 2) {
                result[0] = i;
            }

            if (record[i] == 0) {
                result[1] = i;
            }
        }

        return result;
    }
}