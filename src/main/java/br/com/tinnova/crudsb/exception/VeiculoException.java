package br.com.tinnova.crudsb.exception;

public class VeiculoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6212826653995678795L;
	private String message;
	
	public VeiculoException(Throwable e) {
		super(e);
	}
	public VeiculoException (String message) 
	{
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
