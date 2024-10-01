package ec.edu.ups.interpreter.model;

import ec.edu.ups.interpreter.controller.ContextoController;

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
	public void interpret(ContextoController contexto) {
		contexto.setOperador(contexto.getValor(this.valor));
		contexto.realizaOperacion();
	}

}
