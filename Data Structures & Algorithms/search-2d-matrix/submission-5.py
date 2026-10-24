class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top = 0
        bottom = len(matrix) - 1
        selected = []
        while top <= bottom:
            mid = top + (bottom-top) // 2
            if matrix[mid][0] <= target and matrix[mid][len(matrix[mid])-1] >= target:
                selected = matrix[mid]
                break
            elif matrix[mid][0] > target:
                bottom = mid - 1
            else:
                top = mid + 1
        if not selected:
            return False
        left = 0
        right = len(selected) - 1
        while left <= right:
            mid = left + (right - left)//2
            if selected[mid] == target:
                return True
            elif selected[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return False
