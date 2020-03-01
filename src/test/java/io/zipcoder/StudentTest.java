package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentTest {

    // Constructor Testing

    @Test
    public void constructorTest() {

        //Double[] johnTests = {55.00, 65.00, 80.00, 70.00};
        //Student stu2 = new Student("John", "Bates", johnTests);

        Double[] jimmyTests = {95.00, 90.00, 80.00, 70.00};
        Student stu1 = new Student("Jimmy", "Churu", jimmyTests);

        String expected1stName = "Jimmy";
        String expected2ndName = "Churu";
        List<Double> expectedArr = Arrays.asList(95.00, 90.00, 80.00, 70.00);

        String actual1stName = stu1.getFirstName();
        String actual2ndName = stu1.getLastName();
        ArrayList<Double> actualArr = stu1.examScores;

        Assert.assertEquals(expected1stName,actual1stName);
        Assert.assertEquals(expected2ndName,actual2ndName);
        Assert.assertEquals(expectedArr,actualArr);
    }

    // Set & Get Name tests

    @Test
    public void setANDgetName(){
        String firstName1 = "Mary";
        String lastName1 = "Poppins";
        Double[] fakeScores = {0.00, 0.00, 0.00, 0.00};
        Student nameTest = new Student("bla", "blabla", fakeScores);
        nameTest.setFirstName(firstName1);
        nameTest.setLastName(lastName1);

        String actual1stName = nameTest.getFirstName();
        String actual2ndName = nameTest.getLastName();

        Assert.assertEquals(firstName1,actual1stName);
        Assert.assertEquals(lastName1,actual2ndName);
    }

    // Set - Get - Add -  Exam tests

    @Test
    public void setANDgetExamScores(){
        Double[] fakeScores = {0.00, 0.00};
        Double[] testScores1 = {50.00, 98.34};
        Double adder = 70.00;
        Student testScoreTest = new Student("Jimmy", "Churu", fakeScores);

        testScoreTest.setExamScore(1, testScores1[0]);
        testScoreTest.setExamScore(2, testScores1[1]);
        testScoreTest.addExamScore(adder);

        Double expected0 = testScores1[0];
        Double expected1 = testScores1[1];
        Double expected2 = adder;
        Double actual0 = testScoreTest.getScoreAt(1);
        Double actual1 = testScoreTest.getScoreAt(2);
        Double actual2 = testScoreTest.getScoreAt(3);

        Assert.assertEquals(expected0,actual0);
        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);

        System.out.println("\n" + "**** GET EXAM SCORES STRING ******" + "\n");
        System.out.println(testScoreTest.getExamScores());
    }

    @Test
    public void averageTest(){

        Double[] stu2Tests = {55.00, 65.00, 80.00, 70.00};
        Student stu2 = new Student("John", "Bates", stu2Tests);
        Double stu2ExpectedAVG = 67.50;
        Double stu2ActualAVG = stu2.getAverageExamScore();


        Double[] stu3Tests = {99.67, 72.04, 12.34, 100.00};
        Student stu3 = new Student("John", "Bates", stu3Tests);
        Double stu3ExpectedAVG = 71.0125;
        Double stu3ActualAVG = stu3.getAverageExamScore();


        Assert.assertEquals(stu2ExpectedAVG , stu2ActualAVG);
        Assert.assertEquals(stu3ExpectedAVG , stu3ActualAVG);
    }

    @Test
    public void getNumberOfExamsTakenTest(){
        Double[] numOfExamsTests = {55.00, 65.00, 80.00, 70.00,};
        Student numOfExams = new Student("John", "Bates", numOfExamsTests);

        int expectedNumOfExams = 4;
        int actualNumOfExams = numOfExams.examScores.size();

        Assert.assertEquals( expectedNumOfExams, actualNumOfExams);
    }


    @Test
    public void toStringTest(){

        Double[] toStringTests = {55.00, 65.00, 80.00, 70.00,};
        Double expectedAvg = 67.5;
        Student toStringTest = new Student("John", "Bates", toStringTests);

        System.out.println("\n" + "**** TO STRING OVERIDE METHOD ******" + "\n");
        System.out.println(toStringTest.toString());
    }
}