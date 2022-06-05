class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) { // 简短暴力写法！！！
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products); // 按字典序排序！！！
        for(int i=1; i<=searchWord.length(); i++){
            List<String> words = new ArrayList<>();
            String prefix = searchWord.substring(0, i); // 按题目要求由查找词依次产生不同prefix！！！
            for(String product : products){
                if(words.size() == 3) break;
                if(product.substring(0, Math.min(i, product.length())).equals(prefix)){ // 遍历每个产品，确认与查找前缀是否吻合！！！
                    words.add(product);
                }
            }
            result.add(words);
        }
        return result;
    }
}