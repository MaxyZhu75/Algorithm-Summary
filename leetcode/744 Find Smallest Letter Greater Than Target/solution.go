func nextGreatestLetter(letters []byte, target byte) byte { // �����Ѿ��ź�������飬Ӧ�����뵽���ֲ��ҵ�˼�룡����
    var low, high, resultIndex int = 0, len(letters)-1, 0 // ������ֲ��ҵĿ����69���󿪷����ƣ�����ϸ��Ӧ��������������������
    if letters[high] <= target { // Go����byte�ַ�ֱ�ӱȴ�С���ɣ������������0�ȴ�С�𰸻��������
        return letters[0] // ��������������ĸ������target������Ŀ������ѭ����֪��ֱ�ӷ���ͷ��Ԫ�أ�����
    }
    for (low <= high) {
        mid := low + (high-low)/2
        if letters[mid] > target {
            resultIndex = mid // �˴�����ĸ����target������½���Ҫ����resultIndex��ֱ��low����highʱ��result���Ϸ���ƽ�Ŀ�꣬��һ�����ϴ�������Ŀ����ĸ�����С��ĸ������
            high = mid-1
        } else {
            low = mid+1
        }
    }
    return letters[resultIndex]
}