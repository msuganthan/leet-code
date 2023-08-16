package topologicalsort;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule11 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int inDegree[] = new int[numCourses];
        int order[] = new int[numCourses];
        int index = 0;

        for(int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                order[index++] = i;
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int prerequisite = queue.poll();
            for (int[] ints : prerequisites) {
                if (ints[1] == prerequisite) {
                    inDegree[ints[0]]--;
                    if (inDegree[ints[0]] == 0) {
                        order[index++] = ints[0];
                        queue.offer(ints[0]);
                    }
                }
            }
        }
        return (index == numCourses) ? order : new int[0];
    }
}
