func maxSlidingWindow(nums []int, k int) []int { //��˫�˶��С�ʵ�֡��������С�������ʱ����ɣ�����
    n := len(nums)
    deque := []int{}
    for i:=0; i<k; i++ { // �����ڵ�һ��Ԫ�ش������Ԫ�صķ�����ʱ�������ڶѣ����ȶ��У�������
        for len(deque) != 0 && nums[i] >= nums[deque[len(deque)-1]] {
            deque = deque[:len(deque)-1] // ����βԪ��С��������Ԫ��ʱ����Ȼ��ֱ�ӵ����������ٿ��Ǹ�Ԫ�أ������ֵ�ᱻ�ƶ������ס�������
        }
        deque = append(deque, i) // �洢Ԫ������������
    }

    result := []int{}
    result = append(result, nums[deque[0]])
    for i:=k; i<n; i++ { // �������ڣ�����������Ԫ�ر���������
        for len(deque) != 0 && deque[0] <= i-k { // ����������в��ڵ�ǰ�����ڵ�Ԫ�أ�����
            deque = deque[1:]
        }
        for len(deque) != 0 && nums[i] >= nums[deque[len(deque)-1]] {
            deque = deque[:len(deque)-1]
        }
        deque = append(deque, i)

        result = append(result, nums[deque[0]])
    }
    return result
}