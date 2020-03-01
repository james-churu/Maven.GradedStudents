package io.zipcoder;

import java.util.*;

public class Classroom {

    Student[] students;

    public Classroom(int maxStudents) {
        this.students = new Student[maxStudents];
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Classroom(Student[] arrayIn) {
        this.students = arrayIn;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public Double getAverageExamScore() {
        Double overallSUM = 0.00;

        for (Student element : students) {
            Double studentsAVG = element.getAverageExamScore();
            overallSUM += studentsAVG;
        }
        Double overallAVG = overallSUM / students.length;
        return overallAVG;
    }

    public void addStudents(Student newStudent) {

        for (int x = 0; x <= students.length - 1; x++) {
            if (this.students[x] == null) {
                students[x] = newStudent;
                break;
            }
        }

    }

    public void removeStudent(String firsName, String lastName) {

        int pos = 0;
        for (int x = 0; x <= students.length - 1; x++) {
            if (students[x].firstName.equals(firsName) && students[x].lastName.equals(lastName)) {
                students[x] = null;
                pos = x;
                break;
            }
        }

        for (int z = 1; z <= students.length - 1; z++) {
            if (students[z - 1] == null) {
                students[z - 1] = students[z];
                students[z] = null;
            }
        }
    }

    public Student[] getStudentByScore() {

        //sorting students by grade then by name
        Comparator<Student> compareStudent = Comparator.comparing(Student::getAverageExamScore).reversed().thenComparing(Student::getFirstName);

        Student[] sortedStudent = getStudents();
        Arrays.sort(sortedStudent, compareStudent);

        return sortedStudent;
    }

    public LinkedHashMap getGradeBook() {

        LinkedHashMap <Character , ArrayList<Student>> gradeBook = new LinkedHashMap <Character, ArrayList<Student>>();


        for(int x = 0; x <= students.length -1; x++){

            if(students[x].getAverageExamScore() / students.length >= 90){

                if(gradeBook.containsKey('A')){
                    gradeBook.get('A').add(students[x]);
                }else{
                    ArrayList<Student> Alist = new ArrayList<Student>();
                    Alist.add(students[x]);
                    gradeBook.put('A',Alist);
                }

            }else if(students[x].getAverageExamScore() >= 71 && students[x].getAverageExamScore() <= 89){

                if(gradeBook.containsKey('B')){
                    gradeBook.get('B').add(students[x]);
                }else{
                    ArrayList<Student> Blist = new ArrayList<Student>();
                    Blist.add(students[x]);
                    gradeBook.put('B',Blist);
                }

            }else if(students[x].getAverageExamScore() >= 50 && students[x].getAverageExamScore() <= 70){

                if(gradeBook.containsKey('C')){
                    gradeBook.get('C').add(students[x]);
                }else{
                    ArrayList<Student> Clist = new ArrayList<Student>();
                    Clist.add(students[x]);
                    gradeBook.put('C',Clist);
                }

            }else if(students[x].getAverageExamScore() >= 11 && students[x].getAverageExamScore() <= 49){

                if(gradeBook.containsKey('D')){
                    gradeBook.get('D').add(students[x]);
                }else{
                    ArrayList<Student> Dlist = new ArrayList<Student>();
                    Dlist.add(students[x]);
                    gradeBook.put('D',Dlist);
                }

            }else if(students[x].getAverageExamScore() >= 0 && students[x].getAverageExamScore() <= 10){

                if(gradeBook.containsKey('F')){
                    gradeBook.get('F').add(students[x]);
                }else{
                    ArrayList<Student> Flist = new ArrayList<Student>();
                    Flist.add(students[x]);
                    gradeBook.put('F',Flist);
                }

            }
        }
        return gradeBook;
    }
}


