class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length-1;
        int colLength = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        boolean withinRange = false;
        while(top<=bottom){
            int mid = top + (bottom-top)/2;
            if(matrix[mid][0] <= target && matrix[mid][colLength] >= target){
                withinRange = true;
                top = mid;
                break;
            }
            else{
                if(matrix[mid][0] < target){
                    top = mid+1;
                }
                else{
                    bottom = mid-1;
                }
            }
        }
        if(!withinRange){
            // System.out.println("Not within range");
            return false;
        }
        System.out.println(top); 
        int left = 0;
        int right = matrix[top].length -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(matrix[top][mid] == target) return true;
            else if(matrix[top][mid] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return false;
    }
}
