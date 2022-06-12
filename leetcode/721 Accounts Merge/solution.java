class Solution { // �������� + DFS�����Ⲣ�鼯���ٷ���⣡����
    Set<String> visited = new HashSet<>(); // �洢�����ѷ��ʣ��ڵ㸴��ʱ��Ҫ�����飬�ù�ϣ��������
    Map<String, List<String>> adjacent = new HashMap<>(); // ����ͼ���ڽӱ��¼�ڵ�ĳ��ߣ��ڵ㸴��ʱ��Ҫ�����飬�ù�ϣ��������
    
    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        for (List<String> account : accountList) { // ������ԭ�б����������ڽӱ�����
            String firstNode = account.get(1);
            for (int j = 2; j < account.size(); j++) { // ˫���죬���ӵ������ڵ��ڽӱ���Ҫ�������
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
            if (!visited.contains(firstNode)) { // ���±���ԭ�б��鿴��һ�����䣬δ������DFS�ϲ����ѷ�����ֱ���������˻�������
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(accountName); // ������˻�����DFS�ݹ�������䣬����ֵ��򲿷�����󽫺ϲ��б������������
                dfs(mergedAccount, firstNode);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size())); 
                result.add(mergedAccount);
            }
        }
        
        return result;
    }
	
    private void dfs(List<String> mergedAccount, String node) {
        visited.add(node); // ����ѷ��ʣ�����
        mergedAccount.add(node); // ���뵽�ϲ��б�����
        if (!adjacent.containsKey(node)) { // û���ڽӽڵ���ֱ�ӷ��أ�����
            return;
        }
        for (String neighbor : adjacent.get(node)) { // �����ڽӽڵ㣬��δ���ʵĽ���DFS�ݹ飡����
            if (!visited.contains(neighbor)) {
                dfs(mergedAccount, neighbor);
            }
        }
    }
}