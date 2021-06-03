import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class ListagemAtendentes extends JFrame implements ActionListener {
	Controle_Atendente la = new Controle_Atendente();
	
	private JTextArea jtaList = new JTextArea();
	private JScrollPane jspRolagem = new JScrollPane(jtaList);
	
	ListagemAtendentes(){
		setTitle("Listagem de Atendentes");
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
		List<Atendente> atendentes = new ArrayList<Atendente>();
			
			atendentes = la.atendentes();
			jtaList.setText("");
			jtaList.setEditable(false);
			
			for(int i=0; i< atendentes.size(); i++){

				jtaList.append("\n\n* * * * * "+"\nCodigo do atendente: "+atendentes.get(i).getCodatendente()+"\nNome: "+
				atendentes.get(i).getNome()+"\nComissao: "+atendentes.get(i).getComissao());
		}
	}
	
}
