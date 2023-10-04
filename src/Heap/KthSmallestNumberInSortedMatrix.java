package Heap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthSmallestNumberInSortedMatrix {
    class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int hashCode(){
            return this.x*31 + this.y*31*31;
        }
        @Override
        public boolean equals(Object obj){
            if(this == obj){
                return true;
            }
            if(!(obj instanceof Node)){
                return false;
            }
            Node temp = (Node) obj;
            return temp.x == x && temp.y == this.y;
        }
    }
    // 定义方向数组：

    /* 如何性感的定义四方向
      x,y     	 ->   x + 0, y + 1 → 右
      x,y  –>     	 x + 1, y + 1 → 下
     private static final int [][] DIRS = {{0,1},{1,0},{0,-1},{-1,0}};
    */
    private static final int [][] DIRS = {{0,1},{1,0}};
    public int kthSmallest(int[][] matrix, int k) {
        // assume matrix and k are valid
        PriorityQueue<Node> minHeap = new PriorityQueue<>(k, new Comparator<Node>(){
            @Override
            public int compare(Node point1, Node point2){
                if(matrix[point1.x][point1.y] == matrix[point2.x][point2.y]){
                    return 0;
                }
                return matrix[point1.x][point1.y] < matrix[point2.x][point2.y] ? -1 : 1;
            }
        });
        Set<Node> visited = new HashSet<>();
        Node start = new Node(0,0);
        int i = 1;
        minHeap.offer(start);
        visited.add(start);
        while(!minHeap.isEmpty()){
            Node cur = minHeap.poll();
            if(i == k){
                return matrix[cur.x][cur.y];
            }
            for(int [] dir: DIRS){
                int neiX = cur.x + dir[0];
                int neiY = cur.y + dir[1];
                if(isValid(neiX,neiY,matrix)){
                    Node neiNode = new Node(neiX,neiY);
                    if(!visited.contains(neiNode)){
                        minHeap.offer(neiNode);
                        visited.add(neiNode);
                    }
                }
            }
            i++;
        }
        return -1;
    }
    private boolean isValid(int x, int y, int [][] matrix){
        return x >= 0 && y >= 0 &&  x < matrix.length && y < matrix[0].length;
    }
}
