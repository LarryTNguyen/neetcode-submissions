/**
Initial thoughts: I noticed that it is structured like 0 --> 1 so it is kinda like a graph.
could you have multiple prereqs for a class? 0 --> 1, 0 --> 2. This is the case where 0 needs two classes?
im thinking of a helper function that uses recursion to go through a class and add up its prereqs and any child prereqs
Something to take into account: looping prereq's like in example 2 [0,1] [1,0]. They loop forever so have to remember that

Helper fn returns boolean

thought process:
    main function calls on helper

    helper(course, List<List<Integer>> current prereq's needed, boolean[]visited, boolean current path)
helper body:
    if course in currPrereq return false 
    if currpath == null/is empty, return true 
    currPath[course] = true;   
    for each prereq in currentPrereq
        if(!dfs(prereq,  currentPrereq needed, visited, currPath)) return false;
    currPath[course] = false
    visited[course] = true
    return true
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] course:prerequisites){
            adjList.get(course[0]).add(course[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] current = new boolean[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (!visited[course]) {
                if (!dfs(course, adjList, visited, current)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int course, List<List<Integer>> adjList, boolean[] visited, boolean[]current){
        if(current[course]) return false;
        if(visited[course]) return true;

        current[course] = true;
        for(int prereq : adjList.get(course)){
            if(dfs(prereq, adjList, visited, current) == false) return false;
        }
        current[course] = false;
        visited[course] = true;

        return true;
    }
}
