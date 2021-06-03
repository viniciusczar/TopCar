import java.sql.*;
import java.util.*;

public class Control_Banco {
	private Connection conexao;
	
	public Control_Banco(){
		conexao = new FabricaDeConexoes().solicitaConexao("localhost","Concessionaria","root","");
	}
	
	public void cadastrarVenda(Venda v){
		
		
		String sql = "insert into Venda "+
		"(codvenda, forma_de_pagamento, codcarro, codcliente, codatendente) "+
		"values (?,?,?,?,?)";
		
		try{
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1,v.getCodvenda());
			ps.setString(2,v.getFormaPagamento());
			ps.setString(3,v.getCodcarro());
			ps.setString(4,v.getCodcliente());
			ps.setString(5,v.getCodatendente());
			
			ps.execute();
			ps.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//Apartir daqui somente será possível consultar, alterar, listar ou excluir a venda e não o cliente.
	// Para entendermos que o cadastro do cliente é único! mas a venda pode mudar
	public Venda pesquisaVenda(String pe){
		Venda v = new Venda();
		
		try{
			String sql = "select * from Venda where codvenda like ?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1,"%"+pe+"%");
			
			ResultSet rs = ps.executeQuery();
			v.setCodvenda("0");
			  while(rs.next()){
				if(rs.getString("codvenda").equals(pe)){
					v.setCodvenda(rs.getString("codvenda"));
					v.setFormaPagamento(rs.getString("forma_de_pagamento"));
					v.setCodcarro(rs.getString("codcarro"));
					v.setCodcliente(rs.getString("codcliente"));
					v.setCodatendente(rs.getString("codatendente"));
				}
			}
			rs.close();
			ps.close();
			return v;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
		public void altera(Venda v){
			String sql ="update Venda set "+
			"forma_de_pagamento=?, codcarro=?"+
			" where codvenda=?";
			
			try{
				PreparedStatement ps=conexao.prepareStatement(sql);
				ps.setString(1,v.getFormaPagamento());
				ps.setString(2,v.getCodcarro());
				ps.setString(3,v.getCodvenda());
				
				
				ps.execute();
				ps.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}
		}
		public List<Venda> listar(){
			try{
				List<Venda> vendas = new ArrayList<Venda>();
				PreparedStatement ps = conexao.prepareStatement("Select * from Venda");
				ResultSet res = ps.executeQuery();
				
				while(res.next()){
					Venda v = new Venda();
					v.setCodvenda(res.getString("codvenda"));
					v.setCodatendente(res.getString("codatendente"));
					v.setCodcarro(res.getString("codcarro"));
					v.setCodcliente(res.getString("codcliente"));
					v.setFormaPagamento(res.getString("forma_de_pagamento"));
					
					vendas.add(v);
				}
				res.close();
				ps.close();
				return vendas;
			}
			catch (SQLException e){
				throw new RuntimeException(e);
			}
		}
		public void apaga(String a){
			String sql = "delete from Venda "+"where codvenda=?";
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


