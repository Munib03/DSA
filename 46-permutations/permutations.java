class Solution {
public List<List<Integer>> permute(int[] nums) {
  rec(0, nums, new ArrayList<>(), new HashSet<>());
  
  return ansList;
}

private final List<List<Integer>> ansList = new ArrayList<>();
private void rec(int index, int[] nums, List<Integer> list, Set<Integer> set) {
  if (list.size() >= nums.length) {
    ansList.add(new ArrayList<>(list));
    return;
  }
  
  for (var i=0; i < nums.length; i++) {
    if (!set.contains(i)) {
      set.add(i);
      list.add(nums[i]);

      rec(i, nums, list, set);
      
      list.removeLast();
      set.remove(i);
    }
  }
}
}