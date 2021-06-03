

public class Cliente {
	
	private String codcliente;
	private String cpf;
	private String nome;
	private String telefone;
	
	public Cliente(){
		this.codcliente = "";
		this.cpf="";
		this.nome="";
		this.telefone="";
	}
	public void setCodcliente(String cod){
		this.codcliente=cod;
	}
	public String getCodcliente(){
		return codcliente;
	}
	public void setCpf(String cpf){
		this.cpf=cpf;
	}
	public String getCpf(){
		return cpf;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public String getNome(){
		return nome;
	}
	public void setTelefone(String tel){
		this.telefone=tel;
	}
	public String getTelefone(){
		return telefone;
	}
}

