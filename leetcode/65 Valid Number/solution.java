class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        char[] letters = s.toCharArray();
        boolean result;
        int ePosition = -1;
		
        for (int i=0; i<n; i++) {
            if (letters[i] == 'e' || letters[i] == 'E') {
                if (ePosition == -1) {
                    ePosition = i; // ����ɨ��e��λ�ò���¼������
                } else {
                    return false; // �����ظ�����e������
                }
            }
        }

        if (ePosition != -1) { // case1: �������e���������ǡ��������򡸸����������Ҳ�����ǡ�������������
            result = check(letters, 0, ePosition-1, false) && check(letters, ePosition+1, n-1, true);
        } else {
            result = check(letters, 0, n-1, false); // case2: ���������e �����ο����ǡ��������򡸸�������������
        }
        
        return result;
    }
	
    public boolean check(char[] letters, int start, int end, boolean mustInteger) { // �����ж��Ƿ��ǺϷ��ġ��������򡸸�������������
        if (start > end) return false;
        if (letters[start] == '+' || letters[start] == '-') { // ֻ����λ�����Ƿ���λ������
			start++;
		}
        
		boolean hasDot = false, hasDigit = false;
        for (int i=start; i<=end; i++) {
            if (letters[i] == '.') { // case1��С���㡸.��������һ�Σ��Ҳ�����������������
                if (mustInteger || hasDot) {
					return false;
				}
                hasDot = true;
            } else if (letters[i] >= '0' && letters[i] <= '9') { // case2�����֡�0~9�����ٳ���һ�Σ�����
                hasDigit = true;
            } else {
                return false; // case3�����ٴγ��ַ���λ������Ч���֣�����
            }
        }
        return hasDigit; // ���ٴ���һ�����֣�����
    }
}