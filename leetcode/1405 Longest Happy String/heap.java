class Solution {
    public String longestDiverseString(int a, int b, int c) { // ̰�� + �ѣ�����
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]); // �󶥶ѣ����ڵ�Ϊʣ�����������ַ�������
        if (a > 0) {
            heap.add(new int[]{'a', a});
        }
        if (b > 0) {
            heap.add(new int[]{'b', b});
        }
        if (c > 0) {
            heap.add(new int[]{'c', c});
        }

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            int[] root = heap.poll(); // ÿ���ȵ��������ַ�root���������������ʣ������ӻض��У�����
            int k = sb.length();
            if (k >= 2 && sb.charAt(k-1) == root[0] && sb.charAt(k-2) == root[0]) { // case1����β������������������ͬ�ַ�������
                if (!heap.isEmpty()) { // ���������нڵ㣬�����ƴ�Ӵζ���ַ�������
                    int[] second = heap.poll();
                    sb.append((char)second[0]);
                    second[1]--;
					if (second[1] > 0) { // �ζ�ڵ����������ʣ������ӻض��У�����
                        heap.add(second);
                    }
                    heap.add(root); // �����������ڵ���ӻض��У�����
                }
            } else { // case2�����������̰�ĵ�ƴ�������ַ����ɣ�����
                sb.append((char) root[0]);
				root[1]--;
                if (root[1] > 0) {
                    heap.add(root); // ���ڵ����������ʣ������ӻض��У�����
                }
            }
        }
        return sb.toString();
    }
}