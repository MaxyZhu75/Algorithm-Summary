func findErrorNums(nums []int) []int { // ��������Ͱ���򣡣���
    n := len(nums)
    result := make([]int, 2)
    for i:=0; i<n; i++ { // ��������Ĺ�ϵʽ��nums[i] = i+1������
        for (nums[i] != i+1 && nums[nums[i]-1] != nums[i]) { // ע��˴���whileѭ������λ��i���Լ�λ��nums[i]-1���Բ������ϵʽʱ������Ԫ��λ�ã�����
            swap(nums, i, nums[i]-1)
        }
    }

    for i:=0; i<n; i++ { // ����֮ǰ�Ľ����������н�������Ԫ�ز������ϵʽ nums[i] = i+1 ������
        if (nums[i] != i+1) {
            result[0], result[1] = nums[i], i+1 // ������ĵط�����i���������ڴ˴�������Ԫ����i+1��ʵ��ȴ��nums[i]������i+1����ȱʧԪ�أ�nums[i]�����ظ�Ԫ�أ�����
        }
    }

    return result
}

func swap(nums []int, i int, j int) {
    temp := nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}