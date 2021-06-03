import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.ImageIcon;

class IntPrincipal extends JFrame implements ActionListener{		
										//Essa classe é responsavel pela interface, se alguem clicar em cadastrar cliente, essa classe vai
										//mostrar a opção do cadastro, apos ser cadastrado as informações serão enviadas para outra classe
	
	JanelaCadastro jc = new JanelaCadastro();
	CadastroVenda jv = new CadastroVenda();
	CadastroAtendente ja = new CadastroAtendente();
										
	EditaCliente ec = new EditaCliente();
	EditaVenda ev = new EditaVenda();
	EditaAtendente ea = new EditaAtendente();
	
	ListagemClientes lc = new ListagemClientes();
	ListagemVendas lv = new ListagemVendas();
	ListagemAtendentes la = new ListagemAtendentes ();
	
	ApagarCliente ac = new ApagarCliente();
	ApagarVenda av = new ApagarVenda();
	ApagarAtendente aa = new ApagarAtendente();
	//ConsultaCliente cl = new ConsultaCliente();
	
	
	private JMenuBar jmbarra = new JMenuBar();  //barra para escolher uma opção
	
	private JMenu jmInicio = new JMenu("Inicio"); //primeira opção da barra de opção
	private JMenuItem jmCadastrarC = new JMenuItem("Cadastrar Cliente");		//Todas essas 4 opções são obrigatorias
	private JMenuItem jmAlterarC = new JMenuItem("Alterar Cliente");			//A letra no final indica de onde ela vem
	private JMenuItem jmListarC = new JMenuItem("Listar Clientes");		
	private JMenuItem jmExcluirC = new JMenuItem("Excluir Cliente");
	
	private JMenu jmOpcao = new JMenu("Opcoes");  //segunda opção da barra
	private JMenuItem jmCadastrarV = new JMenuItem("Cadastrar Venda");		
	private JMenuItem jmAlterarV = new JMenuItem("Alterar Venda");
	private JMenuItem jmListarV = new JMenuItem("Listar Venda");
	private JMenuItem jmExcluirV = new JMenuItem("Excluir Vendas");
		
	private JMenu jmOutro = new JMenu("Outros");  //terceira opção da barra
	private JMenuItem jmCadastrarA = new JMenuItem("Cadastrar Atendente");
	private JMenuItem jmAlterarA = new JMenuItem("Alterar Atendente");
	private JMenuItem jmListarA = new JMenuItem("Listar Atendente");
	private JMenuItem jmExcluirA = new JMenuItem("Excluir Atendente");
	
	private JMenu jmAjuda = new JMenu("Ajuda"); //quarta opção da barra
	private JMenuItem jmSair = new JMenuItem("Sair");
	
	private ImageIcon imagem = new ImageIcon(getClass().getResource("logo.jpg"));
	private JLabel labelImg = new JLabel(imagem);
	
	
	IntPrincipal(){
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("TopCar");  //janela da interface grafica
		this.setSize(750,1000);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		this.labelImg.setIcon(imagem);
		this.labelImg.setBounds(15,15,700,700);
		this.add(labelImg);
		
		this.setJMenuBar(jmbarra);  //aparecer a barra na janela
		
		jmbarra.add(jmInicio);	    //adiciona uma opção na barra
		jmInicio.add(jmCadastrarC);  //adiciona opções dentro da opção
		jmCadastrarC.addActionListener(this);
		jmInicio.add(jmAlterarC);
		jmAlterarC.addActionListener(this);
		jmInicio.add(jmListarC);
		jmListarC.addActionListener(this);
		jmInicio.add(jmExcluirC);
		jmExcluirC.addActionListener(this);
		
		jmbarra.add(jmOpcao);		//msm coisa
		jmOpcao.add(jmCadastrarV);
		jmCadastrarV.addActionListener(this);
		jmOpcao.add(jmAlterarV);
		jmAlterarV.addActionListener(this);
		jmOpcao.add(jmListarV);
		jmListarV.addActionListener(this);
		jmOpcao.add(jmExcluirV);
		jmExcluirV.addActionListener(this);
		
		jmbarra.add(jmOutro);		//msm coisa
		jmOutro.add(jmCadastrarA);
		jmCadastrarA.addActionListener(this);
		jmOutro.add(jmAlterarA);
		jmAlterarA.addActionListener(this);
		jmOutro.add(jmListarA);
		jmListarA.addActionListener(this);
		jmOutro.add(jmExcluirA);
		jmExcluirA.addActionListener(this);
		
		jmbarra.add(jmAjuda);     //msm coisa
		jmAjuda.add(jmSair);
		jmSair.addActionListener(this);
		
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		if (event.getSource()== jmCadastrarC){
			jc.setVisible(true);
	}
		if (event.getSource()== jmAlterarC){
			ec.setVisible(true);
	}
		if (event.getSource()== jmListarC){
			lc.listagem();
			lc.setVisible(true);
	}
		if(event.getSource()== jmExcluirC){
			ac.setVisible(true);
	}
	
	
		if(event.getSource()== jmCadastrarV){
			jv.setVisible(true);
	}
		if(event.getSource()== jmAlterarV){
			ev.setVisible(true);
	}
		if (event.getSource()== jmListarV){
			lv.listagem();
			lv.setVisible(true);
	}
		if(event.getSource()== jmExcluirV){
			av.setVisible(true);
	}
	
	
		if(event.getSource()== jmCadastrarA){
			ja.setVisible(true);
	}
		if(event.getSource()== jmAlterarA){
			ea.setVisible(true);
	}
		if (event.getSource()== jmListarA){
			la.listagem();
			la.setVisible(true);
	}
		if(event.getSource()== jmExcluirA){
			aa.setVisible(true);
	}
		if(event.getSource()== jmSair){
			System.exit(0);
	}
}
}
