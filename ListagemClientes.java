import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class ListagemClientes extends JFrame implements ActionListener {
	Control_Clientes cc = new Control_Clientes();
	
	private JTextArea jtaList = new JTextArea();
	private JScrollPane jspRolagem = new JScrollPane(jtaList);
	
	ListagemClientes(){
		setTitle("Listagem de Clientes");
		setSize(520,370);
		setLocationRelativeTo(null);
		setLayout(null);
		
		jspRolagem.setBounds(20,20,460,260);
		add(jspRolagem);
		
		//this.setVisible(false);
	}
	public void actionPerformed(ActionEvent event)
	{}
	public void listagem(){
		List<Cliente> clientes = new ArrayList<Cliente>();
			
			clientes = cc.listar();
			jtaList.setText("");
			jtaList.setEditable(false);
			
			for(int i=0; i< clientes.size(); i++){
				
				jtaList.append("\n\n* * * * * "+"\nCodigo do Cliente: "+clientes.get(i).getCodcliente()+"\nNome: "
				+clientes.get(i).getNome()+
				"\nCPF: "+clientes.get(i).getCpf()+"\nTelefone: "+clientes.get(i).getTelefone());
				
		}
	}
	
}

