type NumArray struct { // ���⿼�����ǰ׺�ͣ��Լ���֪��ε���ĳһ��������ν���ʱ���Ż������⣡����
    D []int // ����һ��dp��洢ǰ׺�ͣ�ǰ׺�ͼ���Ԫ��ǰ������Ԫ�صĺͣ���������Ԫ�أ�������
}


func Constructor(nums []int) NumArray { // ��֪���캯��ֻ����һ�Σ���sumRange()����ö�Σ�����������sumRange()��дѭ����ӣ��˴��ڹ��캯������forѭ����dp��������ǰ׺���������Ż�ʱ�䣡����
    var n int = len(nums)
    D := make([]int, n+1) // ��ʼ��ע��dp��Ĵ�С����ֹ���������
    D[0] = 0
    for i, num := range nums {
        D[i+1] = D[i] + num // ����dp���̣�����
    }
    return NumArray{D} // Go�����д˴����캯����Ҫ���أ�����
}


func (this *NumArray) SumRange(left int, right int) int {
    return this.D[right+1] - this.D[left]  // ��ǰ׺�͵Ķ���ֱ�ӷ��أ�Go�����������ע��ʹ��receiver���е��ã����� 
}


/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(left,right);
 */