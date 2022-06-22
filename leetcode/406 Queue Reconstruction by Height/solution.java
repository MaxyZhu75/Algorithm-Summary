class Solution {
    public int[][] reconstructQueue(int[][] people) { //「贪心」！！！
        Arrays.sort(people, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) { //「优先级」：身高由高到低，若身高一样则按k由低到高！！！
			    return (o1[0] == o2[0]) ? o1[1]-o2[1] : o2[0]-o1[0];
		    }
        });

        List<int[]> result = new LinkedList<>(); // 利用列表在指定位置添加元素时，后续元素能顺序移动的性质！！！
        for (int[] person : people) { // 以「k」为索引，贪心地添加已排序的人（已区分优先级）！！！
		    result.add(person[1], person); // 先添加的（个子高的）因为看不见后添加的（个子矮的），因此可能会被后移，从而保护后添加的（个子矮的）！！！
        }

        int n = people.length;
        return result.toArray(new int[n][2]);
    }
}