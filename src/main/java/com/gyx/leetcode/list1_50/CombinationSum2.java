package com.gyx.leetcode.list1_50;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum2 {
    private Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>(res);
        }
        Arrays.sort(candidates);
        List<Integer> collect = Arrays.stream(candidates).boxed().collect(Collectors.toList());
        findCombinationSum(target, 0, new Stack<>(),collect);
        return new ArrayList<>(res);
    }

    private void findCombinationSum(int residue, int start, Stack<Integer> pre,List<Integer> candidates) {
        if (residue < 0) {
            return;
        }
        if (residue == 0) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            List<Integer> list = new ArrayList<>(candidates);
            pre.add(list.get(i));
            Integer remove = list.remove(i);
            findCombinationSum(residue - remove, i, pre,list);
            pre.pop();
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> lists = combinationSum2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }
}
