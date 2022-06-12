class Solution {
    public String multiply(String num1, String num2) { // 算法按照小学乘法竖式运算规则即可！！！
        int m = num1.length(), n = num2.length();
        int[] digits = new int[m+n];

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // 此处可以用减法转换为整形！！！
                int p1 = i+j, p2 = i+j+1;
                digits[p1] += (multiply + digits[p2]) / 10; // 注意：此处用「+=」累加nums2低位运算的结果！！！
                digits[p2] = (multiply + digits[p2]) % 10; // 运算结果记得要加上一层的进位digits[p2]！！！
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
			if(!(sb.length() == 0 && digit == 0)) { // 需要跳过所有前导0！！！
				sb.append(digit);	
			}
		}
        return sb.length() == 0 ? "0" : sb.toString();
    }
}