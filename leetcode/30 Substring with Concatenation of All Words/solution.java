class Solution {
    public List<Integer> findSubstring(String s, String[] words) { // �������� + ��ϣ������
        List<Integer> result = new ArrayList<>();
        int m = words.length, n = words[0].length();
        for (int i=0; i<n; i++) { // ϸ�ڣ����ڻ�������Ϊ��n���������ѭ����Ҫ����������㡸0��n-1��������
            if (i+m*n > s.length()) {
                break;
            }
            Map<String, Integer> hashRecord = new HashMap<>();
            for (int j=0; j<m; j++) { // ͳ�ƴ�СΪ��m*n���Ļ��������ڡ�s���г���Ϊn�ĸ���������������
                String word = s.substring(i+j*n, i+(j+1)*n);
                hashRecord.put(word, hashRecord.getOrDefault(word, 0) + 1);
            }
            for (String word : words) { // ���ݡ�words��ͳ�Ƶ�ǰ���ڡ�����Щ����Щ��������
                hashRecord.put(word, hashRecord.getOrDefault(word, 0) - 1);
                if (hashRecord.get(word) == 0) {
                    hashRecord.remove(word); // ϸ�ڣ��պõ���Ϊ0ʱ����ֵ����Ҫremove������
                }
            }
            for (int start = i; start < s.length()-m*n+1; start += n) { // ������СΪ��m*n���Ĵ��ڣ�ÿ�λ����ľ���Ϊ��n��������
                if (start != i) {
                    String word = s.substring(start+(m-1)*n, start+m*n); // �ұ������ĵ��ʽ��봰�ڣ�����
                    hashRecord.put(word, hashRecord.getOrDefault(word, 0) + 1);
                    if (hashRecord.get(word) == 0) {
                        hashRecord.remove(word);
                    }
                    word = s.substring(start-n, start); // ��ߵ����˳����ڣ�����
                    hashRecord.put(word, hashRecord.getOrDefault(word, 0) - 1);
                    if (hashRecord.get(word) == 0) {
                        hashRecord.remove(word);
                    }
                }
                if (hashRecord.isEmpty()) { // ȫ�����ʸպõ�����remove����ϣ����Ϊ�գ�����
                    result.add(start);
                }
            }
        }
        return result;
    }
}