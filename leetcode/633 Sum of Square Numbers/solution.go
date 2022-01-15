func judgeSquareSum(c int) bool {
    var p1 int = 0 // Go����û��long���˴�int���ɣ�����
    var p2 int = int(math.Sqrt(float64(c))) // import math����������math.Sqrt()��S��д����ʹ�ú���ʱҪ��תΪfloat64��ע��ǿ��ת����д����java��ͬ������
    for p1 <= p2 { // Go��������forʵ��while������
        var squareSum int = p1*p1 + p2*p2
        if squareSum == c {
            return true
        } else if squareSum < c {
            p1++
        } else {
            p2--
        }
    }
    return false
}