package ec.edu.ups.interpreter.model;

public class main {
	public static void main(String[] args) {
		// Crear expresiones para la forma: (10 + 5) - 3
		Expression diez = new NumberExpression(10);
		Expression cinco = new NumberExpression(5);
		Expression tres = new NumberExpression(3);

		// Sumar 10 + 5
		Expression suma = new AddExpression(diez, cinco);

		// Restar 3 al resultado de la suma anterior (10 + 5)
		Expression resta = (Expression) new SubtractExpression(suma, tres);

		// interpretar la expresión final
		System.out.println("Resultado: " + resta.interpret()); // Output: 12
	}
}
