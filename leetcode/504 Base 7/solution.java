class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        
        boolean isNegative = false; // �Ȼ�Ϊ������������
        if (num < 0) {
            num = -num;
            isNegative = true;
        }

        StringBuilder sb = new StringBuilder();
        while (num != 0) { // ע��ߵ�λ˳�����⣡����
            int oneBit = num % 7;
            sb.append(oneBit);
            num /= 7;
        }

        String result = sb.reverse().toString();
        
        return isNegative ? "-" + result : result; // �ж��Ƿ��ϸ��ţ�����
    }
}