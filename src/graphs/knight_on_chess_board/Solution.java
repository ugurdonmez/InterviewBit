package graphs.knight_on_chess_board;

import java.util.*;

/**
 * Created by ugurdonmez on 12/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(knight(2,20,1,18,1,5));

    }

    public static int knight(int N, int M, int x1, int y1, int x2, int y2) {

        Map<Integer, BoardArea> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map.put(i * M + j, new BoardArea(i,j));
            }
        }

        int key1 = x1 * M + y1;
        int key2 = x2 * M + y2;

        return getKnightMinMove(map.get(x1 * M + y1), map.get(x2 * M + y2), N, M, map);
    }

    public static int getKnightMinMove(BoardArea pos1, BoardArea pos2, int n, int m, Map<Integer, BoardArea> map) {

        PriorityQueue<QueueWrapper> queue = new PriorityQueue<>();
        Set<BoardArea> visited = new HashSet<>();

        queue.add(new QueueWrapper(pos1, 0));

        while (!queue.isEmpty()) {

            QueueWrapper queueWrapper = queue.poll();
            BoardArea boardArea = queueWrapper.boardArea;

            if (boardArea.equals(pos2)) {
                return queueWrapper.length;
            }

            if (!visited.contains(boardArea)) {
                // add connections
                if (boardArea.x + 2 <= n) {
                    if (boardArea.y - 1 >= 1) {
                        queue.add(new QueueWrapper(map.get((boardArea.x + 2) * m + boardArea.y - 1), queueWrapper.length+1));
                    }

                    if (boardArea.y + 1 <= m) {
                        queue.add(new QueueWrapper(map.get((boardArea.x + 2) * m + boardArea.y + 1), queueWrapper.length+1));
                    }
                }

                if (boardArea.x + 1 <= n) {
                    if (boardArea.y - 2 >= 1) {
                        queue.add(new QueueWrapper(map.get((boardArea.x + 1) * m + boardArea.y - 2), queueWrapper.length+1));
                    }

                    if (boardArea.y + 2 <= m) {
                        queue.add(new QueueWrapper(map.get((boardArea.x + 1) * m + boardArea.y + 2), queueWrapper.length+1));
                    }
                }

                if (boardArea.x - 2 >= 1) {
                    if (boardArea.y - 1 >= 1) {
                        queue.add(new QueueWrapper(map.get((boardArea.x - 2) * m + boardArea.y - 1), queueWrapper.length+1));
                    }

                    if (boardArea.y + 1 <= m) {
                        queue.add(new QueueWrapper(map.get((boardArea.x - 2) * m + boardArea.y + 1), queueWrapper.length+1));
                    }
                }

                if (boardArea.x - 1 >= 1) {
                    if (boardArea.y - 2 >= 1) {
                        queue.add(new QueueWrapper(map.get((boardArea.x - 1) * m + boardArea.y - 2), queueWrapper.length+1));
                    }

                    if (boardArea.y + 2 <= m) {
                        queue.add(new QueueWrapper(map.get((boardArea.x - 1) * m + boardArea.y + 2), queueWrapper.length+1));
                    }
                }

                visited.add(boardArea);
            }
        }

        return -1;
    }
}

class BoardArea {

    final int x;
    final int y;

    public BoardArea(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardArea boardArea = (BoardArea) o;

        if (x != boardArea.x) return false;
        return y == boardArea.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}


class QueueWrapper implements Comparable<QueueWrapper>{

    final BoardArea boardArea;
    final int length;

    public QueueWrapper(BoardArea boardArea, int length) {
        this.boardArea = boardArea;
        this.length = length;
    }

    @Override
    public int compareTo(QueueWrapper o) {
        return Integer.compare(this.length, o.length);
    }
}