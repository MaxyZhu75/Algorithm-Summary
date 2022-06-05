class Solution {
    public List<String> removeComments(String[] source) { // �������������
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList();
        for (String line: source) {
            char[] letters = line.toCharArray();
            if (!inBlock) {
				sb = new StringBuilder(); // ��ȡÿ�д���ʱ����ע�ͣ�Ҫͨ��new����sb������
			}
            int i = 0;
            while (i < line.length()) {
                if (!inBlock && i+1 < line.length() && letters[i] == '/' && letters[i+1] == '*') {
                    inBlock = true; // case1������ע����������/*���������������������ַ�������״̬����Ϊ��ע���У�����
                    i++;
                } else if (inBlock && i+1 < line.length() && letters[i] == '*' && letters[i+1] == '/') {
                    inBlock = false; // case2����ע����������*/���������������������ַ�������״̬����Ϊ����ע���У�����
                    i++;
                } else if (!inBlock && i+1 < line.length() && letters[i] == '/' && letters[i+1] == '/') {
                    break; // case3������ע����������//���������ȼ�����Ը��е����ಿ��ֱ��break������
                } else if (!inBlock) {
                    sb.append(letters[i]); // case4����Ч���룬��Ҫ��¼������
                }
                i++;
            }
            if (!inBlock && sb.length() > 0) { // ���м�¼�������ж��Ƿ���Ҫ��ӵ����������
                result.add(new String(sb));
            }
        }
        return result;
    }
}