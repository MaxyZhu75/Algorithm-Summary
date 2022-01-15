class Solution {
    public int getSum(int a, int b) {
        int sum = a^b; // 不能用+号，则考虑含进位的各位相加符合什么运算；sum部分1+1和0+0为0，1+0和0+1为1，故由异或可以表示！！！
        int c = (a&b)<<1; // 若a和b在相同位上为1，则包含进位；故由与操作可以表示且进位的1需要左移至高位！！！
        if (c==0){
            return sum; // 进位c为0时直接返回sum结果！！！
        } else {
            return getSum(sum, c); // 进位c不为0时，迭代调用使c与sum相加，直至没有进位！！！
        }
    }
}