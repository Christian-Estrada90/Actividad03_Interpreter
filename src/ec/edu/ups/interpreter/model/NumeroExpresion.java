package ec.edu.ups.interpreter.model;

/**
 * 
 * @author Grupo 3
 *
 */
public class NumeroExpresion implements IExpression {

	private String valor;

	public NumeroExpresion(String token){
		this.valor = token;
	}

	@Override
	public void interpret(Contexto contexto) {
		contexto.setOperador(contexto.getValor(this.valor));
		contexto.realizaOperacion();
	}

}
