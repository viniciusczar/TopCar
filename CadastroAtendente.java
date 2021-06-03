import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

	class CadastroAtendente extends JFrame implements ActionListener {
		
	private Connection conexao;
	Controle_Atendente ca = new Controle_Atendente();
	Atendente a = new Atendente();
	
	private JLabel jlcodatendente = new JLabel ("O Codigo do Atendente");
	private JTextField jtfcodatendente = new JTextField (20);
	
	private JLabel jlcomissao = new JLabel ("Comissao");
	private JTextField jtfcomissao = new JTextField (11);
	
	private JLabel jlNome = new JLabel ("Nome");
	private JTextField jtfNome = new JTextField (100);
	
	
	private JButton gravar = new JButton ("Gravar");
	private JButton limpar = new JButton ("Limpar");

	
	CadastroAtendente(){
		setTitle("Janela de Atendentes");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		setLayout(null);
		
		jlcodatendente.setBounds(20,10,220,10);
		add(jlcodatendente);
		jtfcodatendente.setBounds(20,40,130,20);
		jtfcodatendente.setToolTipText("Digite o codigo do atendente");
		this.add(jtfcodatendente);
		
		jlcomissao.setBounds(20,60,110,20);
		add(jlcomissao);
		jtfcomissao.setBounds(20,90,130,30);
		jtfcomissao.setToolTipText("Digite a comissao");
		this.add(jtfcomissao);
		
		jlNome.setBounds(20,120,100,20);
		add(jlNome);
		jtfNome.setBounds(20,150,170,30);
		jtfNome.setToolTipText("Digite um nome");
		this.add(jtfNome);
		
		gravar.setBounds(200,40,100,20);
		gravar.addActionListener(this);
		add(gravar);
		
		limpar.setBounds(200,70,100,20);
		limpar.addActionListener(this);
		add(limpar);
		
		
		//this.setVisible(false);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==gravar){
			
			a.setCodatendente(jtfcodatendente.getText());
			a.setComissao(jtfcomissao.getText());
			a.setNome(jtfNome.getText());
			
			jtfcodatendente.setText(a.getCodatendente());
			jtfNome.setText("");
			jtfcomissao.setText("");
			
			ca.cadastrarAtendente(a);
			
	}
		if(e.getSource()==limpar){
			
			jtfcodatendente.setText("");
			jtfcomissao.setText("");
			jtfNome.setText("");
		}
			
	}
}
