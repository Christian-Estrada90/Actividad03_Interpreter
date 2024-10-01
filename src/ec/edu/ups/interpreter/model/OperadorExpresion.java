package ec.edu.ups.interpreter.model;

import ec.edu.ups.interpreter.controller.ContextoController;

/**
 * 
 * @author Grupo 3
 *
 */
public class OperadorExpresion implements IExpression {

	private String operacion;

	public OperadorExpresion(String token) {
		this.operacion = token;
	}

	@Override
	public void interpret(ContextoController contexto) {
		contexto.setOperacion(this.operacion);
		contexto.realizaOperacion();
	}

}
