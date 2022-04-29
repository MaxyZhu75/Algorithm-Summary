class Solution {
    public int[] getModifiedArray(int length, int[][] updates) { // ���������⣨Range Caching��������
        int[] array = new int[length];
        int start = 0, end = 0, inc = 0;
        for (int[] operation : updates) { // ֻ�ڲ�������ı߽��ϴ洢�仯��ֵ���������������䶼���и��£�������
            start = operation[0];
            end = operation[1];
            inc = operation[2];
            array[start] += inc; // array[start] = array[start] + inc������
            if (end < length-1) array[end+1] -= inc;  // array[end+1] = array[end+1] - inc������
        }

        for (int i=1; i<length; i++) {
            array[i] = array[i] + array[i-1]; // array[i] = array[i] + array[i-1]������
        }

        return array;
    }
}