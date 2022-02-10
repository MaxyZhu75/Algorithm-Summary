func threeSum(nums []int) [][]int { // Java����Go�𰸵ı���������������Ϊ����һ��ʱLeetCode�ϻᷢ����һ�����ڴ��ʱ��������⣻�����ֽⷨ����������+˫ָ�룡����
    n := len(nums) // Ҫ��һ��left������߽�Ԫ�أ�����һ����ͬ������ָ�������һ����mid��rightΪ�м��Ԫ�غ��ұ߽��Ԫ�أ�����
	result := [][]int{} // left��mid��right��ֵ������ͬ���������ظ���result����Ѵ��ڵĴ���ϣ�����
	
    sort.Ints(nums) // sort.Ints()�������򣡣���

	for i:=0;i<n-2;i++ {
		left := nums[i]
		if left > 0 { // Ҫ�������߽��ұ�Ԫ�ض���С����߽�Ԫ��ֵ��ֱ���˳�������
			break
		}
		if i > 0 && left == nums[i-1] { // Ҫ�������ֱ�ȷ��left��mid��rightλ�ã�����һ����ͬ����left��ָ������ߣ�������
			continue
		}
		
        p1, p2 := i+1, n-1 // Ҫ���ģ���ǰleft�̶���left�����ѭ���ƣ�������mid��right��˫ָ��p1��p2����дwhileѭ��������
		for (p1 < p2) { 
			mid, right := nums[p1], nums[p2]
			if left + mid + right == 0 {
				result = append(result, []int{left, mid, right})
				for (p1 < p2 && nums[p1] == mid) { // Ҫ���壺ע����ƶ�ָ���д����Java�����֣�����
					p1++
				}
				for (p1 < p2 && nums[p2] == right) { // �˴�ѭ����Ϊ��ʹ��һ���𰸲��ظ�������
					p2--
				}
			} else if left + mid + right < 0 {
				p1++
			} else {
				p2--
			}
		}
	}
	return result
}