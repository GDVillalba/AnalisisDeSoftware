package triangulo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner lectura = new Scanner (System.in);
		
		int lado1 = 0;
		int lado2 = 0;
		int lado3 = 0;
		
		
		System.out.println("Ingrese Lado 1: ");
		lado1 = lectura.nextInt();

		System.out.println("Ingrese Lado 2: ");
		lado2 = lectura.nextInt();
		
		System.out.println("Ingrese Lado 3: ");
		lado3 = lectura.nextInt();
		
		Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
		
		if( !triangulo.esTriangulo())
		{
			System.out.println("No es un triangulo");
		}
		else
		{
			System.out.println(triangulo.getTipo());	
		}
		
		lectura.close();

	}

}
