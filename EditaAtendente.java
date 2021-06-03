import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;


public class EditaAtendente extends JFrame implements ActionListener{
	
	private Connection conexao;
	Controle_Atendente ea = new Controle_Atendente();
	Atendente a = new Atendente();
	
	private JLabel jlcodatendente = new JLabel ("Codigo do Atendente");
	private JTextField jtfcodatendente = new JTextField (20);
	
	private JLabel jlcomissao = new JLabel ("Comissao");
	private JTextField jtfcomissao = new JTextField (11);
	
	private JLabel jlNome = new JLabel ("Nome");
	private JTextField jtfNome = new JTextField (100);
	
	private JRadioButton s = new JRadioButton ("Sim");
	private JRadioButton n = new JRadioButton ("Nao");
	
	private JButton jbConfirma = new JButton();
	private JButton jbVerifica = new JButton();
	
	private ButtonGroup bgrupo = new ButtonGroup();
	
	EditaAtendente(){
		setTitle("Atualizar dados de Atendente");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		jlcodatendente.setBounds(20,10,170,10);
		add(jlcodatendente);
		jtfcodatendente.setBounds(20,30,130,20);
		jtfcodatendente.setToolTipText("Digite o codigo do atendente");
		this.add(jtfcodatendente);
		
		jlcomissao.setBounds(20,60,100,20);
		add(jlcomissao);
		jtfcomissao.setBounds(20,80,100,20);
		jtfcomissao.setToolTipText("Digite o codigo do atendente para aparecer os dados da comissao");
		this.add(jtfcomissao);
		
		jlNome.setBounds(20,110,100,20);
		add(jlNome);
		jtfNome.setBounds(20,130,100,20);
		jtfNome.setToolTipText("Digite o codigo do atendente para aparecer os dados do nome");
		this.add(jtfNome);
		
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
		jbVerifica.setMnemonic(KeyEvent.VK_S);
		this.add(jbVerifica);
		
		
		//this.setVisible(false);

		
	}
	public void actionPerformed(ActionEvent event){
		if(event.getSource()==jbVerifica){
			
			a = ea.pesquisaAtendente(jtfcodatendente.getText());
			jtfcodatendente.setText(a.getCodatendente());
			jtfcomissao.setText(a.getComissao());
			jtfNome.setText(a.getNome());
		}
		
		if (event.getSource()==jbConfirma){
			
			if (s.isSelected()){
				
			a.setCodatendente(jtfcodatendente.getText());
			a.setComissao(jtfcomissao.getText());
			a.setNome(jtfNome.getText());
			
			jtfcodatendente.setText("");
			jtfcomissao.setText("");
			jtfNome.setText("");
			
			ea.altera(a);
		
			}
			if (n.isSelected()){
				
			jtfcodatendente.setText("");
			
			}
	}
}
	
}
