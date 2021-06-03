public class Atendente {
	
	private String codatendente;
	private String comissao;
	private String nome;
	
	public Atendente(){
		this.codatendente = "";
		this.nome="";
		this.comissao="";
	}
	public void setCodatendente(String cod){
		this.codatendente=cod;
	}
	public String getCodatendente(){
		return codatendente;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public String getNome(){
		return nome;
	}
	public void setComissao(String comissao){
		this.comissao=comissao;
	}
	public String getComissao(){
		return comissao;
	}
}
