import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

class CadastroVenda extends JFrame implements ActionListener{
	
	private Connection conexao;
	Control_Banco cb = new Control_Banco();
	Venda v = new Venda();
	
	private JLabel jlCodvenda = new JLabel ("O codigo da venda");
	private JTextField jtfCodvenda = new JTextField (20);
	
	private JLabel jlFmPagamento = new JLabel ("Forma de Pagamento");
	private JTextField jtfFmPagamento = new JTextField (20);
	
	private JLabel jlCodcliente = new JLabel ("Codigo do cliente");
	private JTextField jtfCodCliente = new JTextField (100);
	
	private JLabel jlCodcarro = new JLabel ("Codigo do carro");
	private JTextField jtfCodcarro = new JTextField (20);
	
	private JLabel jlCodatendente = new JLabel ("Codigo do atedente");
	private JTextField jtfCodatendente = new JTextField (20);
	
	private JButton gravar = new JButton ("Gravar");
	private JButton limpar = new JButton ("Limpar");
	
	CadastroVenda(){
		
	
		setTitle("Janela de Venda");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		setLayout(null);
		
		jlCodvenda.setBounds(20,10,220,10);
		add(jlCodvenda);
		jtfCodvenda.setBounds(20,40,130,20);
		jtfCodvenda.setToolTipText("O codigo da venda");
		this.add(jtfCodvenda);
		
		jlFmPagamento.setBounds(20,60,110,20);
		add(jlFmPagamento);
		jtfFmPagamento.setBounds(20,90,130,30);
		jtfFmPagamento.setToolTipText("Digite a forma de pagamento");
		this.add(jtfFmPagamento);
		
		jlCodcliente.setBounds(20,120,100,20);
		add(jlCodcliente);
		jtfCodCliente.setBounds(20,150,170,30);
		jtfCodCliente.setToolTipText("Codigo do Cliente");
		this.add(jtfCodCliente);

		jlCodcarro.setBounds(20,190,100,20);
		add(jlCodcarro);
		jtfCodcarro.setBounds(20,220,100,30);
		jtfCodcarro.setToolTipText("Digite o codigo do carro");
		this.add(jtfCodcarro);
		
		jlCodatendente.setBounds(20,260,100,20);
		add(jlCodatendente);
		jtfCodatendente.setBounds(20,290,100,30);
		jtfCodatendente.setToolTipText("Digite o codigo do atendente");
		this.add(jtfCodatendente);

		
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
			v.setCodvenda(jtfCodvenda.getText());
			v.setCodatendente(jtfCodatendente.getText());
			v.setCodcarro(jtfCodcarro.getText());
			v.setFormaPagamento(jtfFmPagamento.getText());
			v.setCodcliente(jtfCodCliente.getText());
			
			jtfCodvenda.setText(v.getCodvenda());
			jtfCodatendente.setText("");
			jtfCodcarro.setText("");
			jtfCodCliente.setText("");
			jtfFmPagamento.setText("");
			
			cb.cadastrarVenda(v);
		}
		if(e.getSource()==limpar){
			
			jtfCodvenda.setText("");
			jtfCodatendente.setText("");
			jtfCodcarro.setText("");
			jtfCodCliente.setText("");
			jtfFmPagamento.setText("");	
	}
}
}

