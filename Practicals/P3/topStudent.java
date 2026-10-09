package Practicals.P3;

import java.util.ArrayList;

public class topStudent implements Comparable<topStudent> {
    private int totalMark;
    private String name;
    private ArrayList<String> subjects;
    private ArrayList<Integer> marks;

    public String getName() {
        return name;
    }

    public topStudent(String name) {
        this.name=name;
        subjects = new ArrayList<String>();
        marks = new ArrayList<Integer>();

    }

    public void addMarks(String subject, int mark) {
        subjects.add(subject);
        marks.add(mark);
        totalMark += mark;
    }

    public int compareTo(topStudent other) {
        if(this.totalMark > other.totalMark) return 1;
        else if(this.totalMark == other.totalMark) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        // Write a Java program that compares two student's marks and return the object with the higher mark.
        topStudent spongebob = new topStudent("SpongeBob");
        spongebob.addMarks("English", 63);
        spongebob.addMarks("Math", 98);
        spongebob.addMarks("History", 79);
        topStudent patrick = new topStudent("Patrick");
        patrick.addMarks("English", 89);
        patrick.addMarks("Math", 82);
        patrick.addMarks("History", 91);

        if (spongebob.compareTo(patrick) == 0) {
            System.out.println(spongebob.getName() + " gets a higher total mark.");
        }
        else if (spongebob.compareTo(patrick) < 0) {
            System.out.println(patrick.getName() + " gets a higher total mark.");
        }
        else {
            System.out.println("Both students get the same total mark.");
        }
    }
}
