package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ClassroomTest {

    Double[] stu1Scores = {55.00, 65.00, 80.00, 70.00};  // 67.50 avg
    Double[] stu2Scores = {99.67, 72.04, 12.34, 100.00}; // 71.0125
    Double[] stu3Scores = {50.00, 60.00, 70.00, 80.00};  // 65.00 Avg
    Double[] stu4Scores = {30.00, 12.00, 25.00, 18.00};  // 21.26
    Double[] stu5Scores = {90.00, 90.00, 95.00, 95.00};  // 21.26




    Student student1 = new Student("Jimmy", "Churu", stu1Scores);
    Student student2 = new Student("John", "Churu", stu2Scores);
    Student student3 = new Student("Jeremy", "Churu", stu3Scores);
    Student student4 = new Student("John", "Churu", stu4Scores);
    Student student5 = new Student("Jeremy", "Churu", stu5Scores);


    Student[] studentArr = {student1,student2,student3};    // Student Array
    Classroom class1 = new Classroom(studentArr);           // Creating classroom with our student array



    @Test
    public void defaultConstructor(){
        Classroom class1 = new Classroom();

        int expectedSize = 30;
        int actualSize = class1.students.length;

        Assert.assertEquals(expectedSize , actualSize);
    }

    @Test
    public void ConstructorWithMaxNum(){

        int maxStudents = 20;
        Classroom class2 = new Classroom(maxStudents);

        int expectedSize = 20;
        int actualSize = class2.students.length;

        Assert.assertEquals(expectedSize , actualSize);

    }

    @Test
    public void ConstructorWithArray(){
        Double[] stu1Scores = {55.00, 65.00, 80.00, 70.00};  // 67.50 avg
        Double[] stu2Scores = {99.67, 72.04, 12.34, 100.00}; // 71.0125
        Double[] stu3Scores = {50.00, 60.00, 70.00, 80.00};  // 65.00 Avg

        Student student1 = new Student("Jimmy", "Churu", stu1Scores);
        Student student2 = new Student("John", "Churu", stu2Scores);
        Student student3 = new Student("Jeremy", "Churu", stu3Scores);

        Student[] studentArr = {student1,student2,student3};    // Student Array
        Classroom class1 = new Classroom(studentArr);           // Creating classroom with our student array

        Student[] expectedArr = studentArr;
        Student[] actualArr = class1.getStudents();

        Assert.assertEquals(expectedArr , actualArr);
    }

    @Test
    public void getStudentsTest(){

        Student[] expectedArr = studentArr;             //Students & Class defined as instance field in test class
        Student[] actualArr = class1.getStudents();     //Students & Class defined as instance field in test class

        Assert.assertEquals(expectedArr , actualArr);
    }

    @Test
    public void addStudentsTest(){

        Classroom empty = new Classroom(3);
        empty.addStudents(student1);
        empty.addStudents(student2);
        empty.addStudents(student3);

        Student expected1 = student1;
        Student expected2 = student2;
        Student expected3 = student3;

        Student actual1 = empty.students[0];
        Student actual2 = empty.students[1];
        Student actual3 = empty.students[2];

        Assert.assertEquals(expected1 , actual1);
        Assert.assertEquals(expected2 , actual2);
        Assert.assertEquals(expected3 , actual3);
    }

    @Test
    public void removeStudentsTest(){
        //Student student3 = new Student("Jeremy", "Churu", stu3Scores);
        Classroom removeTest = class1;
        removeTest.removeStudent("Jimmy","Churu");
        System.out.println(removeTest.getStudents().toString());

        Student expected  = null;
        Student actual =  removeTest.students[2];

        Assert.assertEquals(expected , actual);
        Assert.assertEquals(student2 , removeTest.students[0]);

    }

    @Test
    public void getAverageClass(){
        Double expected = (67.50 + 71.0125 + 65.00) / 3;
        Double actual = class1.getAverageExamScore();

        Assert.assertEquals(expected , actual);
    }

    @Test
    public void getStudentByScoreTest(){

        Student[] ExpectedSorted = {student2,student1,student3};

        Student[] unSorted = class1.students;
        Classroom sorted = class1;



        for(int x = 0; x <= sorted.students.length; x++){
            System.out.println();
        }
    }
    @Test
    public void getGradeBookTest(){
        Double[] stu1Scores = {30.00, 30.00, 30.00, 30.00};  // 67.50 avg     = D
        Double[] stu2Scores = {99.67, 72.04, 12.34, 100.00}; // 71.0125       = B
        Double[] stu3Scores = {50.00, 60.00, 70.00, 80.00};  // 65.00 Avg     = C
        Double[] stu4Scores = {08.00, 07.00, 05.00, 06.00};  // 06.50 AVG     = F
        Double[] stu5Scores = {90.00, 90.00, 95.00, 95.00};  // 92.50 AVG     = A




        Student student1 = new Student("Jimmy", "Churu", stu1Scores);
        Student student2 = new Student("John", "Churu", stu2Scores);
        Student student3 = new Student("Jeremy", "Churu", stu3Scores);
        Student student4 = new Student("John", "Churu", stu4Scores);
        Student student5 = new Student("Jeremy", "Churu", stu5Scores);


        Student[] studentArr = {student1,student2,student3,student4,student5};    // Student Array
        Classroom class5 = new Classroom(studentArr);

        LinkedHashMap <Character , ArrayList<Student>> Expected;
        Expected = new LinkedHashMap <Character, ArrayList<Student>>();

        //Adding A
        ArrayList<Student> Alist = new ArrayList<Student>();
        Alist.add(student5);
        Expected.put('A',Alist);
        //Adding B
        ArrayList<Student> Blist = new ArrayList<Student>();
        Alist.add(student2);
        Expected.put('B',Blist);
        //Adding C
        ArrayList<Student> Clist = new ArrayList<Student>();
        Alist.add(student3);
        Expected.put('C',Clist);
        //Adding D
        ArrayList<Student> Dlist = new ArrayList<Student>();
        Alist.add(student1);
        Expected.put('D',Dlist);
        //Adding F
        ArrayList<Student> Flist = new ArrayList<Student>();
        Alist.add(student4);
        Expected.put('F',Flist);

        LinkedHashMap<Character,ArrayList<Student>> Actual = class5.getGradeBook();


        Assert.assertEquals(Expected.get('A') , Actual.get('A'));
    }

}
