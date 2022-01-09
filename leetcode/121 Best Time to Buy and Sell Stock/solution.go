func maxProfit(prices []int) int {
    var n int = len(prices) // len()��ʹ��!!!
    if n==0 { 
        return 0
    }
    var currentMin int = prices[0] // ��ʼֵΪ��һ��ɼ�!!!
    maxProfit := 0
    for i:=0; i<n; i++ {
        if prices[i] < currentMin {
            currentMin = prices[i] // if-else �ṹ���������������������������ͬһ�����������!!!
        } else {
            maxProfit = Max(maxProfit, prices[i]-currentMin) // ���͵����ֵ�����ֶ�д!!!
        }
    }
    return maxProfit
}

func Max(a int, b int) int {
    if a < b {
        return b
    } else {
        return a
    }
}