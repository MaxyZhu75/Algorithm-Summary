class Solution {
    public int maximumSwap(int num) { // ̰�ĵؽ������ܽ����������ŵ���ǰ��λ�ã�����
        String s = String.valueOf(num);
        char[] letters = s.toCharArray(); // ��int��ת��string��������ת��char[]��������
        int n = letters.length;

        int[] previous = new int[10]; // ��¼ÿ���������һ�γ��ֵ��±꣡����
        for (int i=0; i<n; i++) {
            previous[letters[i] - '0'] = i;
        }

        for (int i=0; i<n-1; i++) { // �Ӹ�λ����λ�������ң����д���̰�ĵ��ҵ���λ����ǰλ���ұߣ���������ȥ����������
            for (int digit=9; digit > letters[i]-'0'; digit--) { // ���������������ɴ�Сɨ�裡����
                if (previous[digit] > i) {
                    swap(letters, i, previous[digit]);
                    return Integer.parseInt(new String(letters)); // ֻ������һ�Σ����ֱ�ӷ��أ�����
                }
            }
        }
        return num;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}