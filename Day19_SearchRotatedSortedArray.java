/* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

   (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

   You are given a target value to search. If found in the array return its index, otherwise return -1.
   You may assume no duplicate exists in the array.
   Your algorithm's runtime complexity must be in the order of O(log n).

   Example 1:

   Input: nums = [4,5,6,7,0,1,2], target = 0
   Output: 4

   Example 2:

   Input: nums = [4,5,6,7,0,1,2], target = 3
   Output: -1
*/

package LeetCode;

public class Day19_SearchRotatedSortedArray {

	public static int search(int[] nums, int target) {
		
		int low = 0;
		int high = nums.length-1;
		
		if (nums.length == 0) {
			return -1;
		}
		
		while (low + 1 < high) {
		
			int middle = low + (high - low) / 2;
			
			if (nums[middle] == target) {
				return middle;
			}
			
			if (nums[low] < nums[middle]) {
				if (nums[low] <= target && nums[middle] >= target) {
					high = middle;
				} else {
					low = middle;
				}
			} else {
				if (nums[middle] <= target && nums[high] >= target) {
					low = middle;
				} else {
					high = middle;
				}
			}
		}
		
		if (nums[low] == target) {
			return low;
		}
		
		if (nums[high] == target) {
			return high;
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;

		System.out.println(search(nums, target));
		
	}

}