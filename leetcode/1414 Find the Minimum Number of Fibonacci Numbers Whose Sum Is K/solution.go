func findMinFibonacciNumbers(k int) int { // ��С�ڵ���k��쳲���������ȡ���̰�ģ����ѵ�����֤��̰�Ĳ�����ȷ�ԣ�����
    fibonacciNumbers := []int{1, 1} // ��List���㶯̬���Ԫ�أ�����
    pre1, pre2 := 1, 1
    for (pre1 + pre2 <= k) { // ��while������������дС��k��쳲�������������
        current := pre1 + pre2
        fibonacciNumbers = append(fibonacciNumbers, current)
        pre2 = pre1
        pre1 = current
    }

    n := len(fibonacciNumbers)
    count := 0
    left := k
    for i:=n-1; i>=0 && k>0; i-- {
        greedyNum := fibonacciNumbers[i]
        if left - greedyNum >= 0 {
            left -= greedyNum
            count++
        } 
    }

    return count
}