class NumArray { // 该题考察的是前缀和，以及已知多次调用某一函数，如何进行时间优化的问题！！！
    private int[] d; // 定义一个dp表存储前缀和；前缀和即该元素前面所有元素的和（不包括该元素）！！！

    public NumArray(int[] nums) { // 已知构造函数只调用一次，而sumRange()会调用多次；因此相比于在sumRange()中写循环相加，此处在构造函数中用for循环填dp表来保存前缀和能明显优化时间！！！
        int n = nums.length;
        d = new int[n+1]; // 初始化注意dp表的大小，防止溢出！！！
        d[0] = 0;
        for (int i=1; i<n+1; i++) {
            d[i] = d[i-1] + nums[i-1]; // 简易dp方程！！！
        }
    }
    
    public int sumRange(int left, int right) { // 由前缀和的定义直接返回！！！
        return d[right+1] - d[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */