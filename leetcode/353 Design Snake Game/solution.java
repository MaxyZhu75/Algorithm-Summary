public class SnakeGame {
    Set<Integer> hashRecord = new HashSet<>(); // ���ڼ�¼��ǰ����ռ�����������
    Deque<Integer> body = new LinkedList<>();; // ���ڸ���β��������
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
        int headRow = body.peekFirst() / width; // Ҫ�㣺����(i, j)��Ψһ������ʾ�ķ���������
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
        int head = headRow * width + headCol; // �õ��µ�ͷ������Ψһ������ʾ������
        hashRecord.remove(body.peekLast()); // ��hashRecordʵʱ����ȥ��β������body���ž����Ƿ�ȥ��������
        if (headRow < 0 || headRow == height || headCol < 0 || headCol == width || hashRecord.contains(head)) {
			return -1;
        }
        
		hashRecord.add(head); 
        body.addFirst(head);
        
        if (foodIndex < food.length && headRow == food[foodIndex][0] && headCol == food[foodIndex][1]) { // �Ե�ʳ��ʱ��β���ӻ���������
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