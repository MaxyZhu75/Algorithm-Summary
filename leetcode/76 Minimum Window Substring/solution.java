class Solution {
    public String minWindow(String s, String t) { // ���Ż��滬�����ڡ�������С�Ӵ��������⣡����
        Map<Character, Integer> hashRecordT = new HashMap<>();
        for (int i=0; i<t.length(); i++) { //��hashRecordT��ͳ��t��Ŀ����ĸ�ĸ���������
            hashRecordT.put(t.charAt(i), hashRecordT.getOrDefault(t.charAt(i), 0)+1);
        }

        List<Pair<Integer, Character>> filteredS = new ArrayList<>(); // �б�filteredS�����洢t�г��ֵ���ĸ��s�е�����������
        for (int i=0; i<s.length(); i++) {
            char letter = s.charAt(i);
            if (hashRecordT.containsKey(letter)) {
                filteredS.add(new Pair<Integer, Character>(i, letter));
            }
        }

        int left = 0, right = 0, formed = 0; // filteredS�л������ڵ����ұ߽磨������ԭ�ַ���s�л�������formed��ʾ��ǰ�����Ѵ�����ĸ����������
        Map<Character, Integer> window = new HashMap<>(); //��window���洢��ǰ���ڸ���ĸ�ĸ���������
        int[] result = {-1, 0, 0}; // result[0]���������Ĵ洢��С�Ӵ����ȣ���ʼ��Ϊ-1��result[1]��result[2]�洢���ұ߽���ԭ�ַ���s�е�λ�ã�����

        while (right < filteredS.size()) { // ��filteredS�л���������
            char letter = filteredS.get(right).getValue(); // �ұ���������ĸ������
            int count = window.getOrDefault(letter, 0) + 1;
            window.put(letter, count);
            if (window.get(letter).intValue() == hashRecordT.get(letter).intValue()) { // ͳ����������ĸ�ڴ����еĸ�����������ĸ�Ƿ��꣡����
                formed++;
            }

            while (left <= right && formed == hashRecordT.size()) { // ���ҽ���ȫ����ĸ���Ž����ѭ��������
                letter = filteredS.get(left).getValue(); // ��ߴ��������ĸ������
                int endS = filteredS.get(right).getKey();
                int startS = filteredS.get(left).getKey();
                if (result[0] == -1 || endS-startS+1 < result[0]) { // �ж��Ƿ���Ҫ���½��������
                    result[0] = endS-startS+1;
                    result[1] = startS;
                    result[2] = endS;
                }
				
                window.put(letter, window.get(letter)-1); // ���ԡ�������߽硹������
                if (window.get(letter).intValue() < hashRecordT.get(letter).intValue()) {
                    formed--;
                }
                left++;
            }
			
            right++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2]+1); // ע��substring()���ұ߽�Ķ��壨��Ҫ+1������������
    }
}