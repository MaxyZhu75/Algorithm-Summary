class Solution {
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) return false; // ��û�������ûslot�ˣ��޷�������䣡����
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){ // �ս������1��slot������
                slots--;
                i++;
            } else {
                while (i < n && preorder.charAt(i) != ',') { // �����ֶ��꣬�����ľ���ֵ������
                    i++;
                }
                slots++; // �ǿսڵ�����1��slot�������һ���ṩ2��slot����2-1=1������
            }
        }
        return slots == 0;
    }
}