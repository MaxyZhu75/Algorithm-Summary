func minMoves2(nums []int) int { // ����һ���������ѧ���⣬�������������е�ÿ������Ϊx����xΪ���N��������λ��ʱ������ʹ�þ�����С������
    sort.Ints(nums) // ��NΪ��������x����Ϊ��N�����е�Ψһ��λ��������
    median, result := nums[len(nums)/2], 0 // ��NΪż�����м��������Ϊp��q����λ��Ϊ(p+q)/2����ʱxֻҪ������[p,q]�е�����һ�������ɣ�����
    for _, num := range nums { // ȷ����λ����λ�û�����ʹ�ÿ��������ٶȻ���죡����
        result += abs(num-median)
    }
    return result
}

func abs(a int) int {
    if a >= 0 {
        return a
    } else {
        return -a
    }
}