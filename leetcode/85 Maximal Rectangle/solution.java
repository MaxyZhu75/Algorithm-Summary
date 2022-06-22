class Solution {
    public int maximalRectangle(char[][] matrix) { //������ջ��+����ֱ�������������ϡ�������
        int m = matrix.length;
        int n = matrix[0].length;
		if (m == 0) return 0;

        int[][] left = new int[m][n]; // left[i][j]��ʾ(i, j)�������1������������
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0) ? 1 : left[i][j-1]+1;
                }
            }
        }

        int result = 0;
        for (int j=0; j<n; j++) { // �Ե�j��Ϊ��X�᡹���ף�ʹ�û�����״ͼ�ķ���������
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new LinkedList<>();
            
			for (int i=0; i<m; i++) { //�����ϵ��¡���Ϊ�·�������Ԫ���ҵ��Ϸ���һ����С��Ԫ�أ�����
                while (!stack.isEmpty() && left[i][j] <= left[stack.peekFirst()][j]) {
                    stack.removeFirst();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peekFirst(); // �ϱ߽磻ע��Ĭ��Ϊ-1������
                stack.addFirst(i);
            }

            stack.clear();
            for (int i = m - 1; i >= 0; i--) { //�����µ��ϡ���Ϊ�Ϸ�������Ԫ���ҵ��·���һ����С��Ԫ�أ�����
                while (!stack.isEmpty() && left[stack.peekFirst()][j] >= left[i][j]) {
                    stack.removeFirst();
                }
                down[i] = stack.isEmpty() ? m : stack.peekFirst(); // �±߽磻ע��Ĭ��Ϊm������
                stack.addFirst(i);
            }

            for (int i=0; i<m; i++) { // �������˱���֮���Ե�j��Ϊ�ᣬ�����i������Ϊ������������չ��down[i]-up[i]-1Ϊ�ߣ�left[i][j]Ϊ���ľ��μ�����ȷ��������
                int height = down[i]-up[i]-1;
                result = Math.max(result, height*left[i][j]);
            }
        }

        return result;
    }
}