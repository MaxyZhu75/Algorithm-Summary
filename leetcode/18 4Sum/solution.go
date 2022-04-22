func fourSum(nums []int, target int) [][]int { // ������ĿΪ����֮�ͣ��������һ��ָ�룡����
	result := [][]int{} // p1��p2��left��rightָ���ֵ������ͬ���������ظ���result����Ѵ��ڵĴ���ϣ�����
    n := len(nums)
    if (n < 4) {
        return result
    }

    sort.Ints(nums) // �����򣡣���

	for p1:=0; p1<n-3; p1++ {
        if p1 > 0 && nums[p1] == nums[p1-1] { // ��ס������֦��������ǿ����Ч�ʣ�����
            continue
        }
		if nums[p1] + nums[p1+1] + nums[p1+2] + nums[p1+3] > target {
            break
        }
        if nums[p1] + nums[n-1] + nums[n-2] + nums[n-3] < target {
            continue
        }
		
        for p2:=p1+1; p2<n-2; p2++ {
            if p2 > p1+1 && nums[p2] == nums[p2-1] { // ��ס������֦��������ǿ����Ч�ʣ�����
                continue
            }
            if nums[p1] + nums[p2] + nums[p2+1] + nums[p2+2] > target {
                break
            }
            if nums[p1] + nums[p2] + nums[n-1] + nums[n-2] < target {
                continue
            }

            left, right := p2+1, n-1 // ��ǰp1��p2�̶�����left��rightдwhileѭ����˫ָ�룡��
            for left < right {
                sum := nums[p1] + nums[p2] + nums[left] + nums[right]
                if sum == target {
                    result = append(result, []int{nums[p1], nums[p2], nums[left], nums[right]}) // appendһ�����飡����
                    for left < right && nums[left] == nums[left+1] {
                        left++
                    }
                    left++
                    for left < right && nums[right] == nums[right-1] { // �˴�ѭ��ּ����ǰ�ƶ�ָ��ʹ��һ���𰸲��ظ�������
                        right--
                    }
                    right--
                } else if sum < target {
                    for left < right && nums[left] == nums[left+1] {
                        left++
                    }
                    left++
                } else {
                    for left < right && nums[right] == nums[right-1] {
                        right--
                    }
                    right--
                }
            }
        
        
        }
	}
	return result
}