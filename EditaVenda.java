import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;


public class EditaVenda extends JFrame implements ActionListener{
	
	private Connection conexao;
	Control_Banco ev = new Control_Banco();
	Venda v = new Venda();
	
	private JLabel jlcodvenda = new JLabel ("Codigo da Venda");
	private JTextField jtfcodvenda = new JTextField (20);
	
	private JLabel jlformaPagamento = new JLabel ("Forma de Pagamento");
	private JTextField jtfformaPagamento = new JTextField (11);
	
	private JLabel jlCodcarro = new JLabel ("Codigo de Carro");
	private JTextField jtfCodcarro = new JTextField (11);

	private JRadioButton s = new JRadioButton ("Sim");
	private JRadioButton n = new JRadioButton ("Nao");
	
	private JButton jbConfirma = new JButton();
	private JButton jbVerifica = new JButton();
	
	private ButtonGroup bgrupo = new ButtonGroup();
	
	EditaVenda(){
		setTitle("Atualizar dados da venda");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		jlcodvenda.setBounds(20,10,100,10);
		add(jlcodvenda);
		jtfcodvenda.setBounds(20,30,130,20);
		jtfcodvenda.setToolTipText("Digite o codigo da venda");
		this.add(jtfcodvenda);
		
		jlformaPagamento.setBounds(20,60,100,20);
		add(jlformaPagamento);
		jtfformaPagamento.setBounds(20,80,100,20);
		jtfformaPagamento.setToolTipText("Digite a forma de pagamento");
		this.add(jtfformaPagamento);
		
		jlCodcarro.setBounds(20,110,100,20);
		add(jlCodcarro);
		jtfCodcarro.setBounds(20,130,100,20);
		jtfCodcarro.setToolTipText("Digite o codigo do carro");
		this.add(jtfCodcarro);

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
		
		jbVerifica.setText("Verifica");
		jbVerifica.setBounds(20,280,100,20);
		jbVerifica.addActionListener(this);
		jbVerifica.setMnemonic(KeyEvent.VK_V);
		this.add(jbVerifica);
		
		//this.setVisible(false);

		
	}
	public void actionPerformed(ActionEvent event){
		
		if(event.getSource()==jbVerifica){
			
			v = ev.pesquisaVenda(jtfcodvenda.getText());
			jtfcodvenda.setText(v.getCodvenda());
			jtfformaPagamento.setText(v.getFormaPagamento());
			jtfCodcarro.setText(v.getCodcarro());
		}
		
		if (event.getSource()==jbConfirma){
			
			if (s.isSelected()){
				
			v.setCodvenda(jtfcodvenda.getText());
			v.setFormaPagamento(jtfformaPagamento.getText());
			v.setCodcarro(jtfCodcarro.getText());
			
			jtfcodvenda.setText("");
			jtfformaPagamento.setText("");
			jtfCodcarro.setText("");
			
			ev.altera(v);
		
			}
			if (n.isSelected()){
				
			jtfcodvenda.setText("");
			jtfformaPagamento.setText("");
			jtfCodcarro.setText("");
			
			}
	}
}
	
}
