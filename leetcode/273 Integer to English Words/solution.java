class Solution { // 注意索引与元素对于更方便调用！！！
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] units = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) { // 递归解决！！！
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        int unit = 1000000000; // 英文中3位数字为一组；32位int类型数字最多有10位数字，即3组！！！
		for (int i=3; i >= 0; i--) { // 由大到小按组添加到结果当中！！！
            int current = num / unit;
            if (current != 0) {
                num -= current * unit; // 抹去已处理的高位数字用减法！！！
                StringBuilder group = new StringBuilder();
                recursion(group, current);
                group.append(units[i]).append(" "); // 按格式添加单位与空格！！！
                sb.append(group);
            }
			unit /= 1000;
        }
        return sb.toString().trim(); // trim()去除首位空格！！！
    }

    public void recursion(StringBuilder sb, int num) {
        if (num == 0) return; // 递归出口！！！
        if (num < 10) {
            sb.append(singles[num]).append(" "); // case1：(0, 20)的数可以直接得到其英文表示！！！
        } else if (num < 20) { 
            sb.append(teens[num-10]).append(" ");
        } else if (num < 100) { // case2：[20, 100)的数首先将十位转换成英文表示，然后对个位递归地转换成英文表示！！！
            sb.append(tens[num/10]).append(" ");
            recursion(sb, num%10);
        } else { // case3：[100,999]的数首先将百位转换成英文表示，然后对其余部分（十位和个位）递归地转换成英文表示！！！
            sb.append(singles[num/100]).append(" Hundred "); // 注意百位的单位在此处添加！！！
            recursion(sb, num%100);
        }
    }
}