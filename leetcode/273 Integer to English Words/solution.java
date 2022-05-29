class Solution { // ע��������Ԫ�ض��ڸ�������ã�����
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] units = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) { // �ݹ���������
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        int unit = 1000000000; // Ӣ����3λ����Ϊһ�飻32λint�������������10λ���֣���3�飡����
		for (int i=3; i >= 0; i--) { // �ɴ�С������ӵ�������У�����
            int current = num / unit;
            if (current != 0) {
                num -= current * unit; // Ĩȥ�Ѵ���ĸ�λ�����ü���������
                StringBuilder group = new StringBuilder();
                recursion(group, current);
                group.append(units[i]).append(" "); // ����ʽ��ӵ�λ��ո񣡣���
                sb.append(group);
            }
			unit /= 1000;
        }
        return sb.toString().trim(); // trim()ȥ����λ�ո񣡣���
    }

    public void recursion(StringBuilder sb, int num) {
        if (num == 0) return; // �ݹ���ڣ�����
        if (num < 10) {
            sb.append(singles[num]).append(" "); // case1��(0, 20)��������ֱ�ӵõ���Ӣ�ı�ʾ������
        } else if (num < 20) { 
            sb.append(teens[num-10]).append(" ");
        } else if (num < 100) { // case2��[20, 100)�������Ƚ�ʮλת����Ӣ�ı�ʾ��Ȼ��Ը�λ�ݹ��ת����Ӣ�ı�ʾ������
            sb.append(tens[num/10]).append(" ");
            recursion(sb, num%10);
        } else { // case3��[100,999]�������Ƚ���λת����Ӣ�ı�ʾ��Ȼ������ಿ�֣�ʮλ�͸�λ���ݹ��ת����Ӣ�ı�ʾ������
            sb.append(singles[num/100]).append(" Hundred "); // ע���λ�ĵ�λ�ڴ˴���ӣ�����
            recursion(sb, num%100);
        }
    }
}