class Solution {
    public boolean xorGame(int[] nums) { // 数学推理「博弈论」；证明见官方解答！！！
        if (nums.length % 2 == 0) {
            return true; // 结论一：进入A的回合时，若数组长度为偶数，则A必胜（在结论二前提下总可以使剩余奇数个数异或结果不为0）！！！
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0; // 结论二：若数组全部元素异或结果为0，则A直接胜利（获胜定义且先手）！！！
    }
}