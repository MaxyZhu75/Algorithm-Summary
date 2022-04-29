func nextPermutation(nums []int) { // Ҫ��ԭ�ز������ⷨ��ȷ��֤����LeetCode�ٷ���𣡣�
    lastMini := len(nums)-2
    for lastMini >= 0 && nums[lastMini] >= nums[lastMini+1] { // ����һ��Ѱ�����ļ�Сֵ������ζ�Ŵ�ʱ�ü�Сֵ��Ԫ�ر�Ȼ�������У�����
        lastMini--
    }
    if lastMini >= 0 {
        nextHigher := len(nums)-1
        for nextHigher >= lastMini+1 && nums[lastMini] >= nums[nextHigher] { // ���������[lastMini+1, n)����������ҵ�һ������lastMini���������ڸ����併�򣬸����������lastMini����������ӽ�lastMini����������
            nextHigher--
        }
        nums[lastMini], nums[nextHigher] = nums[nextHigher], nums[lastMini] // ����������������������[lastMini+1, n)��Ϊ���򣡣���
    }
    reverse(nums, lastMini+1, len(nums)-1) // �����ģ�������[lastMini+1, n)��ת��Ϊ���򼴿ɣ�����
}

func reverse(nums []int, left int, right int) {
    for left < right {
        nums[left], nums[right] = nums[right], nums[left]
        left++
        right--
    }
}