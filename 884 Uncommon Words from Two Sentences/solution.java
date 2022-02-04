class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] wordList1 = s1.split(" ");
        String[] wordList2 = s2.split(" ");
        List<String> uncommonList = new ArrayList<>(); // 先创建ArrayList方便添加，最后再转回Array！！！

        Map<String, Integer> hashRecord = new HashMap<>();
        for (String word : wordList1) {
            hashRecord.put(word, hashRecord.getOrDefault(word, 0) + 1);
        }
        for (String word : wordList2) {
            hashRecord.put(word, hashRecord.getOrDefault(word, 0) + 1);
        }

        for (String key : hashRecord.keySet()) {
            if (hashRecord.get(key) == 1) {
                uncommonList.add(key);
            }
        }

        String[] result = uncommonList.toArray(new String[uncommonList.size()]); // 记住ArrayList转Array写法；List.toArray(T[])括号内new一个数组，声明类型及大小！！！

        return result;
    }
}