class Solution {
    public int maximumProduct(int[] nums) { // 思路为排序或一次遍历扫描！！！
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE; // case1：数组中全是非负数或全是非正数，则结果应为最大的三个数相乘！！！
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE; // case2：数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数与最大正数的乘积！！！

        for (int num : nums) { // 注意变量初始化以及遍历时更新变量的if-else写法！！！
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1*max2*max3, min1*min2*max1); // 本题在一次遍历中找出最大的三个数和最小的两个数即可；最后对max1*max2*max3和min1*min2*max1两种结果形式取最大值！！！
    }
}