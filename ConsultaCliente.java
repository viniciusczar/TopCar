import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class ConsultaCliente extends JFrame implements ActionListener{
	
	private Connection conexao;
	Control_Clientes cl = new Control_Clientes();
	Cliente c = new Cliente();
	
	private JLabel jlCodcliente = new JLabel ("Codigo do Cliente");
	private JTextField jtfCodCliente = new JTextField (20);
	private JLabel jlCpf = new JLabel ("CPF do Cliente");
	private JTextField jtfCpf = new JTextField (12);
	private JLabel jlNome = new JLabel ("Nome do Cliente");
	private JTextField jtfNome = new JTextField (100);
	private JLabel jlTelefone = new JLabel ("Telefone do Cliente");
	private JTextField jtfTelefone = new JTextField (20);
	
	
	private JRadioButton s = new JRadioButton ("Sim");
	private JRadioButton n = new JRadioButton ("Nao");
	
	private JButton jbConfirma = new JButton();
	
	private ButtonGroup bgrupo = new ButtonGroup();
	
	ConsultaCliente(){
		this.setTitle("Consultar Clientes");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		jlCodcliente.setBounds(20,10,100,10);
		add(jlCodcliente);
		jtfCodCliente.setBounds(20,30,130,20);
		jtfCodCliente.setToolTipText("Digite o codigo do cliente");
		this.add(jtfCodCliente);
		
		jlCpf.setBounds(20,60,100,20);
		add(jlCpf);
		jtfCpf.setBounds(20,80,100,20);
		jtfCpf.setToolTipText("Digite o codigo do cliente para aparecer os dados do CPF");
		this.add(jtfCpf);
		
		jlNome.setBounds(20,110,100,20);
		add(jlNome);
		jtfNome.setBounds(20,130,100,20);
		jtfNome.setToolTipText("Digite o codigo do cliente para aparecer os dados do nome");
		this.add(jtfNome);
		
		jlTelefone.setBounds(20,160,100,20);
		add(jlTelefone);
		jtfTelefone.setBounds(20,180,100,20);
		jtfTelefone.setToolTipText("Digite o codigo do cliente para aparecer os dados do telefone");
		this.add(jtfTelefone);
		
		s.setBounds(20,210,100,20);
		n.setBounds(20,230,100,20);
		this.add(s);
		this.add(n);
		
		bgrupo.add(s);
		bgrupo.add(n);
		
		jbConfirma.setText("Confirma");
		jbConfirma.setBounds(20,250,100,20);
		jbConfirma.addActionListener(this);
		jbConfirma.setMnemonic(KeyEvent.VK_S);
		this.add(jbConfirma);
		
		
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent event){
		if (event.getSource()==jbConfirma){
			
			if (s.isSelected()){
				
			c = cl.pesquisaCliente(jtfCodCliente.getText());
			jtfCodCliente.setText(c.getCodcliente());
			jtfNome.setText(c.getNome());
			jtfCpf.setText(c.getCpf());
			jtfTelefone.setText(c.getTelefone());
		
			}
			if (n.isSelected()){
				
			jtfCodCliente.setText("");
			
			}
	}
}
}

