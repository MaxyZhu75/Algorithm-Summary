class Solution {
    public int largestRectangleArea(int[] heights) { //������ջ��+�����������ϡ�������
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<>(); //��ջ����ջ�׸߶����εݼ���������

        for (int i=0; i<n; i++) { //�����򡹣�Ϊ�ұ�������Ԫ���ҵ�����һ����С��Ԫ�أ�����
            while (!stack.isEmpty() && heights[i] <= heights[stack.peekFirst()]) {
                stack.removeFirst();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekFirst(); // ע��Ĭ��Ϊ-1������
            stack.addFirst(i);
        }

        stack.clear();
        for (int i=n-1; i>=0; i--) { //�����򡹣�Ϊ���������Ԫ���ҵ��Ҳ��һ����С��Ԫ�أ�����
            while (!stack.isEmpty() && heights[i] <= heights[stack.peekFirst()]) {
                stack.removeFirst();
            }
            right[i] = stack.isEmpty() ? n : stack.peekFirst(); // ע��Ĭ��Ϊn������
            stack.addFirst(i);
        }
        
        int result = 0; // �������˱���֮���Ե�i������Ϊ������������չ��heights[i]Ϊ�ߣ�right[i]-left[i]-1Ϊ�׵ľ��μ�����ȷ��������
        for (int i=0; i<n; i++) {
            result = Math.max(result, (right[i]-left[i]-1) * heights[i]);
        }
        return result;
    }
}