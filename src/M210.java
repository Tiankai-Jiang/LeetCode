import java.util.*;

public class M210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses], res = new int[numCourses];
        int visited = 0;
        Queue<Integer> q = new LinkedList<>();
        List<Integer>[] graph = new List[numCourses];
        for(int i=0; i<numCourses; i++) graph[i] = new ArrayList();
        for(int[] course : prerequisites){
            graph[course[1]].add(course[0]);
            inDegree[course[0]]++;
        }
        for(int i=0; i<numCourses; i++) if(inDegree[i]==0) q.offer(i);
        while(!q.isEmpty()){
            int c = q.poll();
            res[visited++] = c;
            for(int i: graph[c]) if(--inDegree[i]==0) q.offer(i);
        }
        return visited == numCourses ? res : new int[0];
    }
}
