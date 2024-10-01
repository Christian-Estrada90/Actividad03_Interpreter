package ec.edu.ups.interpreter.model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Grupo 3
 *
 */
public class main {

	public static void main(String[] args) {
		Contexto contexto = new Contexto();
		Scanner lectura = new Scanner(System.in);
		
		// Creamos el arbol de expresiones y el contexto
		ArrayList<IExpression> expresiones = new ArrayList<>();
		
		System.out.println("Ingrese la Operecion en Letras:");
		
		String myArgs[];
		String val = lectura.nextLine();
		myArgs = val.split(" ");
		
		//Añadimos las cadenas pasados como argumentos

		for (String token : myArgs) {
			if (contexto.getValor(token) >= 0)
				expresiones.add(new NumeroExpresion(token));
			else
				expresiones.add(new OperadorExpresion(token));
		}

		// Interpretamos cada expresión
		for (IExpression e : expresiones)
			e.interpret(contexto);

		System.out.println("El resultado de la interpretacion es " + contexto.getResultado());
	}
}
