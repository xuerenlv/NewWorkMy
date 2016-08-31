package com.test;

public class compareto_test {

	public static void main(String[] args) {
		Student s1 = new Student(90, 90);
		Student s2 = new Student(95, 30);

		int a = 1;
		if (a == 1) {
			System.out.println("-1");
		}

		System.out.println(s1.compareTo(s2));
	}

}

class Student implements Comparable<Student> {
	int no, score;

	public Student(int no, int score) {
		super();
		this.no = no;
		this.score = score;
	}

	@Override
	public int compareTo(Student o) {
		return score - o.score;
	}

}