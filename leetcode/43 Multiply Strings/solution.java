class Solution {
    public String multiply(String num1, String num2) { // �㷨����Сѧ�˷���ʽ������򼴿ɣ�����
        int m = num1.length(), n = num2.length();
        int[] digits = new int[m+n];

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // �˴������ü���ת��Ϊ���Σ�����
                int p1 = i+j, p2 = i+j+1;
                digits[p1] += (multiply + digits[p2]) / 10; // ע�⣺�˴��á�+=���ۼ�nums2��λ����Ľ��������
                digits[p2] = (multiply + digits[p2]) % 10; // �������ǵ�Ҫ����һ��Ľ�λdigits[p2]������
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
			if(!(sb.length() == 0 && digit == 0)) { // ��Ҫ��������ǰ��0������
				sb.append(digit);	
			}
		}
        return sb.length() == 0 ? "0" : sb.toString();
    }
}