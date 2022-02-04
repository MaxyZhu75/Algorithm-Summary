func mySqrt(x int) int {
    var low, high, result int = 0 ,x, 0 // ����Ϊ���ֲ���˼��Ļ�����֮һ�����ڶ��ֲ��ҵĲ�ͬ��Ŀ�ھ���ʵ��ʱ������������Ҫ����������������¼��㣡����
    for (low <= high) { // Ҫ��һ��low��high�ĳ�ʼ���趨���Լ�while�ĳ�������������
        mid := low + (high-low)/2 // ��ֵ����д���Ա���������⣻ע��˴�Ϊint�ͣ�����
        square := mid * mid  // �˴�ʹ��int���ճ˷��������������⣬����ת��Ϊlong�������Կ����ó������sqrt= x/mid��Ϊ�ж�����������
        if square <= x { // Ҫ������򵥵Ķ��ֲ��һ���Ϊ����С�ڴ������������������ĿӦ���������Ӧ����������
            result = mid  // �˴���С�ڼ�����Ŀ�������½���Ҫ����result��ֱ��low����highʱ��result���·���ƽ�Ŀ�꣬��һ�����ϴ���Ҫ�������С��ֻȡ����������
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return result // Ҫ��������󷵻ص���low, high�����¶���һ���������������
}