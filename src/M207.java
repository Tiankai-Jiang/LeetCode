import java.util.*;
public class M207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for(int i=0; i<numCourses; i++) graph[i] = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int[] course: prerequisites) {
            graph[course[1]].add(course[0]);
            indegree[course[0]]++;
        }
        int visited = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) if(indegree[i]==0) q.offer(i);
        while (!q.isEmpty()){
            int u = q.poll();
            visited++;
            for(int v: graph[u]) if(--indegree[v] == 0) q.offer(v);
        }
        return visited == numCourses;
    }
}
