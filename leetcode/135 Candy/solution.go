func candy(ratings []int) int { // ���߶����Ʒ������������
    n := len(ratings)
    result := 1;
    increase, decrease, rightmost := 1, 0, 1 // increase��ʾ�ϸ�������еĳ��ȣ�decrease��ʾ�ϸ�ݼ����еĳ��ȣ�rightmost��ʾ���¼����ǰһ�߶ȣ�����
    for i:=1; i<n; i++ {
        if ratings[i] >= ratings[i-1] { // case1���ϸ�������ƽ������
            decrease = 0
            if ratings[i] == ratings[i-1] { // ע���ƽ��Ҫ���±�Ϊ1�����Դ�ʱrightmost���ܴ���ǰ�߶ȣ�Ҳ�ܴ����ϸ�������еĳ��ȣ�����
                rightmost = 1
            } else {
                rightmost++
            }
            result += rightmost
            increase = rightmost
        } else { // case2���ϸ�ݼ�������
            decrease++
            if decrease == increase { // ��ǰ����ͬѧ��������ֵͬѧ��Ҫ����+1������
                decrease++
            }
            result += decrease // Ҫ�㣺����������ֵҪ�ӵ�ǰ����ͬѧ���ܺ�������������׼ȷ������ۼӵ�ǰ����������
            rightmost = 1
        }
    }
    return result
}