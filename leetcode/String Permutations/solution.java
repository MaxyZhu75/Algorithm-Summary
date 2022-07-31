class Solution {
    List<String> result = new ArrayList<>();
    Set<String> hashRecord = new HashSet<>();
	StringBuilder sb = new StringBuilder();
    int[] visited;
    String s;

    public String[] permutation(String s) {
        this.s = s;
        this.visited = new int[s.length()];
        dfsBackTrack();
        String[] arr = new String[result.size()];
        int i = 0;
        for (String current : result) {
            arr[i++] = current;
        }
        return arr;
    }

    public void dfsBackTrack() {
        if (sb.length() == s.length()) {
            String answer = sb.toString();
            if (!hashRecord.contains(answer)) {
                result.add(answer);
                hashRecord.add(answer);
            }
            return;
        }
        for (int i=0; i<s.length(); i++) {
            if (visited[i]==1) continue;
            visited[i] = 1;
            sb.append(s.charAt(i));
            dfsBackTrack();
            visited[i] = 0;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}