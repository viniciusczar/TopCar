import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class ApagarCliente extends JFrame implements ActionListener {
	
	private Connection conexao;
	Control_Clientes cl = new Control_Clientes();
	Cliente c = new Cliente();
	
	private JLabel jlCpf = new JLabel ("CPF");
	private JTextField jtfCpf = new JTextField (11);
	
	private JLabel jlCodcliente = new JLabel ("Codigo do Cliente");
	private JTextField jtfCodCliente = new JTextField (20);
	
	private JRadioButton s = new JRadioButton ("Sim");
	private JRadioButton n = new JRadioButton ("Nao");
	
	private JButton jbConfirma = new JButton();
	
	private ButtonGroup bgrupo = new ButtonGroup();
	
	ApagarCliente(){
		this.setTitle("Exclusao de Clientes");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		jlCpf.setBounds(20,10,100,10);
		add(jlCpf);
		jtfCpf.setBounds(20,30,130,20);
		jtfCpf.setToolTipText("Digite o CPF");
		this.add(jtfCpf);
		
		jlCodcliente.setBounds(20,70,100,20);
		add(jlCodcliente);
		jtfCodCliente.setBounds(20,90,130,30);
		jtfCodCliente.setToolTipText("Digite o codigo do cliente");
		this.add(jtfCodCliente);
		
		s.setBounds(20,130,100,20);
		n.setBounds(20,150,100,20);
		this.add(s);
		this.add(n);
		
		bgrupo.add(s);
		bgrupo.add(n);
		
		jbConfirma.setText("Confirma");
		jbConfirma.setBounds(20,190,100,20);
		jbConfirma.addActionListener(this);
		jbConfirma.setMnemonic(KeyEvent.VK_S);
		this.add(jbConfirma);
		
		
		//this.setVisible(false);
		
		
	}
	 
	 public void actionPerformed(ActionEvent event){
		 
		if (event.getSource()==jbConfirma){
			
			if (s.isSelected()){
			cl.apaga(jtfCodCliente.getText());
			
			jtfCodCliente.setText("");
			jtfCpf.setText("");
		
			}
			if (n.isSelected()){
				
			jtfCodCliente.setText("");
			jtfCpf.setText("");
			}
	
}
}
}
