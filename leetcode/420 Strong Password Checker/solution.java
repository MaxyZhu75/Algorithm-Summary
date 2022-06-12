class Solution {
    public int strongPasswordChecker(String password) { // �������ѡ�����Ų���������ģ��������ٷ���𣡣���
        int n = password.length();
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (int i=0; i<n; i++) { // ͳ�������ַ�����������֣�����
            char letter = password.charAt(i);
            if (Character.isLowerCase(letter)) {
                hasLower = 1;
            } else if (Character.isUpperCase(letter)) {
                hasUpper = 1;
            } else if (Character.isDigit(letter)) {
                hasDigit = 1;
            }
        }
        
		int categories = hasLower + hasUpper + hasDigit;
		int operationC = 3-categories; // ��֤�����ַ�������ȫ����3���ַ�ʱ������Ҫ�Ĳ�������������
		int insert = 0, delete = 0, replace = 0; // ���ֲ�������������
		
        if (n < 6) { // ��֤��ֻ�С����һ���ַ������������壨���ţ�������ʱ��֤�ַ������Ⱥ��ַ����������Ҫ�󼴿ɣ�����
            insert = 6-n;
			return Math.max(insert, operationC);
        
		} else if (n <= 20) { // ��֤��ֻ�С��滻һ���ַ������������壨���ţ�������ʱ��֤�����ַ����ַ����������Ҫ�󼴿ɣ�����
			int repeat = 0;
            char preLetter = '#';
            for (int i=0; i<n; i++) { // ͳ�������ַ�����k��ÿ���Ӧfloor(k/3)���滻����������
                char letter = password.charAt(i);
                if (letter == preLetter) {
                    repeat++;
                } else {
                    replace += repeat/3;
                    preLetter = letter;
					repeat = 1;
                }
            }
            replace += repeat/3;
            return Math.max(replace, operationC);
        
		} else { // ��֤��ֻ�С��滻һ���ַ����͡�ɾ��һ���ַ������������壨���ţ�������ʱ��֤�����ַ����ַ����������Ҫ�󼴿ɣ�����
            delete = n - 20;
            int case1 = 0; // ��ʱ����case1��Ӧ�Ĳ�������������
            int repeat = 0;
            char preLetter = '#';
            for (int i=0; i<n; i++) { // ͳ�������ַ�����k����������Ա������и��£�����
                char letter = password.charAt(i);
                if (letter == preLetter) {
                    repeat++;
                } else {
                    if (delete > 0 && repeat >= 3) {
                        if (repeat % 3 == 0) { // case0������k%3=0����������ɾ��1���ַ�������1���滻����������
                            delete--;
                            replace--;
                        } else if (repeat % 3 == 1) { // case1������k%3=1��������Կ���ɾ��2���ַ�������1���滻��������������ִ�У�������
                            case1++;
                        }  // case2������k%3=2��������Կ���ɾ��3���ַ�������1���滻������������ʾ���ǣ�������
                    }
                    replace += repeat/3;
                    preLetter = letter;
                    repeat = 1;
                }
            }
            if (delete > 0 && repeat >= 3) { // ������ѭ�����һ�εĲ���������
                if (repeat % 3 == 0) {
                    delete--;
                    replace--;
                } else if (repeat % 3 == 1) {
                    case1++;
                }
            }
            replace += repeat/3;

            case1 = Math.min(Math.min(case1, replace), delete/2); // ʵ��ʹ��case1��Ӧ�Ĳ�����ȡ��Min{case1, replace, delete/2}��������
            replace -= case1;
            delete -= case1 * 2;
      
            int case2 = Math.min(replace, delete/3); // ʵ��ʹ��case2��Ӧ�Ĳ�����ȡ��Min{replace, delete/3}��������
            replace -= case2;
            delete -= case2 * 3;
            return (n-20) + Math.max(replace, operationC);
        }
    }
}