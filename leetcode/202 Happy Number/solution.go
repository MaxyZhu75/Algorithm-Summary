func isHappy(n int) bool { //「Floyd链表判圈问题」；正确性见官方题解！！！
    slow, fast := n, getNext(n)
    for slow != fast && fast != 1 { // 三种情况：最终得到1，进入循环，接近无穷大（可证明不会发生）！！！
        slow = getNext(slow)
        fast = getNext(getNext(fast))
    }
    return fast == 1
}

func getNext(n int) int { // 模仿链表下一个节点！！！
    result := 0
    for n > 0 {
        digit := n % 10
        result += digit * digit
        n /= 10
    }
    return result
}