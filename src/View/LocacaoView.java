package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import Controller.ControllerLocacao;
import Dao.AutomovelDao;
import Dao.AutomovelDaoImplementation;
import Dao.LocacaoDao;
import Dao.LocacaoDaoImplementation;
import Dao.SimulacaoDao;
import Dao.SimulacaoDaoImplementation;
import Entidades.Automovel;
import Entidades.Locacao;
import Entidades.Simulacao;

public class LocacaoView extends JFrame implements ControllerLocacao {

	private JPanel contentPane;
	private JTextField tfIDAutomovel;
	private JTextField tfCPF;
	private JTextField tfDataDevolucao;
	private final JSeparator separator = new JSeparator();
	private JTextField tfDataAtual;

	private final JRadioButton rbCadastrar = new JRadioButton("Cadastrar");
	private final JRadioButton rbAlterar = new JRadioButton("Alterar");
	private final JRadioButton rbExcluir = new JRadioButton("Excluir");
    private final JButton btnEfetuar = new JButton("Efetuar");
    private final JButton btnConsultar = new JButton("Consultar");
	private final JButton btnAlterar = new JButton("Alterar");
	private final JButton btnExcluir = new JButton("Excluir");
	private final JButton btnSimulacaoEmPDF = new JButton("Simula\u00E7\u00E3o em PDF");
	private final JButton btnSimulacaoNaTela = new JButton("Simula\u00E7\u00E3o na tela");

	private JTextField tfHorario;
    private JComboBox cbAutomoveis = new JComboBox();
    private JTextField tfValorLocacao;
    private JTextField tfDataLocacao;
   
    private  JLabel lblValor = new JLabel("Valor");
	private  JLabel lblDataLocacao = new JLabel("Data da Loca\u00E7\u00E3o");

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocacaoView frame = new LocacaoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LocacaoView(){
	super("Manutenção do Cadastro de Locações");
	GerarFormulario();
	}
	
	private void verificaInputCPF(KeyEvent key){
		char sub = key.getKeyChar();		
		if(Character.isDigit(sub) == false){
			key.consume();		
		}
			if(tfCPF.getText().length() >= 11){
				key.consume();			
			}
		
	}
	
	private void verificaInputCodigoAutomovel(KeyEvent key){
		char sub = key.getKeyChar();		
		if(Character.isDigit(sub) == false){
			key.consume();		
		}
		
	}


	/**
	 * Create the frame.
	 */
	public void GerarFormulario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIDAutomovel = new JLabel("C\u00F3digo do Autom\u00F3vel");
		lblIDAutomovel.setBounds(24, 93, 122, 14);
		contentPane.add(lblIDAutomovel);
		
		tfIDAutomovel = new JTextField();
		tfIDAutomovel.setBounds(160, 90, 111, 20);
		contentPane.add(tfIDAutomovel);
		tfIDAutomovel.setColumns(10);
		
		tfIDAutomovel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputCodigoAutomovel(tecla);
			}
		});
		
		JLabel lblCPFCliente = new JLabel("CPF do Cliente");
		lblCPFCliente.setBounds(24, 151, 122, 14);
		contentPane.add(lblCPFCliente);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(164, 148, 262, 20);
		contentPane.add(tfCPF);
		
		tfCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputCPF(tecla);
			}
		});
	
		JLabel lblDataDevolucao = new JLabel("Data de Devolu\u00E7\u00E3o");
		lblDataDevolucao.setBounds(24, 201, 122, 14);
		contentPane.add(lblDataDevolucao);
		
		tfDataDevolucao = new JTextField();
		tfDataDevolucao.setColumns(10);
		tfDataDevolucao.setBounds(164, 198, 166, 20);
		contentPane.add(tfDataDevolucao);
		
		cbAutomoveis.setBounds(24, 29, 715, 20);
		contentPane.add(cbAutomoveis);
		separator.setBounds(0, 253, 804, 7);
		contentPane.add(separator);
		
		JLabel lblMenu = new JLabel("Menu de Sele\u00E7\u00E3o");
		lblMenu.setBounds(24, 253, 135, 14);
		contentPane.add(lblMenu);
		
		rbCadastrar.setBounds(71, 306, 109, 23);
		contentPane.add(rbCadastrar);
		
		rbAlterar.setBounds(252, 306, 93, 23);
		contentPane.add(rbAlterar);
		
		rbExcluir.setBounds(423, 306, 93, 23);
		contentPane.add(rbExcluir);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 384, 804, 7);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 477, 804, 7);
		contentPane.add(separator_3);
		
		JLabel lblControle = new JLabel("Controle da Loca\u00E7\u00E3o");
		lblControle.setBounds(24, 384, 135, 14);
		contentPane.add(lblControle);
		
		btnEfetuar.setBounds(371, 402, 103, 23);
		contentPane.add(btnEfetuar);
		
		btnConsultar.setBounds(371, 443, 103, 23);
		contentPane.add(btnConsultar);
		
		btnAlterar.setBounds(576, 402, 93, 23);
		contentPane.add(btnAlterar);
		
		btnExcluir.setBounds(576, 443, 93, 23);
		contentPane.add(btnExcluir);
		
		tfDataAtual = new JTextField();
		tfDataAtual.setBounds(195, 519, 135, 20);
		contentPane.add(tfDataAtual);
		tfDataAtual.setColumns(10);
		
		JLabel lblDataHora = new JLabel("Data e Hora atuais");
		lblDataHora.setBounds(24, 477, 135, 14);
		contentPane.add(lblDataHora);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 75, 804, 7);
		contentPane.add(separator_4);
	
	
		ButtonGroup GrupoRB = new ButtonGroup(); 
		GrupoRB.add(rbCadastrar);
		GrupoRB.add(rbAlterar);
		GrupoRB.add(rbExcluir);
		
		btnEfetuar.setEnabled(false);
		btnConsultar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		
		btnSimulacaoEmPDF.setEnabled(false);
		btnSimulacaoEmPDF.setBounds(566, 271, 157, 23);
		contentPane.add(btnSimulacaoEmPDF);
		
		tfHorario = new JTextField();
		tfHorario.setBounds(371, 519, 145, 20);
		contentPane.add(tfHorario);
		tfHorario.setColumns(10);
		
		
		
		lblValor.setBounds(498, 154, 67, 14);
		contentPane.add(lblValor);
		lblValor.setVisible(false);
		
		tfValorLocacao = new JTextField();
		tfValorLocacao.setBounds(607, 148, 93, 20);
		contentPane.add(tfValorLocacao);
		tfValorLocacao.setColumns(10);
		tfValorLocacao.setVisible(false);
		
		
		lblDataLocacao.setBounds(486, 201, 135, 14);
		contentPane.add(lblDataLocacao);
		lblDataLocacao.setVisible(false);
		
		tfDataLocacao = new JTextField();
		tfDataLocacao.setColumns(10);
		tfDataLocacao.setBounds(607, 198, 167, 20);
		contentPane.add(tfDataLocacao);
		btnSimulacaoNaTela.setEnabled(false);
		btnSimulacaoNaTela.setBounds(566, 344, 157, 23);
		
		contentPane.add(btnSimulacaoNaTela);
		tfDataLocacao.setVisible(false);
		
		

		atualizaCBAutomovel();
        limpaCampo();
		desabilitaCampos();
		
	
		     
		ActionListener rbCadastrarListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpaCampo();
				habilitaCampos();
				desabilitaCamposExtras();
				btnEfetuar.setEnabled(false);
			//	btnEfetuar.setEnabled(true); //tirar depois

				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnConsultar.setEnabled(false);
				btnSimulacaoEmPDF.setEnabled(true);
				btnSimulacaoNaTela.setEnabled(true);

			   }
		        };
		           
		        

				ActionListener rbAlterarListener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						desabilitaCampos();
						limpaCampo();
						desabilitaCamposExtras();
						tfCPF.setEnabled(true);
						tfIDAutomovel.setEnabled(true);
						btnEfetuar.setEnabled(false);
						btnAlterar.setEnabled(false);
						btnExcluir.setEnabled(false);
						btnConsultar.setEnabled(true);
						btnSimulacaoEmPDF.setEnabled(false);
						btnSimulacaoNaTela.setEnabled(false);

					   }
				       };
				       
				ActionListener rbExcluirListener = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				desabilitaCampos();
				limpaCampo();
				desabilitaCamposExtras();
				tfCPF.setEnabled(true);
				tfIDAutomovel.setEnabled(true);
				btnEfetuar.setEnabled(false);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnConsultar.setEnabled(true);
				btnSimulacaoEmPDF.setEnabled(false);
				btnSimulacaoNaTela.setEnabled(false);

				}

				};
						
			rbCadastrar.addActionListener(rbCadastrarListener);
			rbAlterar.addActionListener(rbAlterarListener);
			rbExcluir.addActionListener(rbExcluirListener);	
			
			
			btnEfetuar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			inserir();
			}
			});
			
			btnConsultar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				consultar();
				}
				});
			
			

			 btnAlterar.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent arg0) {
		         alterar();
				 }
				 });
			 
			 
			 btnExcluir.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent arg0) {
		         excluir();
				 }
				 });
			
	
	            btnSimulacaoEmPDF.addActionListener(new ActionListener(){
	        	 public void actionPerformed(ActionEvent arg0) {
                 simulacaoEmPDF();
                 btnEfetuar.setEnabled(true);
	        	 }
	        	 
	        	 
	        
	 });
	            
	            btnSimulacaoNaTela.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
					simulacaoNaTela();
	                btnEfetuar.setEnabled(true);

						
					}
				});
	}

	
	
	

	public void atualizaCBAutomovel(){

		final AutomovelDao dao =new AutomovelDaoImplementation();

		List<Automovel> listaAutomovel = new ArrayList<Automovel>();

		try {
			listaAutomovel=dao.pesquisarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(cbAutomoveis!=null){

			cbAutomoveis.removeAllItems();
		}


		for (Automovel automovel:listaAutomovel){
			cbAutomoveis.addItem("ID: "+automovel.getCodigo()+" Nome:"+automovel.getNome()+" Modelo:"+automovel.getModelo());
			}
	}
	
	public void limpaCampo(){
	tfIDAutomovel.setText("0");
	tfCPF.setText("");
	tfDataAtual.setText("");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");   
	Calendar c = Calendar.getInstance(); 
	c.add(Calendar.DAY_OF_MONTH,0);  
	tfDataAtual.setText(sdf.format(c.getTime()));
	tfDataDevolucao.setText("");
	
	
	SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
	tfHorario.setText(sdfHora.format(c.getTimeInMillis()));
	tfValorLocacao.setText("");
	tfDataLocacao.setText("");
	}
	
	
	public void desabilitaCampos(){
	tfIDAutomovel.setEnabled(false);
	tfCPF.setEnabled(false);
	tfDataAtual.setEnabled(false);
	tfDataDevolucao.setEnabled(false);
	tfHorario.setEnabled(false);
    tfValorLocacao.setEnabled(false);
    tfDataLocacao.setEnabled(false);
	}
	
	public void habilitaCampos(){
	tfIDAutomovel.setEnabled(true);
	tfCPF.setEnabled(true);
	tfDataDevolucao.setEnabled(true);
	}
	
	
	public void inserir(){
	Locacao locacao=new Locacao();
	if(!tfIDAutomovel.getText().isEmpty() && !tfCPF.getText().isEmpty() &&
	!tfDataAtual.getText().isEmpty() && !tfDataDevolucao.getText().isEmpty()){
	locacao.setCodigo_automovel(Integer.parseInt(tfIDAutomovel.getText()));
	locacao.setCpf_cliente(tfCPF.getText());
	
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    
    try{
    locacao.setData_locacao(sdf.parse(tfDataAtual.getText()));
    locacao.setData_devolucao(sdf.parse(tfDataDevolucao.getText()));
    }
    catch(ParseException e){
    JOptionPane.showMessageDialog(null, "Data inválida","Atenção",JOptionPane.CANCEL_OPTION);
    e.printStackTrace();
    }
    
    LocacaoDao dao=new LocacaoDaoImplementation();
    
    boolean inserido = dao.inserir(locacao);
    
    if(inserido){
    Locacao consulta=new Locacao();
    consulta = dao.pesquisar(locacao.getCodigo_automovel(), locacao.getCpf_cliente());
    JOptionPane.showMessageDialog(null,"Locação inserida com sucesso, com o valor de: R$ "+consulta.getValor_Total(),"Êxito",JOptionPane.INFORMATION_MESSAGE);
    limpaCampo();
    habilitaCampos();
    btnEfetuar.setEnabled(false);
    }
    else{
    JOptionPane.showMessageDialog(null,"Locação não inserida","Atenção",JOptionPane.CANCEL_OPTION);
    }
    }
	
	else{
	JOptionPane.showMessageDialog(null, "Algum dos campos não foi informado, verifique-os","Atenção",JOptionPane.CANCEL_OPTION);
	}
	}
	
	public void consultar(){
	
	Locacao locacao=new Locacao();
	Locacao consulta=new Locacao();
	
    if(tfIDAutomovel.getText().isEmpty() || tfCPF.getText().isEmpty()){
    	JOptionPane.showMessageDialog(null,"Por favor insira o código do automóvel e o CPF do usuário","Atenção",JOptionPane.CANCEL_OPTION);
      }
    else{
   
    habilitaCamposExtras();
    locacao.setCodigo_automovel(Integer.parseInt(tfIDAutomovel.getText()));
    locacao.setCpf_cliente(tfCPF.getText());
    LocacaoDao dao=new LocacaoDaoImplementation();
    consulta=dao.pesquisar(locacao.getCodigo_automovel(), locacao.getCpf_cliente());
    
    if(consulta.getCodigo_automovel()>=1){
    
    tfIDAutomovel.setText(String.valueOf(consulta.getCodigo_automovel()));
    tfCPF.setText(consulta.getCpf_cliente());
    
    if(tfDataLocacao.getText()!=null){
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    tfDataLocacao.setText(sdf.format(consulta.getData_locacao()));
    tfDataDevolucao.setText(sdf.format(consulta.getData_devolucao()));
    }
    

    tfValorLocacao.setText("R$ "+String.valueOf(consulta.getValor_Total()));
 
    if(consulta.getCpf_cliente()!=null && rbAlterar.isSelected()){
    	  btnAlterar.setEnabled(true);
    	  habilitaCampos();
    	 tfCPF.setEnabled(false);
  		tfIDAutomovel.setEnabled(false);
          }
    	  else
    	  if(consulta.getCpf_cliente()!=null && rbExcluir.isSelected()){
    	  btnExcluir.setEnabled(true);
    	  desabilitaCampos();
    	  }
    	 
    }
     
    else{
   		  JOptionPane.showMessageDialog(null, "Dados não localizados", "Atenção",JOptionPane.CANCEL_OPTION);
   		  btnAlterar.setEnabled(false);
   		  btnExcluir.setEnabled(false);
   	  }
    }
    
    }
	
	public void alterar(){
		Locacao locacao=new Locacao();
		if(!tfIDAutomovel.getText().isEmpty() && !tfCPF.getText().isEmpty() &&
		!tfDataAtual.getText().isEmpty() && !tfDataDevolucao.getText().isEmpty()){
		locacao.setCodigo_automovel(Integer.parseInt(tfIDAutomovel.getText()));
		locacao.setCpf_cliente(tfCPF.getText());
		
	    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	    
	    try{
	    locacao.setData_locacao(sdf.parse(tfDataAtual.getText()));
	    locacao.setData_devolucao(sdf.parse(tfDataDevolucao.getText()));
	    }
	    catch(ParseException e){
	    JOptionPane.showMessageDialog(null, "Data inválida","Atenção",JOptionPane.CANCEL_OPTION);
	    e.printStackTrace();
	    }
	    
	    LocacaoDao dao=new LocacaoDaoImplementation();
	    
	    boolean atualizado = dao.atualizar(locacao);
	    
	    if(atualizado){
	    Locacao consulta=new Locacao();
	    consulta = dao.pesquisar(locacao.getCodigo_automovel(), locacao.getCpf_cliente());
	    JOptionPane.showMessageDialog(null,"Locação atualizada com sucesso, com o novo valor calculado de: R$ "+consulta.getValor_Total(),"Êxito",JOptionPane.INFORMATION_MESSAGE);
	    limpaCampo();
	    desabilitaCampos();
	    tfCPF.setEnabled(true);
	    tfIDAutomovel.setEnabled(true);
	    }
	    else{
	    JOptionPane.showMessageDialog(null,"Locação não atualizada","Atenção",JOptionPane.CANCEL_OPTION);
	    }
	    }
		
		else{
		JOptionPane.showMessageDialog(null, "Algum dos campos não foi informado, verifique-os","Atenção",JOptionPane.CANCEL_OPTION);
		}
		}
	
	
	public void excluir(){
	Locacao locacao=new Locacao();
	if(!tfIDAutomovel.getText().isEmpty() && !tfCPF.getText().isEmpty()){
	locacao.setCodigo_automovel(Integer.parseInt(tfIDAutomovel.getText()));
	locacao.setCpf_cliente(tfCPF.getText());
	
	LocacaoDao dao=new LocacaoDaoImplementation();
	boolean excluido=dao.remover(locacao.getCodigo_automovel(), locacao.getCpf_cliente());
	

    if(excluido){
    JOptionPane.showMessageDialog(null, "Locação excluída com sucesso","Êxito", JOptionPane.INFORMATION_MESSAGE);
    desabilitaCampos();
    limpaCampo();
    tfCPF.setEnabled(true);
    tfIDAutomovel.setEnabled(true);
    btnExcluir.setEnabled(false);
    }
    else{
    JOptionPane.showMessageDialog(null, "Locação não excluída", "Atenção",JOptionPane.CANCEL_OPTION);
    }
    }
    }
	
	
	
	public void habilitaCamposExtras(){
	tfValorLocacao.setVisible(true);
	tfDataLocacao.setVisible(true);
	lblDataLocacao.setVisible(true);
	lblValor.setVisible(true);
	}
	
	public void desabilitaCamposExtras(){
		tfValorLocacao.setVisible(false);
		tfDataLocacao.setVisible(false);
		lblDataLocacao.setVisible(false);
		lblValor.setVisible(false);
		}
	
	
	public void simulacaoEmPDF(){
			Simulacao simulacao=new Simulacao();
			
			
			if(!tfIDAutomovel.getText().isEmpty() && !tfCPF.getText().isEmpty() &&
			!tfDataAtual.getText().isEmpty() && !tfDataDevolucao.getText().isEmpty()){
			simulacao.setCodigo_automovel(Integer.parseInt(tfIDAutomovel.getText()));
			simulacao.setCpf_cliente(tfCPF.getText());
			
		    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		    
		    try{
		    simulacao.setData_locacao(sdf.parse(tfDataAtual.getText()));
		    simulacao.setData_devolucao(sdf.parse(tfDataDevolucao.getText()));
		    }
		    catch(ParseException e){
		    JOptionPane.showMessageDialog(null, "Data inválida","Atenção",JOptionPane.CANCEL_OPTION);
		    e.printStackTrace();
		    }
		    
			SimulacaoDaoImplementation dao=new SimulacaoDaoImplementation();
		    
		    boolean inserido = dao.inserir(simulacao);
		    
		    if(inserido){
            desabilitaCampos();
            
		    }
		    else{
		    JOptionPane.showMessageDialog(null,"Simulação não inserida","Atenção",JOptionPane.CANCEL_OPTION);
		    }
		    }
			
			else{
			JOptionPane.showMessageDialog(null, "Algum dos campos não foi informado, verifique-os","Atenção",JOptionPane.CANCEL_OPTION);
			}
			}
	
	
	            public void simulacaoNaTela(){
	        	Simulacao simulacao=new Simulacao();
				
				
				if(!tfIDAutomovel.getText().isEmpty() && !tfCPF.getText().isEmpty() &&
				!tfDataAtual.getText().isEmpty() && !tfDataDevolucao.getText().isEmpty()){
				simulacao.setCodigo_automovel(Integer.parseInt(tfIDAutomovel.getText()));
				simulacao.setCpf_cliente(tfCPF.getText());
				
			    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			    
			    try{
			    simulacao.setData_locacao(sdf.parse(tfDataAtual.getText()));
			    simulacao.setData_devolucao(sdf.parse(tfDataDevolucao.getText()));
			    }
			    catch(ParseException e){
			    JOptionPane.showMessageDialog(null, "Data inválida","Atenção",JOptionPane.CANCEL_OPTION);
			    e.printStackTrace();
			    }
			    
				SimulacaoDaoImplementation dao=new SimulacaoDaoImplementation();
			    
			    boolean inserido = dao.inserirProjetaTela(simulacao);
			    
			    if(inserido){
	            desabilitaCampos();
	      
	            SimulacaoView s=new SimulacaoView();
	            new SimulacaoView().setVisible(true);
	            
			    dao.remover(simulacao.getCodigo_automovel(), simulacao.getCpf_cliente());
			    }
			    
			    else{
			    JOptionPane.showMessageDialog(null,"Simulação não inserida","Atenção",JOptionPane.CANCEL_OPTION);
			    }
			    }
				
				else{
				JOptionPane.showMessageDialog(null, "Algum dos campos não foi informado, verifique-os","Atenção",JOptionPane.CANCEL_OPTION);
				}
				}
		
	        
	}

