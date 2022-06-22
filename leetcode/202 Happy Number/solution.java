class Solution {
    public boolean isHappy(int n) { //「Floyd链表判圈问题」；正确性见官方题解！！！
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) { // 三种情况：最终得到1，进入循环，接近无穷大（可证明不会发生）！！！
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

     public int getNext(int n) { // 模仿链表下一个节点！！！
        int result = 0;
        while (n > 0) {
            int digit = n % 10;;
            result += digit * digit;
            n /= 10;
		}
        return result;
    }
}