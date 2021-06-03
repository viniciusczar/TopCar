import java.sql.*;
import java.util.*;

public class Controle_Atendente{
	private Connection conexao;
	
	public Controle_Atendente(){
		conexao = new FabricaDeConexoes().solicitaConexao("localhost","Concessionaria","root","");
	}
	
	public void cadastrarAtendente(Atendente v){
		
		
		String sql = "insert into Atendente "+
		"(codatendente, nome, comissao) "+
		"values (?,?,?)";
		
		try{
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1,v.getCodatendente());
			ps.setString(2,v.getNome());
			ps.setString(3,v.getComissao());
			
			ps.execute();
			ps.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//Apartir daqui somente será possível consultar, alterar, listar ou excluir
	
	public Atendente pesquisaAtendente(String pe){
		Atendente v = new Atendente();
		
		try{
			String sql = "select * from Atendente where codatendente like ?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1,"%"+pe+"%");
			
			ResultSet rs = ps.executeQuery();
			v.setCodatendente("0");
			  while(rs.next()){
				if(rs.getString("codatendente").equals(pe)){
					v.setCodatendente(rs.getString("codatendente"));
					v.setComissao(rs.getString("comissao"));
					v.setNome(rs.getString("nome"));
				}
			}
			rs.close();
			ps.close();
			return v;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
		public void altera(Atendente v){
			String sql ="update Atendente set "+
			"nome=?, comissao=? "+
			"where codatendente=?";
			
			try{
				PreparedStatement ps=conexao.prepareStatement(sql);
				ps.setString(1,v.getNome());
				ps.setString(2,v.getComissao());
				ps.setString(3,v.getCodatendente());
				
				ps.execute();
				ps.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}
		}
		public List<Atendente> atendentes(){
			try{
				List<Atendente> atendentes = new ArrayList<Atendente>();
				PreparedStatement ps = conexao.prepareStatement("Select * from Atendente");
				ResultSet res = ps.executeQuery();
				
				while(res.next()){
					Atendente v = new Atendente();
					v.setCodatendente(res.getString("codatendente"));
					v.setNome(res.getString("nome"));
					v.setComissao(res.getString("comissao"));
					
					atendentes.add(v);
				}
				res.close();
				ps.close();
				return atendentes;
			}
			catch (SQLException e){
				throw new RuntimeException(e);
			}
		}
		public void apaga(String a){
			String sql = "delete from Atendente "+"where codatendente=?";
			try{
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1,a);
				ps.execute();
				ps.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}
		}
}
