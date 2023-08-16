package topologicalsort;

import java.util.LinkedList;

public class CourseSchedule {

    boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] courseOrder = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                stack.push(i);
            }
        }

        int count = 0;
        while(!stack.isEmpty()) {
            int course = stack.pop();
            courseOrder[count++] = course;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == course) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        stack.push(prerequisite[0]);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
