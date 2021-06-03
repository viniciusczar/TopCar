import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class ListagemVendas extends JFrame implements ActionListener {
	Control_Banco lv = new Control_Banco();
	
	
	private JTextArea jtaList = new JTextArea();
	private JScrollPane jspRolagem = new JScrollPane(jtaList);
	
	ListagemVendas(){
		setTitle("Listagem de Vendas");
		setSize(520,379);
		setLocationRelativeTo(null);
		setLayout(null);
		
		jspRolagem.setBounds(20,20,460,260);
		add(jspRolagem);
		
		//this.setVisible(false);
	}
	public void actionPerformed(ActionEvent event)
	{}
	public void listagem(){
		List<Venda> vendas = new ArrayList<Venda>();
			
			vendas = lv.listar();
			jtaList.setText("");
			jtaList.setEditable(false);
			
			for(int i=0; i< vendas.size(); i++){
				
				jtaList.append("\n\n* * * * * "+"\nCodigo da venda: "+vendas.get(i).getCodvenda()+"\nCodigo do cliente: "+vendas.
				get(i).getCodcliente()+"\nCodigo do carro: "+vendas.get(i).getCodcarro()+"\nCodigo do atendente: "+vendas.get(i).getCodatendente
				()+"\nForma de pagamento: "+vendas.get(i).getFormaPagamento());
		}
	}
	
}
