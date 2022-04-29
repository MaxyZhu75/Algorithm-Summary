class Solution {
    public List<List<String>> groupAnagrams(String[] strs) { // ��ϣ��+���򣡣���
        Map<String, List<String>> hashRecord = new HashMap<>(); // �洢��ʽΪ(������str��ԭstr�б�)������
        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            if (!hashRecord.containsKey(key)) {
                hashRecord.put(key, new ArrayList<String>());
            }
            hashRecord.get(key).add(str);
        }
        return new ArrayList<List<String>>(hashRecord.values());
    }
}