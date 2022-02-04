class Solution {
    public String reversePrefix(String word, char ch) {
        int stopIndex = word.indexOf(ch); // String.indexOf()ֱ���ܷ��ز����ַ���һ�γ��ֵ��������������򷵻�-1������
        char[] letters = word.toCharArray(); // תΪchar[]���㷴ת����������

        if (stopIndex == -1 || stopIndex == 0) {
            return word;
        }

        reverse(letters, stopIndex);
        String result = String.valueOf(letters); // String.valueOf()֧�ָ�������תString������

        return result;
    }


    public void reverse(char[] letters, int stopIndex) {
        int p1 = 0;
        int p2 = stopIndex;
        while (p1 <= p2) {
            char temp = letters[p1];
            letters[p1] = letters[p2];
            letters[p2] = temp;
            p1++;
            p2--;
        }
    }
}