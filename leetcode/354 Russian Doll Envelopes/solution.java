class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> (o1[0] == o2[0]) ? o2[1]-o1[1] : o1[0]-o2[0]); //「w升序，h降序」！！！
        List<Integer> d = new ArrayList<>(); // 细节：二分DP，使用列表实现！！！
        d.add(envelopes[0][1]);
        for (int i=1; i<envelopes.length; i++) {
            if (envelopes[i][1] > d.get(d.size()-1)) {
                d.add(envelopes[i][1]); // case1：可以接在d中的最大值之后，形成一个长度更长的严格递增子序列！！！
            } else {
                int index = binarySearch(d, envelopes[i][1]);
                d.set(index, envelopes[i][1]); // case2：找出d中首个更小的元素，可以接在该元素之后！！！
            }
        }
        return d.size(); // 列表扩展过的最大size！！！
    }
	
    public int binarySearch(List<Integer> d, int target) { // 找出d中首个比target更小的元素所在位置！！！
        int low = 0, high = d.size()-1;
        while (low < high) {
            int mid = (high-low)/2 + low;
            if (d.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}