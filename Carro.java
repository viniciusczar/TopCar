

public class Carro {
	
	private String codCarro;
	private String Cmodelo;
	private String fornecedor;
	private String valor;
	private String quant;
	
	public Carro(){
		this.codCarro = "";
		this.Cmodelo="";
		this.fornecedor="";
		this.valor="";
		this.quant="";
	}
	public void setCodcarro(String cod){
		this.codCarro=cod;
	}
	public String getCodcarro(){
		return codCarro;
	}
	public void setCmodelo(String Cmodelo){
		this.Cmodelo=Cmodelo;
	}
	public String getCmodelo(){
		return Cmodelo;
	}
	public void setFornecedor(String forn){
		this.fornecedor=forn;
	}
	public String getFornecedor(){
		return fornecedor;
	}
	public void setValor(String v){
		this.valor=v;
	}
	public String getValor(){
		return valor;
	}
	public void setQuantidade(String quant){
		this.quant=quant;
	}
	public String getQuantidade(){
		return quant;
	}

}

