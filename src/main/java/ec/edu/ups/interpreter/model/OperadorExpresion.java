package ec.edu.ups.interpreter.model;

public class OperadorExpresion implements IExpression {

	private String operacion;

	public OperadorExpresion(String token) {
		this.operacion = token;
	}

	@Override
	public void interpret(Contexto contexto) {
		contexto.setOperacion(this.operacion);
		contexto.realizaOperacion();
	}

}
