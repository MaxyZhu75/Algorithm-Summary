type Solution struct { // ǰ׺�� + ���ֲ��� ������
    prefixSum []int
}


func Constructor(w []int) Solution { // ���캯������Solution���͵Ľṹ�巵�أ�����
    prefixSum := make([]int, len(w))
    prefixSum[0] = w[0]
    for i:=1; i<len(w); i++ {
        prefixSum[i] = prefixSum[i-1] + w[i] // ��дdp��ķ�ʽ��ǰ׺����д��������
    }
    return Solution{prefixSum}
}


func (this *Solution) PickIndex() int { // �����ѽ�����[1, weightSum]����n�����֣����˴����ѡ������Ϊi��Ԫ�أ��������Ҫ��������[prefixSum[i]-w[i]+1, prefixSum[i]]������
    n := len(this.prefixSum)
    weightSum := this.prefixSum[n-1] // ��ȡȨ��֮�ͣ�����[1, weightSum]��ȡ�����������
    randomNum := rand.Intn(weightSum) + 1 // import rand��Intn(n int)��������[0, n)��α�����������
    return sort.SearchInts(this.prefixSum, randomNum) // import sort��SearchInts(a []int, x int) int ����������������a��Ԫ��x������������
}


/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(w);
 * param_1 := obj.PickIndex();
 */