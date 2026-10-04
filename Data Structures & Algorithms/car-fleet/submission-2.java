class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        Stack<Double> fleetCount = new Stack<>();
        for(int i = 0; i<position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        for(int k = 0; k<position.length; k++){
            double time = (double) (target-cars[k][0]) / cars[k][1];
            if(fleetCount.isEmpty() || time > fleetCount.peek()) fleetCount.push(time);
        }
        return fleetCount.size();
    }
}
