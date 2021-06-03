import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

	class JanelaCadastro extends JFrame implements ActionListener {
		
	private Connection conexao;
	Control_Clientes cl = new Control_Clientes();
	Cliente c = new Cliente();
	
	private JLabel jlCodcliente = new JLabel ("O Codigo do Cliente");
	private JTextField jtfCodCliente = new JTextField (20);
	
	private JLabel jlCpf = new JLabel ("CPF");
	private JTextField jtfCpf = new JTextField (11);
	
	private JLabel jlNome = new JLabel ("Nome");
	private JTextField jtfNome = new JTextField (100);
	
	private JLabel jlTelefone = new JLabel ("Telefone");
	private JTextField jtfTelefone = new JTextField (11);
	
	private JButton gravar = new JButton ("Gravar");
	private JButton limpar = new JButton ("Limpar");

	
	JanelaCadastro(){
		setTitle("Janela de Clientes");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		setLayout(null);
		
		jlCodcliente.setBounds(20,10,210,10);
		add(jlCodcliente);
		jtfCodCliente.setBounds(20,40,130,20);
		jtfCodCliente.setToolTipText("O codigo do cliente");
		this.add(jtfCodCliente);
		
		jlCpf.setBounds(20,60,110,20);
		add(jlCpf);
		jtfCpf.setBounds(20,90,130,30);
		jtfCpf.setToolTipText("Digite um CPF");
		this.add(jtfCpf);
		
		jlNome.setBounds(20,120,100,20);
		add(jlNome);
		jtfNome.setBounds(20,150,170,30);
		jtfNome.setToolTipText("Digite um nome");
		this.add(jtfNome);
		
		jlTelefone.setBounds(20,190,100,20);
		add(jlTelefone);
		jtfTelefone.setBounds(20,220,100,30);
		jtfTelefone.setToolTipText("Digite um telefone");
		this.add(jtfTelefone);
		
		
		gravar.setBounds(220,40,100,20);
		gravar.addActionListener(this);
		add(gravar);
		
		limpar.setBounds(220,70,100,20);
		limpar.addActionListener(this);
		add(limpar);
		
		
		//this.setVisible(false);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==gravar){
			c.setCodcliente(jtfCodCliente.getText());
			c.setCpf(jtfCpf.getText());
			c.setNome(jtfNome.getText());
			c.setTelefone(jtfTelefone.getText());
			
			
			jtfCodCliente.setText(c.getCodcliente());
			jtfNome.setText("");
			jtfCpf.setText("");
			jtfTelefone.setText("");
			
			cl.cadastrarCliente(c);
			
		
	}
		if(e.getSource()==limpar){
			
			jtfCodCliente.setText("");
			jtfCpf.setText("");
			jtfNome.setText("");
			jtfTelefone.setText("");
		}
			
	}
}

