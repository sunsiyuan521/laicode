import BinarySearch.SearchInBitonicArray;
import BinarySearch.SearchInShiftedSortedArrayI;
import PublicClass.TreeNode;
import Sort.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {8,2,98,null,18,1,100};
        TreeNode t = new TreeNode();
        TreeNode root = t.constructTree(array);
        System.out.println(t.destructTree(root));
    }
}