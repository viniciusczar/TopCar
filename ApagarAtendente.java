import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class ApagarAtendente extends JFrame implements ActionListener {
	
	private Connection conexao;
	Controle_Atendente aa = new Controle_Atendente();
	Atendente c = new Atendente();
	
	private JLabel jlcodatendente = new JLabel ("Codigo do Atendente");
	private JTextField jtfcodatendente = new JTextField (11);
	
//	private JLabel jlCodcliente = new JLabel ("Codigo do Cliente");
//	private JTextField jtfCodCliente = new JTextField (20);
	
	private JRadioButton s = new JRadioButton ("Sim");
	private JRadioButton n = new JRadioButton ("Nao");
	
	private JButton jbConfirma = new JButton();
	
	private ButtonGroup bgrupo = new ButtonGroup();
	
	ApagarAtendente(){
		this.setTitle("Exclusao de Atendentes");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		jlcodatendente.setBounds(20,10,120,10);
		add(jlcodatendente);
		jtfcodatendente.setBounds(20,30,130,20);
		jtfcodatendente.setToolTipText("Digite o codigo do atendente");
		this.add(jtfcodatendente);
	
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
			aa.apaga(jtfcodatendente.getText());
			
			jtfcodatendente.setText("");
		
			}
			if (n.isSelected()){
				
			jtfcodatendente.setText("");
			}
	
}
}
}
