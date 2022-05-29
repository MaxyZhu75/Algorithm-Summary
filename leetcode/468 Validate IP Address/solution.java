class Solution {
    public String validIPAddress(String queryIP) { // ���������жϣ�����
        if (queryIP.indexOf('.') >= 0 && checkIPv4(queryIP)) return "IPv4";
        if (queryIP.indexOf(':') >= 0 && checkIPv6(queryIP)) return "IPv6";
        return "Neither";
    }

    public boolean checkIPv4(String queryIP) {
        int current = -1; // ��дsplit()������current��nextָ���ַ�����'.'������������
        for (int i=0; i<4; i++) {
            int next = (i == 3) ? queryIP.length() : queryIP.indexOf('.', current+1);
            int numLength = next - current - 1;
			if (numLength < 1 || numLength > 3) return false; // ����һ������λ���Ƿ���[1,3]֮�䣡����
                
			int num = 0;
            for (int j=current+1; j<next; j++) {
                if (!Character.isDigit(queryIP.charAt(j))) return false; // ���������Ƿ�ֻ�������֣�����
                num = 10*num + (queryIP.charAt(j) - '0');
            }
            if (num == 0 && numLength > 1) return false; // �����������Ƿ񲻰���ǰ���㣻ע����Ҫ�����жϣ�����
            if (num > 0 && queryIP.charAt(current+1) == '0') return false;
            if (num > 255) return false; // �����ģ����ִ�С�Ƿ���[0,255]֮�䣡����
            
            current = next;
        }
        return true;
    }

    public boolean checkIPv6(String queryIP) {
        int current = -1; // ��дsplit()������current��nextָ���ַ�����':'������������
        for (int i=0; i<8; i++) {
            int next = (i == 7) ? queryIP.length() : queryIP.indexOf(':', current+1);
            int numLength = next - current - 1;
			if (numLength < 1 || numLength > 4) return false; // ����һ������λ���Ƿ���[1,4]֮�䣡����

			for (int j = current+1; j<next; j++) {
                if (!(Character.isDigit(queryIP.charAt(j)) || ('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f'))) {
                    return false; // ���������Ƿ�ֻ�������֣�����a-f������A-F������
                }
            }
            current = next;
        }

        return true;
    }
}