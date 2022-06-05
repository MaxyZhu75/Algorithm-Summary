class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) { // ��̱���д��������
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products); // ���ֵ������򣡣���
        for(int i=1; i<=searchWord.length(); i++){
            List<String> words = new ArrayList<>();
            String prefix = searchWord.substring(0, i); // ����ĿҪ���ɲ��Ҵ����β�����ͬprefix������
            for(String product : products){
                if(words.size() == 3) break;
                if(product.substring(0, Math.min(i, product.length())).equals(prefix)){ // ����ÿ����Ʒ��ȷ�������ǰ׺�Ƿ��Ǻϣ�����
                    words.add(product);
                }
            }
            result.add(words);
        }
        return result;
    }
}