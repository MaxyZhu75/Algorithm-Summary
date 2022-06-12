class Solution {
    public String longestDiverseString(int a, int b, int c) { // ̰�� + ���鶯̬����ʵ�ֶ�PriorityQueue�Ĺ��ܣ�������
        int[][] letters = {{'a', a}, {'b', b}, {'c', c}}; // int��������洢�ַ����ַ�ʣ������������
        StringBuilder sb = new StringBuilder();
        while (true) { // ̰�ĵ��������ʣ�����������ַ�������
            Arrays.sort(letters, (o1, o2) -> o2[1]-o1[1]); // ÿ��ѭ����Ҫ�Ȱ�ʣ�������ɴ�С���򣡣���
            if (letters[0][1] == 0) {
                break; // ����һ�������ַ�ʹ�������ˣ�����������ַ���������
            }
			int k = sb.length();
            if (k >= 2 && sb.charAt(k-1) == letters[0][0] && sb.charAt(k-2) == letters[0][0]) { // case1����β������������������ͬ�ַ�������
                if (letters[1][1] == 0) {
                    break; // ���ڶ�����ʣ�����ַ�������ѭ�����أ���ʱ���Ǿ����ܳ��Ŀ����ַ�����������
                } 
                sb.append((char)letters[1][0]); // ƴ�Ӵζ���ַ�������
                letters[1][1]--;
            } else { // case2�����������̰�ĵ�ƴ�������ַ����ɣ�����
                sb.append((char)letters[0][0]);
                letters[0][1]--;
            }
        }
        return sb.toString();
    }
}