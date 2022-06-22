func isHappy(n int) bool { //��Floyd������Ȧ���⡹����ȷ�Լ��ٷ���⣡����
    slow, fast := n, getNext(n)
    for slow != fast && fast != 1 { // ������������յõ�1������ѭ�����ӽ�����󣨿�֤�����ᷢ����������
        slow = getNext(slow)
        fast = getNext(getNext(fast))
    }
    return fast == 1
}

func getNext(n int) int { // ģ��������һ���ڵ㣡����
    result := 0
    for n > 0 {
        digit := n % 10
        result += digit * digit
        n /= 10
    }
    return result
}