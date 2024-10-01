package ec.edu.ups.interpreter.model;

import ec.edu.ups.interpreter.controller.ContextoController;

/**
 * 
 * @author Grupo 3
 *
 */
public interface IExpression {

	public abstract void interpret(ContextoController contexto);
}
