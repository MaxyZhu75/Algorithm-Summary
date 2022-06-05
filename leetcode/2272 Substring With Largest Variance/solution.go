func largestVariance(s string) int { // LeetCode��53���������������⣻ʱ���Ż��ɿ���DP������
    result := 0
    for c1 := 'a'; c1 <= 'z'; c1++ { // ������ִ��������ַ�Ϊc1�����ִ������ٵ��ַ�Ϊc2����
        for c2 := 'a'; c2 <= 'z'; c2++ {
            if (c1 == c2) {
                continue
            }
            count, difference := 0, math.MinInt32 // ά��c1��c2�ĳ��ִ���֮�����
            for i:=0; i<len(s); i++ { // c1��c2���붼�������Ӵ��У���c2δ���֣���difference��ʼ��Ϊ����С������
                if s[i] == byte(c1) { // ���������Ҫ������ע��������ϸ�ڣ�����
                    count++
                    difference++ // �˴�difference��c1��ͳ�ƽ�����ȷ��c2�������Ӵ���ʱ��difference��Ϊ����С������Ч������
                } else if s[i] == byte(c2) {
                    count--
                    difference = count
                    count = max(0, count) // c1���ִ���������c2ʱ�����֮ǰ��ͳ�ƣ�����countΪ0���Ҵ�ʱdifferenceҲ��ȻΪ0��-1������Ҫ����Ϊ����С����Ϊ�Ѿ���ʱ��ȷ��c2���������Ӵ����У����Ӵ�Ϊc1c2��c2��������
                }
                result = max(result, difference)
            }
        }
    }
    return result
}

func max (a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}