func splitArray(nums []int, m int) int { // ���ֵ��Ͻ�Ϊ����������Ԫ�صĺͣ��½�Ϊ����������Ԫ�ص����ֵ������
    maxNum, sum := 0, 0
    for _, num := range nums {
        sum += num
        if maxNum < num {
            maxNum = num
        }
    }

    low, high := maxNum, sum // ���ֲ��ң�����
    for low < high {
        mid := low + (high-low)/2
        if check(nums, mid, m) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}

func check(nums []int, upperBound int, m int) bool { // ��֤�Ƿ����һ�ַָ�Ϊm��ķ��������������ָ�������ĺͲ�����upperBound������
    subsetSum, count := 0, 1
    for _, num := range nums {
        if subsetSum + num > upperBound { // case1���������Խ�磬�˴���Ҫ�����µ��飡����
            count++
            subsetSum = num
        } else {
            subsetSum += num // case2����Ӳ���Խ�磬��������ǰ���Ԫ�أ�����
        }
    }
    return count <= m // ����mһ������nums.length�����ֻҪ����Ϊcount<m��ķ������ڣ�����Ϊm��ķ���Ҳ��Ȼ���ڣ�����
}