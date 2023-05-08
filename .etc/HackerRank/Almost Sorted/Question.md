# HackerRank 'Almost Sorted'

<br>

## 문제
Given an array of integers, determine whether the array can be sorted in ascending order using only one of the following operations one time.

1. Swap two elements.
2. Reverse one sub-segment.

Determine whether one, both or neither of the operations will complete the task. Output is as follows.

1. If the array is already sorted, output yes on the first line. You do not need to output anything else.
2. If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then:
- If elements can only be swapped, d[l] and d[r], output swap l r in the second line. l and r are the indices of the elements to be swapped, assuming that the array is indexed from 1 to n.
- If elements can only be reversed, for the segment d[l...r], output reverse l r in the second line. l and r are the indices of the first and last elements of the subarray to be reversed, assuming that the array is indexed from 1 to n. Here d[l...r] represents the subarray that begins at index l and ends at index r, both inclusive.

If an array can be sorted both ways, by using either swap or reverse, choose swap.

3. If the array cannot be sorted either way, output no on the first line.

<br><br>

## 예시
arr = [2, 3, 5, 4]

Either swap the 4 and 5 at indices 3 and 4, or reverse them to sort the array. As mentioned above, swap is preferred over reverse. Choose swap. On the first line, print yes. On the second line, print swap 3 4.

<br><br>

## 기능 설명
Complete the almostSorted function in the editor below.

almostSorted has the following parameter(s):

- int arr[n]: an array of integers

<br><br>

## 입력
The first line contains a single integer n, the size of arr.

The next line contains n space-separated integers arr[i] where 1 ≤ i ≤ n.

<br><br>

## 출력
Print the results as described and return nothing.

## 예시
### 입력
```
STDIN   Function
-----   --------
2       arr[] size n = 2
4 2     arr = [4, 2]
```

### 츨력
```
yes  
swap 1 2
```

