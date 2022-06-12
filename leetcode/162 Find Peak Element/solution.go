func findPeakElement(nums []int) int { // �����󼫴�ֵ���������ֵ�����ֲ�����ȷ��֤�����ٷ���𣻴���չʾ�˶����Զ����ǵ����ԣ�����
    low, high := 0, len(nums)-1
    for low < high { // ��������ԣ�����nums[mid]��[mid��1]�Ĵ�С��ϵ������ȷ������һ�����㡸��Ȼ�н⡹������
        mid := (high-low)/2 + low
        if nums[mid] < nums[mid+1] { // ����أ�ѡ����ڱ߽�һ�˽��ж��֣�����ȷ��ѡ�������һ�����ڷ�ֵ������
            low = mid + 1
        } else {
            high = mid
        }
    }
    return low
}