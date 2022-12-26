public class SnakeGame {
    Set<Integer> hashRecord = new HashSet<>(); // 用于记录当前身体占用情况！！！
    Deque<Integer> body = new LinkedList<>();; // 用于更新尾部！！！
    int score;
    int[][] food;
    int foodIndex;
    int width;
    int height;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.hashRecord.add(0);
        this.body.addLast(0);
    }
    
    public int move(String direction) {
        int headRow = body.peekFirst() / width; // 要点：坐标(i, j)由唯一整数表示的方法！！！
        int headCol = body.peekFirst() % width;
        if (direction.equals("U")) {
            headRow--;
        } else if (direction.equals("D")) {
			headRow++;
		} else if (direction.equals("L")) {
			headCol--;
		} else {
			headCol++;
		}
        int head = headRow * width + headCol; // 得到新的头部并由唯一整数表示！！！
        hashRecord.remove(body.peekLast()); // 仅hashRecord实时更新去掉尾部，而body最后才决定是否去掉！！！
        if (headRow < 0 || headRow == height || headCol < 0 || headCol == width || hashRecord.contains(head)) {
			return -1;
        }
        
		hashRecord.add(head); 
        body.addFirst(head);
        
        if (foodIndex < food.length && headRow == food[foodIndex][0] && headCol == food[foodIndex][1]) { // 吃到食物时把尾部加回来！！！
            hashRecord.add(body.peekLast());
            foodIndex++;
            score++;
        } else {
    		body.pollLast();
        }

		return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */