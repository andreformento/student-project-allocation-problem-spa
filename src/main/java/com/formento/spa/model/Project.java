package com.formento.spa.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rares on 27.02.2016.
 */
public class Project {
    String projectName;
    int projectCapacity;
    int noOfStudentsSubscribed;
    Lecturer projectLecturer;
    List<Student> subscribedStudents;
    public Project(String projectName, int projectCapacity) {
        this.projectName = projectName;
        this.projectCapacity = projectCapacity;
        this.subscribedStudents = new ArrayList<Student>();
        this.noOfStudentsSubscribed = 0;
    }

    public Lecturer getProjectLecturer() {
        return projectLecturer;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setLecturer(Lecturer lecturer) {
        this.projectLecturer = lecturer;
    }

    public void subscribeStudent(Student student) {
        this.subscribedStudents.add(student);
        this.noOfStudentsSubscribed++;
    }

    public void unSubscribeStudent(Student s) {
        for (Iterator<Student> iterator = subscribedStudents.iterator(); iterator.hasNext(); ) {
            Student currentStudent = iterator.next();
            if (s.equals(currentStudent)) {
                iterator.remove();
            }
        }
        noOfStudentsSubscribed--;
    }

    public boolean isFull() {
        return (projectCapacity - noOfStudentsSubscribed) == 0;
    }

    public boolean isOverSubscribed() {
        return (projectCapacity - noOfStudentsSubscribed) < 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Project)) {
            return false;
        }
        Project project = (Project) obj;
        return (this.projectName.equals(project.projectName));
    }
}
