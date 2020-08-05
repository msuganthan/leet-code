package graph;

import java.util.LinkedList;

public class CourseSchedule {

    public static void main(String[] args) {
        //To take course 1 you should have finished course 0
        canFinish(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }

    static boolean canFinish(int numCourses, int[][] preRequisites) {
        int[] inDegree = new int[numCourses];
        int[] courseOrder = new int[numCourses];

        //Increment the inDegree for every dependent course
        for(int i = 0; i < preRequisites.length; i++)
            inDegree[preRequisites[i][0]]++;


        int count = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();

        //Add every single vertex that has no prerequisites,
        //In our example 0 has no dependency.
        for(int i = 0 ; i < inDegree.length; i++ )
            if(inDegree[i] == 0)
                stack.push(i);

        while(!stack.isEmpty()) {
            int course = stack.pop();
            courseOrder[count++] = course;
            for(int i = 0; i < preRequisites.length; i++) {
                if(preRequisites[i][1] == course) {
                    inDegree[preRequisites[i][0]]--;
                    if(inDegree[preRequisites[i][0]] == 0)
                        stack.push(preRequisites[i][0]);
                }
            }

        }

        return count == numCourses;
    }
}
