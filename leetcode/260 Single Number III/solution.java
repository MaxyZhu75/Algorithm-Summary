class Solution {
    public int[] singleNumber(int[] nums) {
        int allXor = 0; // 0与任意整数n异或（0^n），结果为n本身！！！
        for (int num : nums) {
            allXor ^= num; // 由于整数n与自身异或（n^n）结果为0，将数组元素全部异或的结果即等于两个只出现一次的数字的异或结果！！！
        }
        int feature = allXor & (-allXor); // 要点：对于任意整数n，位运算n&(n-1)的结果为n最低位的1；此处则表示两个只出现一次的数字在二进制表示下最低的二者出现不同的位！！！
        int group1 = 0;
        int group2 = 0;
        int[] result = new int[2];
        for (int num: nums) {
            if ((num&feature) == 0){ // 此时可以由feature这一特征（第i位上为0或1），将数组分为两组，注意两个只出现一次的数字必然在不同组！！！
                group1 ^= num; 
            } else {
                group2 ^= num;
            }
        }
        result[0] = group1; // 两个只出现一次的数字各自在不同组；由于其他元素皆出现两次，整数n与自身异或（n^n）结果为0，故各组异或运算后的结果即为答案！！！
        result[1] = group2;
        return result;
    }
}