import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class ApagarVenda extends JFrame implements ActionListener {
	
	private Connection conexao;
	Control_Banco av = new Control_Banco();
	Venda c = new Venda();
	
	private JLabel jlcodvenda = new JLabel ("Codigo da Venda");
	private JTextField jtfcodvenda = new JTextField (11);
	
	private JRadioButton s = new JRadioButton ("Sim");
	private JRadioButton n = new JRadioButton ("Nao");
	
	private JButton jbConfirma = new JButton();
	
	private ButtonGroup bgrupo = new ButtonGroup();
	
	ApagarVenda(){
		this.setTitle("Exclusao de venda");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		jlcodvenda.setBounds(20,10,100,10);
		add(jlcodvenda);
		jtfcodvenda.setBounds(20,30,130,20);
		jtfcodvenda.setToolTipText("Digite o codigo da venda");
		this.add(jtfcodvenda);

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
			av.apaga(jtfcodvenda.getText());
			
			jtfcodvenda.setText("");
		
			}
			if (n.isSelected()){
				
			jtfcodvenda.setText("");
			}
	
}
}
}
