type SparseVector struct { // �� type SparseVector struct �������Ա����������
    hashRecord map[int]int
}

func Constructor(nums []int) SparseVector { // ���캯����Ҫ����һ��SparseVector�ĳ�ʼ��ʵ��������
    hashRecord := map[int]int{}
    for i:=0; i<len(nums); i++ {
        if nums[i] != 0 {
            hashRecord[i] = nums[i]
        }
    }
    return SparseVector{hashRecord: hashRecord}
}

// Return the dotProduct of two sparse vectors
func (this *SparseVector) dotProduct(vec SparseVector) int {
    result := 0
    for index, num1 := range this.hashRecord { // ����·�����ʾ����⣬this��ָv1��vec��ָv2������
        num2, ok := vec.hashRecord[index]
        if ok {
            result += num1 * num2
        }
    }
    return result
}

/**
 * Your SparseVector object will be instantiated and called as such:
 * v1 := Constructor(nums1);
 * v2 := Constructor(nums2);
 * ans := v1.dotProduct(v2);
 */