package Controller;

import Model.*;


/**
 * Created by rares on 01.03.2016.
 */
public class StableMatchingSolver extends Solver {
    public StableMatchingSolver(Problem problem) {
        super(problem);
    }

    /**
     * Stable Matching Algorithm.     *
     */
    public void execute() {
        while (problem.thereIsAFreeStudentWithNoEmptyList()) {
            Student si = problem.getFreeStudentWithNoEmptyList();
            Project pj = si.getFirstProject();
            Lecturer lk = problem.getProjectLecturer(pj);
            si.setProjectAssigned(pj);
            si.setProjectLecturer(lk);
            pj.subscribeStudent(si);
            lk.subscribeStudent(si);
            if (pj.isOverSubscribed()) {
                Student sr = lk.getWorstStudent(pj);
                sr.setProjectAssigned(null);
                sr.setProjectLecturer(null);
                pj.unSubscribeStudent(sr);
                lk.unSubscribeStudent(sr);
            } else if (lk.isOverSubscribed()) {
                Student sr = lk.getWorstStudent();
                Project pt = sr.getProjectAssigned();
                sr.setProjectAssigned(null);
                sr.setProjectLecturer(null);
                pt.unSubscribeStudent(sr);
                lk.unSubscribeStudent(sr);
            }
            if (pj.isFull()) {
                Student sr = lk.getWorstStudent(pj);
                lk.deleteSuccessors(sr, pj);
            }
            if (lk.isFull()) {
                Student sr = lk.getWorstStudent();
                lk.deleteUnwantedStudents(sr);
            }
        }
        problem.printSolution("Stable Matching");
        problem.printStudentSolutionAnalysis();
        problem.printLecturerSolutionAnalysis();
        problem.printMatchingSolutionAnalysis();
    }
}

