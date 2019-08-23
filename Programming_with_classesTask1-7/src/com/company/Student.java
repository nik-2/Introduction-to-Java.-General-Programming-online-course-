//Task3
package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Student
{
   private String surname_initials;
   private String group;
   private int [] grades;

    private Student() { }

    private Student(String surname_initials, String group, int[] grades)
    {
        setSurname_initials(surname_initials);
        setGroup(group);
        setGrades(grades);
    }

    private String getSurname_initials() {
        return surname_initials;
    }

    private void setSurname_initials(String surname_initials) {
        this.surname_initials = surname_initials;
    }

    private String getGroup() {
        return group;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    private int[] getGrades() {
        return grades;
    }

    private void setGrades(int[] grades) {
        this.grades = grades;
    }

    private void show()
    {
        System.out.printf(" |Surname: %1$-20s|Group: %2$-10s|Grades: %3$-20s\n", getSurname_initials(), getGroup(), Arrays.toString(getGrades()));
    }

    private void findExcellentStudents(Student[] students)
    {
        int kol;
        for (int i = 0; i < students.length; i++) {
            kol = 0;
            for (int j = 0; j < students[i].getGrades().length; j++) {
                if (students[i].getGrades()[j] != 9 && students[i].getGrades()[j] != 10)
                {
                    kol++;
                    break;
                }
            }
            if( kol == 0 ) {
                students[i].showExcellentStudents();
            }
        }
    }

    private void showExcellentStudents()
    {
        System.out.printf(" |Surname: %1$-20s|Group: %2$-10s\n", getSurname_initials(), getGroup());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Student[] students = new Student[10];
        int [] array;
        for (int i = 0; i < students.length; i++) {
            System.out.print( " Input a surname and initials: ");
            String surname = in.nextLine();
            System.out.print( " Input a group: ");
            String group = in.nextLine();
            System.out.println( " Input 5 grades: ");
            array = new int[5];
            for (int j = 0; j < array.length; j++) {
                System.out.print( " Grade " + (j + 1) + " = ");
                array[j] = Integer.parseInt(in.nextLine());
            }
            System.out.println( " Grades: " + Arrays.toString(array));
            students[i] = new Student(surname, group, array);
        }
        System.out.println( "\t\t\t\t\t\t STUDENT INFO");
        for (int i = 0; i < students.length; i++) {
            students[i].show();
        }
        System.out.println( "\t\t\t EXCELLENT STUDENTS");
        students[0].findExcellentStudents(students);
    }
}

