package ru.stqa.java.sandbox;

public class MyFirstProgram {

	public static void main (String[] args){

		System.out.println("Hello, world");

		Square s = new Square(5);

		System.out.println("Площадь квадрата со стороной " + s.l +  " = " + area(s));

		Rectangle req = new Rectangle(4, 9);

		System.out.println("Площадь прямоугольника со сторонами " + req.a + " и " + req.b + " = " + area(req));

	}



	public static double area(Square s) {
		return s.l*s.l;
	}

	public static double area(Rectangle req) {
		return req.a * req.b;
	}
}


