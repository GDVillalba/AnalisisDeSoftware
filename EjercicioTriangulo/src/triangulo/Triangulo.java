package triangulo;

public class Triangulo {
	
	private int lado1;
	private int lado2;
	private int lado3;
	
	public Triangulo(){}
	
	public Triangulo( int lado1, int lado2, int lado3) 
	{
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}
	
	public boolean esTriangulo() 
	{
		if( this.lado1 - this.lado2 - this.lado3 < 0 &&
			this.lado2 - this.lado1 - this.lado3 < 0 &&
			this.lado3 - this.lado1 - this.lado2 < 0 )
		{
			return true;
		}
		return false;
	}

	public String getTipo() 
	{
	
		System.out.println( this.lado1 + " - " + this.lado2 + " - " + this.lado3);
		
		if( (this.lado1 == this.lado2) && (this.lado1 == this.lado3) && (this.lado2 == this.lado3))
		{
			return "equilatero";
		}
		
		if( (this.lado1 == this.lado2 && this.lado1 != this.lado3) || 
			(this.lado2 == this.lado3 && this.lado2 != this.lado1) ||
			(this.lado3 == this.lado1 && this.lado3 != this.lado2) )
		{
			return "isoceles";
		}
		
		return "escaleno";

	}
	
	public int getLado(int lado)
	{
		if( lado == 1 )
			return this.lado1;
		
		if( lado == 2 )
			return this.lado2;
		
		if( lado == 3 )
			return this.lado3;
		
		return 0;
	}
	
}
