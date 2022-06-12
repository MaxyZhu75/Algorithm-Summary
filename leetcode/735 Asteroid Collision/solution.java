class Solution {
    public int[] asteroidCollision(int[] asteroids) { // �жϱ�ը����������ջ��ʹ�ã�����
        int n = asteroids.length;
        Deque<Integer> myStack = new ArrayDeque<>(); // ����һ�Ŵ����ȶ���С�����ұ�����һ���µģ����ٴ��ȶ�ǰ������ײ����Щ��ײ�������������η���������
		myStack.addFirst(asteroids[0]);

		int i = 1;
        while (i < n) {
            if (!myStack.isEmpty() && myStack.peekFirst() > 0 && asteroids[i] < 0) { // ��ը��������ǰ����ԭ�ȴ���С�����������ƶ��������������ƶ������� 
                if (myStack.peekFirst() < (-1*asteroids[i])) { // case1��ԭ�ȵı�ը��ע�������Ŀ���������ԭ�ȵı�ը������ȷ���ȶ�ǰ��������ջ���ƶ�i������
                    myStack.removeFirst();
                } else if (myStack.peekFirst() > (-1*asteroids[i])) { // case2�������ı�ը������
                    i++;
                } else { // case3��˫����ը������
                    myStack.removeFirst();
                    i++;
                }
            } else { // �����ϱ�ը�������ȶ�������
                myStack.addFirst(asteroids[i]);
                i++;
            }
        }
		
        int[] result = new int[myStack.size()];
        i = 0;
        while(!myStack.isEmpty()){
            result[i++] = myStack.removeLast(); // ˫�˶���������ӣ�����
        }
        return result;
    }
}