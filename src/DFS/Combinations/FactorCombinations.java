package DFS.Combinations;
import java.util.*;
/*
404. Factor Combinations
https://app.laicode.io/app/problem/404?plan=3
Given an integer number, return all possible combinations of the factors that can multiply to the target number.
Example
Give A = 24
since 24 = 2 x 2 x 2 x 3
              = 2 x 2 x 6
              = 2 x 3 x 4
              = 2 x 12
              = 3 x 8
              = 4 x 6
your solution should return
{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

Step 1:求出所有人家让你求的数 12 => [6,4,3,2]
for(int i = target / 2; i > 1; i--) {
	if(target % i == 0) {
	factors.add(i);
}
}
How many levels in the recursion tree? What does it store on each level?
# factors,每层表示当前的factor能加多少个
How many different states should we try to put on each level?
（每层有多少个状态/case需要try?）
	当前的remain最多能除几个factor?
TC:branch ^ level
branch:2*2*2… = n -> 2^k = n -> k = logn
level: # of factor
TC:O(logn ^# of factors)
SC:O(# of factors)

*
* */
public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(target <= 1) {
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> factors = getFactors(target);
        helper(target, factors, 0, cur, result);
        return result;
    }


    private void helper(int target, List<Integer> factors, int index, List<Integer> cur, List<List<Integer>> result) {
        //base case
        if(index == factors.size()){ //所有能考虑的factor都考虑完了
            if(target == 1) { //能够整除
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        helper(target, factors, index + 1, cur, result); //pick 0,不拿了
        int curFactor = factors.get(index);//当前拿的index是谁
        int size = cur.size();
        while (target % curFactor == 0){ //剩余元素R能够被当前的factor整除的情况下
            cur.add(curFactor);
            target /= curFactor;
            helper(target, factors, index + 1, cur, result);
        }
        cur.subList(size, cur.size()).clear();//加了多少当前层的factor清空
    }


    private List<Integer> getFactors(int target) {
        List<Integer> factors = new ArrayList<>();
        for(int i = target / 2; i > 1; i--) {
            if(target % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
}
