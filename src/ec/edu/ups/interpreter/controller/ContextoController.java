package ec.edu.ups.interpreter.controller;

/**
 * 
 * @author Grupo 3
 *
 */
public class ContextoController {

	private String siquienteOperacion = "";

	private int operador = 0;

	private int resultado = 0;

	public int getValor(String in) {

		if (in.toLowerCase().equals("cero"))
			return 0;
		else if (in.toLowerCase().equals("uno"))
			return 1;
		else if (in.toLowerCase().equals("dos"))
			return 2;
		else if (in.toLowerCase().equals("tres"))
			return 3;
		else if (in.toLowerCase().equals("cuatro"))
			return 4;
		else if (in.toLowerCase().equals("cinco"))
			return 5;
		else if (in.toLowerCase().equals("seis"))
			return 6;
		else if (in.toLowerCase().equals("siete"))
			return 7;
		else if (in.toLowerCase().equals("ocho"))
			return 8;
		else if (in.toLowerCase().equals("nueve"))
			return 9;
		else
			return -1;
	}

	public void setOperador(int operador){
		this.operador = operador;
	}

	public void setOperacion(String operacion){
		if (operacion.toLowerCase().equals("mas"))
			this.siquienteOperacion = "+";
		else if (operacion.toLowerCase().equals("menos"))
			this.siquienteOperacion = "-";
	}

	public void realizaOperacion() {
		if (this.siquienteOperacion.toLowerCase().equals("") || this.siquienteOperacion.toLowerCase().equals("+"))
			this.resultado += operador;
		else if (this.siquienteOperacion.toLowerCase().equals("-"))
			this.resultado -= operador;
		
		operador = 0;
	}

	public int getResultado() {
		return this.resultado;
	}
}
