package ec.edu.ups.interpreter.model;

import java.util.ArrayList;

public class main {
	
	public static void main(String[] args) {

		// Creamos el arbol de expresiones y el contexto
		ArrayList<IExpression> expresiones = new ArrayList<>();

		String[] myArgs = new String[5];
        myArgs[0] = "uno";
        myArgs[1] = "mas";
        myArgs[2] = "cinco";
        myArgs[3] = "menos";
        myArgs[4] = "cuatro";
        		
		Contexto contexto = new Contexto();		

		// Añadimos los tokens pasados como argumentos

		for (String token : myArgs) {
			if (contexto.getInteger(token) >= 0)
				expresiones.add(new NumeroExpresion(token));
			else
				expresiones.add(new OperadorExpresion(token));
		}

		// Interpretamos cada expresión
		for (IExpression e : expresiones) 
			e.interpret(contexto);
		
		
		System.out.println("El resultado de la interpretacion es " + contexto.getResult());
	}
}
