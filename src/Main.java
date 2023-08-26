import BFS.TopologicalSort.CourseSchedule;
import DFS.Combinations.FactorCombinations;
import Kway.MergeKSortedLists;
import PublicClass.ListNode;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.canFinish(5,new int[][]{{1,0},{0,2},{2,3},{1,3},{0,3},{3,4}}));
    }
}