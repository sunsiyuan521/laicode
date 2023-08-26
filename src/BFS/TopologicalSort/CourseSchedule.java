package BFS.TopologicalSort;
import java.util.*;
/*
* 417. Course Schedule(M)
https://app.laicode.io/app/problem/417?plan=25

* There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input

    /          \
4 - 3 - 2 - 0 - 1
   \        /
5,[[1,0],[0,2],[2,3],[1,3],[0,3],[3,4]]
indegree[2,2,1,1,0]
q[4]

*
* */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        //int res = numCourses;
        // 找入度为0，表示可以开始学习的课
        for(int[] pair : prerequisites){
            // [1,0] => 0->1
            indegree[pair[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        // 入度为0的加入，然后bfs
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                // 当前这个课已经可以学了
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int[] pair : prerequisites){
                // 如果这门课已经可以学习了，就不加入queue
                if(indegree[pair[0]] == 0){
                    continue;
                }
                if(pair[1] == curr){
                    indegree[pair[0]]--;
                }
                // 这门课原来不能学习，现在可以学习了
                if(indegree[pair[0]] == 0){
                    queue.offer(pair[0]);
                }
            }
        }
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}
