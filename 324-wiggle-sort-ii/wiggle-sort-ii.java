class Solution {
public void wiggleSort(int[] nums) {
  var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
  
  for (var num: nums)
    pq.add(num);
  
  for (var i=1; i < nums.length; i += 2)
    nums[i] = pq.poll();
  
  for (var i=0; i < nums.length; i += 2)
    nums[i] = pq.poll();
}
}