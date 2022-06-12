class Solution { // 构造拓扑 + DFS；另外并查集见官方题解！！！
    Set<String> visited = new HashSet<>(); // 存储访问已访问（节点复杂时不要用数组，用哈希表）！！！
    Map<String, List<String>> adjacent = new HashMap<>(); // 构造图，邻接表记录节点的出边（节点复杂时不要用数组，用哈希表）！！！
    
    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        for (List<String> account : accountList) { // 遍历各原列表，依次填完邻接表！！！
            String firstNode = account.get(1);
            for (int j = 2; j < account.size(); j++) { // 双向构造，连接的两个节点邻接表需要互填！！！
                String currentNode = account.get(j);
                if (!adjacent.containsKey(firstNode)) {
                    adjacent.put(firstNode, new ArrayList<String>());
                }
                adjacent.get(firstNode).add(currentNode);
                
                if (!adjacent.containsKey(currentNode)) {
                    adjacent.put(currentNode, new ArrayList<String>());
                }
                adjacent.get(currentNode).add(firstNode);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> account : accountList) {
            String accountName = account.get(0);
            String firstNode = account.get(1);
            if (!visited.contains(firstNode)) { // 重新遍历原列表，查看第一个邮箱，未访问则DFS合并，已访问则直接跳过该账户！！！
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(accountName); // 先添加账户名后，DFS递归添加邮箱，最后按字典序部分排序后将合并列表加入结果！！！
                dfs(mergedAccount, firstNode);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size())); 
                result.add(mergedAccount);
            }
        }
        
        return result;
    }
	
    private void dfs(List<String> mergedAccount, String node) {
        visited.add(node); // 标记已访问！！！
        mergedAccount.add(node); // 加入到合并列表！！！
        if (!adjacent.containsKey(node)) { // 没有邻接节点则直接返回！！！
            return;
        }
        for (String neighbor : adjacent.get(node)) { // 遍历邻接节点，对未访问的进行DFS递归！！！
            if (!visited.contains(neighbor)) {
                dfs(mergedAccount, neighbor);
            }
        }
    }
}