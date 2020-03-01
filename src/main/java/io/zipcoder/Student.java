package io.zipcoder;

import java.util.ArrayList;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstNameIn, String lastNameIn, Double[] testScoresIn){
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
        for(Double elemnt: testScoresIn){
            this.examScores.add(elemnt);
        }

    }

    public void setFirstName(String newName){
        this.firstName = newName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String newName){
        this.lastName = newName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public Double getScoreAt(int pos){
        return this.examScores.get(pos -1);
    }

    public String getExamScores(){
        String result = "Exam Scores :";
        int index = 1;
        for(Double element: examScores){
            String adder = "\n         " + "Exam " + index + " -> " + element;
            result += adder;
            index++;
        }
        return result;
    }

    public void addExamScore(Double newScore){
        this.examScores.add(newScore);
    }

    public void setExamScore(int examNumber, double newScore){
        this.examScores.set(examNumber -1, newScore);
    }

    public Double getAverageExamScore(){
        double sum = 0;
        for(Double element: examScores){
            sum += element;
        }
        Double average = sum / examScores.size();
        return average;
    }

    public int getNumberOfExamsTaken(){
        return this.examScores.size();
    }


    @Override
    public String toString(){
        String studentInfo = "Student Name: " + this.firstName + " " + this.lastName;
        String avgScore = "\n" + "Average Score: " + this.getAverageExamScore();
        String scoreList = "\n" + this.getExamScores();

        String newOverRide = studentInfo + avgScore + scoreList;

        return newOverRide;
    }
}
