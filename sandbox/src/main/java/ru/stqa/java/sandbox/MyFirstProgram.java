package ru.stqa.java.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {

		System.out.println("Hello, world");

		Square s = new Square(5);

		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle req = new Rectangle(4, 9);

		System.out.println("Площадь прямоугольника со сторонами " + req.a + " и " + req.b + " = " + req.area());

	}
}

