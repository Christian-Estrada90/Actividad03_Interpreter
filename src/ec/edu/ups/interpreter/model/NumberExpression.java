package ec.edu.ups.interpreter.model;

/**
 * 
 * @author Grupo 3
 *
 */
public class NumberExpression implements Expression {

	private int numero;
	
	public NumberExpression(int num) {
		this.numero = num;
	}
	
	@Override
	public int interpret() {
		return this.numero;
	}

}
