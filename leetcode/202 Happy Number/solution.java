class Solution {
    public boolean isHappy(int n) { //��Floyd������Ȧ���⡹����ȷ�Լ��ٷ���⣡����
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) { // ������������յõ�1������ѭ�����ӽ�����󣨿�֤�����ᷢ����������
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

     public int getNext(int n) { // ģ��������һ���ڵ㣡����
        int result = 0;
        while (n > 0) {
            int digit = n % 10;;
            result += digit * digit;
            n /= 10;
		}
        return result;
    }
}