class Solution {
    public boolean isPerfectSquare(int num) { // ƽ����1, 4, 9, 16, 25 ......������
        int toNextSquare = 1; // ƽ���ļ������3��ʼ��2Ϊ��ֵ�ĵȲ����У�3, 5, 7, 9 ......������
        while(num > 0) { // д�ɼ���ѭ����������жϱȽϼ򵥣�����
            num -= toNextSquare;
            toNextSquare += 2;
        }

        return num == 0;
    }
}