package graph;

import java.util.LinkedList;

public class CourseSchedule {

    boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] courseOrder = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
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
            for(int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == course) {
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]] == 0) {
                        stack.push(prerequisites[i][0]);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
