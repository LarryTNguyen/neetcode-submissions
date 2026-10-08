/**
Initial thoughts: would probably involve some backtracking with dfs and an adjacency list
i think the same concept of finding a cycle will play a role here again as we see a "higher"
class 0 needed to be taken for a lower class 2 as seen in example 2 where 2<-- 0 <--1 <-- 2

there seems to always be numCourses - 1
in terms of base cases, we could do something like if currCourse has no pre reqs, return the class?

Main fn:
    build adjList
    would we want a global answer? like int[] answer = new int[numCourses]
    and a global index so dfs could increment?
    maybe dfs could return an index to put in?


dfs helper fn:
    params: course#, adjList, bool[] visited, bool[]currPath
    if
*/

class Solution {
    List<Integer> order = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0; i<numCourses; i++){
            adjList.add(i, new ArrayList<>());
        }
        for(int[] preReq: prerequisites){
            adjList.get(preReq[0]).add(preReq[1]);
        }
        boolean [] visited = new boolean[numCourses];
        boolean [] current = new boolean[numCourses];

        for(int course = 0; course < numCourses; course++){
            if (!visited[course]) {
                if (!dfs(course, adjList, visited, current)) {
                    return new int[0];
                }
            }
        }
        int[] answer = new int[numCourses];
        for(int k =0; k<answer.length; k++){
            answer[k] = order.get(k);
        }
        return answer;
    }

    public boolean dfs(int course, List<List<Integer>> adjList, boolean[] visited, boolean[] current){
        if(current[course]) return false;
        if(visited[course]) return true;

        current[course] = true;
        for(int pReq : adjList.get(course)){
            if(!dfs(pReq, adjList, visited, current)) return false;
        }
        current[course] =false;
        visited[course]= true;
        order.add(course);
        return true;
    }
}
