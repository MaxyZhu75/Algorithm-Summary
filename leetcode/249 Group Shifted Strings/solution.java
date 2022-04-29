class Solution {
    public List<List<String>> groupStrings(String[] strings) { // ��ϣ��洢��ĸ֮��Ĳ�ֵ������
        Map<String, List<String>> hashRecord = new HashMap<>(); // �洢��ʽ��{����ĸ��ʾ�Ĳ�ֵ����ֵ��ͬ�����}��hashRecord["cd"] = ["acf", "gil", "xzc"]������
        
        for (String s : strings) {
            String hashKey = getHash(s); // ��д��ϣֵ���㣡����
            if (hashRecord.get(hashKey) == null) {
                hashRecord.put(hashKey, new ArrayList<>());
            } 
            hashRecord.get(hashKey).add(s);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : hashRecord.values()) { // ��ĸ���ֵ��ͬ���Ѿ��ֵ�ͬһ�飬��ÿ�����𰸣�����
            result.add(group);
        }
        
        return result;
    }

    public String getHash(String s) { // �����ַ���ÿ���ַ�֮��Ĳ�ֵ���ʾΪ�ַ�������["acf", "gil", "xzc"]�����[2,3]��ת����Ӣ����ĸ��ʾ��Ϊ[c,d]������
        char[] letters = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < letters.length; i++) {
            sb.append((char)((letters[i]-letters[i-1]+26) % 26 + 'a')); // �����ֵҪ������ĸ��ѭ������Ҫ�ֶ� +26 �� %26 ������
        }
        
        return sb.toString();
    }
}