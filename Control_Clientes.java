import java.sql.*;
import java.util.*;

public class Control_Clientes {
	
	private Connection conexao;
	
	public Control_Clientes(){
		conexao = new FabricaDeConexoes().solicitaConexao("localhost","Concessionaria","root","");
	}
	
	//Apartir daqui é a inserção nas tabelas Cliente e Vendas: O Software irá iniciar com o cadastro do cliente, depois
	//o cadastro da sua venda.
	
	public void cadastrarCliente(Cliente c){
		
		String sql2 = "insert into Cliente "+
		"(codcliente, nome, cpf, telefone) "+
		"values (?, ?, ?, ?) ";

	try{
		PreparedStatement ps2 = conexao.prepareStatement(sql2);
			ps2.setString(1,c.getCodcliente());
			ps2.setString(2,c.getNome());
			ps2.setString(3,c.getCpf());
			ps2.setString(4,c.getTelefone());
				
			ps2.execute();
			ps2.close();
		}catch (SQLException l){
			throw new RuntimeException(l);
		}
	}
	public Cliente pesquisaCliente(String ce){
		Cliente cl = new Cliente();
		
		try{
			String sql2 = "select * from Cliente where codcliente like ?";
			PreparedStatement ps = conexao.prepareStatement(sql2);
			ps.setString(1,"%"+ce+"%");
			
			ResultSet rs = ps.executeQuery();
			cl.setCodcliente("0");
			while(rs.next()){
			if(rs.getString("codcliente").equals(ce)){
				cl.setCodcliente(rs.getString("Codcliente"));
				cl.setCpf(rs.getString("cpf"));
				cl.setNome(rs.getString("nome"));
				cl.setTelefone(rs.getString("telefone"));
			}
		}
		rs.close();
		ps.close();
		return cl;
	}catch (SQLException e){
		throw new RuntimeException(e);
		
	}
		}
		
		
		public void altera(Cliente c){
			String sql ="update Cliente set "+
			"cpf=?,nome=?,telefone=? "+
			"where codcliente=?";
			
			try{
				PreparedStatement ps=conexao.prepareStatement(sql);
				ps.setString(1,c.getCpf());
				ps.setString(2,c.getNome());
				ps.setString(3,c.getTelefone());
				ps.setString(4,c.getCodcliente());
				
				ps.execute();
				ps.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}
		}
		
		public List<Cliente> listar(){
			try{
				List<Cliente> clientes = new ArrayList<Cliente>();
				PreparedStatement ps = conexao.prepareStatement("Select * from Cliente");
				ResultSet res = ps.executeQuery();
				
				while(res.next()){
					Cliente v = new Cliente();
					v.setCodcliente(res.getString("codcliente"));
					v.setCpf(res.getString("Cpf"));
					v.setNome(res.getString("nome"));
					v.setTelefone(res.getString("telefone"));
					
					clientes.add(v);
				}
				res.close();
				ps.close();
				return clientes;
			}
			catch (SQLException e){
				throw new RuntimeException(e);
			}
		}
		public void apaga(String a){
			String sql2 = "delete from Cliente "+"where codcliente=?";
			try{
				PreparedStatement ps = conexao.prepareStatement(sql2);
				ps.setString(1,a);
				ps.execute();
				ps.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}
		}
	
}
