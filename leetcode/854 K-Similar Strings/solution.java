class Solution {
    public int kSimilarity(String A, String B) { // �ǳ���BFS�������߼����ˣ�����
        Deque<String> bfsQueue = new LinkedList<>();
        bfsQueue.addLast(A);
        Set<String> visited = new HashSet<>();
        visited.add(A);
		int level = -1;
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            level++;
            while (size-- > 0) {
                String currentNode = bfsQueue.pollFirst();
                if (currentNode.equals(B)) {
                    return level;
                }
                for (String neighbour : getNeighbours(currentNode, B)) {
                    if (!visited.contains(neighbour)) {
                        bfsQueue.addLast(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }
        return -1;
    }
    
    private List<String> getNeighbours(String A, String B) { //���ھӡ��൱���������У�ͨ������һ���ַ����ܵ���Ľ�㣡����
        List<String> result = new ArrayList<>();
        char[] letters = A.toCharArray(); 
        
        int i = 0;
        while (i < letters.length) { // ÿ���ҵ�������ࡹ���� A[i]!=B[i] �ġ�i��������
            if (letters[i] != B.charAt(i)) {
                break;
            }
			i++;
        }
                
        for (int j=i+1; j<letters.length; j++) { // ���������� j>i �� A[j]==B[i] �ġ�j��������
            if (letters[j] == B.charAt(i)) {
                swap(letters, i, j);
                result.add(new String(letters));
                swap(letters, i, j); // ��Ҫ��ԭ�����������ھӣ�����
            }
        }     
        
        return result; // ���������ھӣ�����
    }
    
    private void swap(char[] letters, int i, int j) {
        
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
    }
}