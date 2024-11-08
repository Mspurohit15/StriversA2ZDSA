Missing Number :  Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.


Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 

Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

1. Brute Force Approach:
Approach:

Check for every number from 0 to n whether it is present in the array or not.
Steps:

Iterate over each number in the range [0, n].
For each number, check if it exists in the nums array using a linear search.
The first number not found is the missing one.

public int missingNumber(int[] nums) {
    int n = nums.length;
    for (int i = 0; i <= n; i++) {   // Check for every number from 0 to n
        boolean found = false;
        for (int num : nums) {       // Linear search for each number in nums
            if (num == i) {
                found = true;
                break;
            }
        }
        if (!found) return i;        // Return the first missing number
    }
    return -1; // Should never reach here
}


Time Complexity:

Outer loop: O(n+1) (because we are checking all numbers from 0 to n)
Inner loop: O(n) (linear search)
Total: O(n^2) in the worst case (if the last number is missing).
Space Complexity:

O(1) (no extra space used).

2. Better Approach (Sorting):

Approach:

Sort the array first and then check for the missing number.
Steps:

1. Sort the array.
2. Iterate over the sorted array and compare each element with its index. If the element at index i
   is not equal to i, that is the missing number.

import java.util.Arrays;

public int missingNumber(int[] nums) {
    Arrays.sort(nums);                // Sort the array first
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i) {           // The first index where nums[i] != i
            return i;
        }
    }
    return nums.length;               // If no number is missing in the middle, return n
}

Time Complexity:

Sorting: O(n log n)
Linear scan: O(n)
Total: O(n log n).
Space Complexity:

O(1) (if sorting is in-place) or O(n) if additional space is required for sorting.



3. Optimized Approach 1 (Sum Formula):

Steps:

Calculate the expected sum of numbers from 0 to n using the formula sum = (n * (n + 1)) / 2.
Calculate the sum of all elements in the nums array.
The missing number will be the difference between the expected sum and the actual sum.


public int missingNumber(int[] nums) {
    int n = nums.length;
    int expectedSum = (n * (n + 1)) / 2;  // Sum of numbers from 0 to n
    int actualSum = 0;
    for (int num : nums) {
        actualSum += num;                 // Sum of elements in the array
    }
    return expectedSum - actualSum;        // The missing number
}

Time Complexity:

Sum calculation: O(n)
Total: O(n).
Space Complexity:

O(1) (constant extra space).



4. Optimized Approach 2 (XOR Method):

Approach: Leverage the properties of XOR (exclusive or) operation. XOR-ing a number with itself results in 0, 
and XOR is commutative. If you XOR all numbers from 0 to n with all the elements in nums, all
elements that appear in both sets will cancel out, leaving only the missing number.
 
Steps:

XOR all numbers from 0 to n.
XOR all elements of the nums array.
XOR the results of step 1 and step 2. The result will be the missing number.

public int missingNumber(int[] nums) {
    int xor = 0;
    int n = nums.length;
    for (int i = 0; i <= n; i++) {
        xor ^= i;                      // XOR numbers from 0 to n
    }
    for (int num : nums) {
        xor ^= num;                    // XOR elements in the array
    }
    return xor;                        // The result is the missing number
}



 

Time Complexity:

XOR operation: O(n) for both loops.
Total: O(n).
Space Complexity:

O(1) (constant extra space).















  
  
