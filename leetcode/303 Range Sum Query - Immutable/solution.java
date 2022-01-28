class NumArray { // ���⿼�����ǰ׺�ͣ��Լ���֪��ε���ĳһ��������ν���ʱ���Ż������⣡����
    private int[] d; // ����һ��dp��洢ǰ׺�ͣ�ǰ׺�ͼ���Ԫ��ǰ������Ԫ�صĺͣ���������Ԫ�أ�������

    public NumArray(int[] nums) { // ��֪���캯��ֻ����һ�Σ���sumRange()����ö�Σ�����������sumRange()��дѭ����ӣ��˴��ڹ��캯������forѭ����dp��������ǰ׺���������Ż�ʱ�䣡����
        int n = nums.length;
        d = new int[n+1]; // ��ʼ��ע��dp��Ĵ�С����ֹ���������
        d[0] = 0;
        for (int i=1; i<n+1; i++) {
            d[i] = d[i-1] + nums[i-1]; // ����dp���̣�����
        }
    }
    
    public int sumRange(int left, int right) { // ��ǰ׺�͵Ķ���ֱ�ӷ��أ�����
        return d[right+1] - d[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */