
public class Venda{
	
	private String codvenda;
	private String formaPagamento;
	private String codcliente;
	private String codcarro;
	private String codatendente;
	
	
	public Venda(){
		this.formaPagamento="";
	}
	
	public void setCodvenda (String codvenda){
		this.codvenda = codvenda;
	}
	public String getCodvenda (){
		return codvenda;
	}
		public void setFormaPagamento(String fp){
		this.formaPagamento=fp;
	}
	public String getFormaPagamento(){
		return formaPagamento;
	}

	public void setCodcliente(String codcliente){
		this.codcliente = codcliente;
	}
	public String getCodcliente(){
		return codcliente;
	}
	public void setCodcarro(String codcarro){
		this.codcarro = codcarro;
	}
	public String getCodcarro(){
		return codcarro;
	}
	public void setCodatendente(String codatendente){
		this.codatendente=codatendente;
	}
	public String getCodatendente(){
		return codatendente;
	}
		
	
}

