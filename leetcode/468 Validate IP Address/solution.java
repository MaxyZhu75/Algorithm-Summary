class Solution {
    public String validIPAddress(String queryIP) { // 分类依次判断！！！
        if (queryIP.indexOf('.') >= 0 && checkIPv4(queryIP)) return "IPv4";
        if (queryIP.indexOf(':') >= 0 && checkIPv6(queryIP)) return "IPv6";
        return "Neither";
    }

    public boolean checkIPv4(String queryIP) {
        int current = -1; // 手写split()；利用current和next指向字符串中'.'的索引！！！
        for (int i=0; i<4; i++) {
            int next = (i == 3) ? queryIP.length() : queryIP.indexOf('.', current+1);
            int numLength = next - current - 1;
			if (numLength < 1 || numLength > 3) return false; // 条件一：数字位数是否在[1,3]之间！！！
                
			int num = 0;
            for (int j=current+1; j<next; j++) {
                if (!Character.isDigit(queryIP.charAt(j))) return false; // 条件二：是否只包含数字！！！
                num = 10*num + (queryIP.charAt(j) - '0');
            }
            if (num == 0 && numLength > 1) return false; // 条件三：它是否不包含前导零；注意需要两条判断！！！
            if (num > 0 && queryIP.charAt(current+1) == '0') return false;
            if (num > 255) return false; // 条件四：数字大小是否在[0,255]之间！！！
            
            current = next;
        }
        return true;
    }

    public boolean checkIPv6(String queryIP) {
        int current = -1; // 手写split()；利用current和next指向字符串中':'的索引！！！
        for (int i=0; i<8; i++) {
            int next = (i == 7) ? queryIP.length() : queryIP.indexOf(':', current+1);
            int numLength = next - current - 1;
			if (numLength < 1 || numLength > 4) return false; // 条件一：数字位数是否在[1,4]之间！！！

			for (int j = current+1; j<next; j++) {
                if (!(Character.isDigit(queryIP.charAt(j)) || ('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f'))) {
                    return false; // 条件二：是否只包含数字，或者a-f，或者A-F！！！
                }
            }
            current = next;
        }

        return true;
    }
}