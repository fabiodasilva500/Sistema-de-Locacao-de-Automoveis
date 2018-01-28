package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;

import Controller.ControllerAutomovel;
import Dao.AutomovelDao;
import Dao.AutomovelDaoImplementation;
import Entidades.Automovel;

public class AutomovelView extends JFrame implements ControllerAutomovel {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfMarca;
	private JTextField tfModelo;
	private JTextField tfCor;
	private JTextField tfAno;
	private JTextField tfMotor;
	private JTextField tfTipo;
    private final JRadioButton rbCadastrar = new JRadioButton("Cadastrar");
    private final JRadioButton rbAlterar = new JRadioButton("Alterar");
    private final JRadioButton rbExcluir = new JRadioButton("Excluir");
    private	final JButton btnInserir = new JButton("Inserir");
	private final JButton btnAlterar = new JButton("Alterar");
    private final JButton btnExcluir = new JButton("Excluir");
    private final JButton btnPesquisar = new JButton("Pesquisar");

    private void verificaInputCodigo(KeyEvent key){
		char sub = key.getKeyChar();		
		if(Character.isDigit(sub) == false){
			key.consume();		
		}
	}

	private void verificaInputNome(KeyEvent key){
		char sub = key.getKeyChar();		
		if(Character.isDigit(sub) == true){
			key.consume();			
		}
		if(tfNome.getText().length() >= 100){
			key.consume();			
		}
	}

	
	private void verificaInputMarca(KeyEvent key){		
		if(tfMarca.getText().length() >= 50){
			key.consume();			
		}
	}

	private void verificaInputModelo(KeyEvent key){
		if(tfModelo.getText().length() >= 100){
			key.consume();			
		}
	}
	
	private void verificaInputCor(KeyEvent key){
		if(tfCor.getText().length() >= 20){
			key.consume();			
		}
	}
	
	
	private void verificaInputAno(KeyEvent key){
		char sub = key.getKeyChar();		
		if(Character.isDigit(sub) == false){
			key.consume();		
		}
		
		if(tfAno.getText().length() >=4){
			key.consume();			
		}
	}
	
	
	
	private void verificaInputMotor(KeyEvent key){
		if(tfMotor.getText().length() >= 30){
			key.consume();			
		}
		}
	
	
	
	private void verificaInputTipo(KeyEvent key){
		char sub = key.getKeyChar();		
		if(Character.isDigit(sub) == false){
			key.consume();		
		}
		}
	
	
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutomovelView frame = new AutomovelView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public AutomovelView(){
	super("Manutenção do Cadastro de Automóveis");
    GerarFormulario();
	}
	
	public void GerarFormulario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(22, 34, 46, 14);
		contentPane.add(lblCdigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(92, 31, 93, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputCodigo(tecla);
			}
		});
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(22, 83, 46, 14);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(92, 80, 441, 20);
		contentPane.add(tfNome);
		
		tfNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputNome(tecla);
			}
		});
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(22, 135, 46, 14);
		contentPane.add(lblMarca);
		
		tfMarca = new JTextField();
		tfMarca.setColumns(10);
		tfMarca.setBounds(92, 132, 342, 20);
		contentPane.add(tfMarca);
		
		tfMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputMarca(tecla);
			}
		});
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(22, 199, 46, 14);
		contentPane.add(lblModelo);
		
		tfModelo = new JTextField();
		tfModelo.setColumns(10);
		tfModelo.setBounds(92, 193, 342, 20);
		contentPane.add(tfModelo);
		
		tfModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputModelo(tecla);
			}
		});
		
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(22, 250, 46, 14);
		contentPane.add(lblCor);
		
		tfCor = new JTextField();
		tfCor.setColumns(10);
		tfCor.setBounds(92, 247, 113, 20);
		contentPane.add(tfCor);
		
		tfCor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputCor(tecla);
			}
		});
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(552, 135, 46, 14);
		contentPane.add(lblAno);
		
		tfAno = new JTextField();
		tfAno.setBounds(624, 132, 86, 20);
		contentPane.add(tfAno);
		tfAno.setColumns(10);
		
		
		tfAno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputAno(tecla);
			}
		});
		
		
		JLabel lblMotor = new JLabel("Motor");
		lblMotor.setBounds(552, 199, 46, 14);
		contentPane.add(lblMotor);
		
		tfMotor = new JTextField();
		tfMotor.setColumns(10);
		tfMotor.setBounds(624, 196, 134, 20);
		contentPane.add(tfMotor);
		
		tfMotor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputMotor(tecla);
			}
		});
		
		
		JLabel lblCodigoTipo = new JLabel("C\u00F3digo do Tipo");
		lblCodigoTipo.setBounds(537, 250, 86, 14);
		contentPane.add(lblCodigoTipo);
		
		tfTipo = new JTextField();
		tfTipo.setColumns(10);
		tfTipo.setBounds(633, 247, 86, 20);
		contentPane.add(tfTipo);
		
		
		tfTipo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputTipo(tecla);
			}
		});
		
		
		rbCadastrar.setBounds(141, 381, 109, 23);
		contentPane.add(rbCadastrar);
		
		rbAlterar.setBounds(379, 381, 93, 23);
		contentPane.add(rbAlterar);
		
		rbExcluir.setBounds(593, 381, 93, 23);
		contentPane.add(rbExcluir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 347, 784, 14);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 440, 784, 14);
		contentPane.add(separator_1);
		
		btnInserir.setBounds(92, 516, 89, 23);
		contentPane.add(btnInserir);
		
		btnAlterar.setBounds(444, 516, 89, 23);
		contentPane.add(btnAlterar);
		
		btnExcluir.setBounds(621, 516, 89, 23);
		contentPane.add(btnExcluir);
		
		btnPesquisar.setBounds(238, 516, 109, 23);
		contentPane.add(btnPesquisar);
		
		
		ButtonGroup GrupoRB = new ButtonGroup(); 
		GrupoRB.add(rbCadastrar);
		GrupoRB.add(rbAlterar);
		GrupoRB.add(rbExcluir);
		
		btnInserir.setEnabled(false);
		btnPesquisar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		
		JLabel lblSeleciona = new JLabel("Menu de Sele\u00E7\u00E3o");
		lblSeleciona.setBounds(22, 347, 125, 14);
		contentPane.add(lblSeleciona);
		limpaCampo();
		desabilitaCampos();
		
	
	
	ActionListener rbCadastrarListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			limpaCampo();
			tfCodigo.setText("");
			habilitaCampos();
			btnInserir.setEnabled(true);
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnPesquisar.setEnabled(false);
			}
	        };
	
	
	ActionListener rbAlterarListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			limpaCampo();
			desabilitaCampos();
			tfCodigo.setEnabled(true);
			btnInserir.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnPesquisar.setEnabled(true);
		}
	};

	ActionListener rbExcluirListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			limpaCampo();
			desabilitaCampos();
			tfCodigo.setEnabled(true);
			
			btnInserir.setEnabled(false);
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnPesquisar.setEnabled(true);
		}
	};
	
	rbCadastrar.addActionListener(rbCadastrarListener);
	rbAlterar.addActionListener(rbAlterarListener);
	rbExcluir.addActionListener(rbExcluirListener);

	 btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
            inserir();
             }
		});
	 
	 
	 btnPesquisar.addActionListener(new ActionListener(){
	 
		 public void actionPerformed(ActionEvent arg0) {
         pesquisar();
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
	}
	
	
	
  public void inserir(){
  Automovel automovel=new Automovel();
  if(!tfNome.getText().isEmpty() && !tfMarca.getText().isEmpty() && !tfModelo.getText().isEmpty() &&
   !tfMotor.getText().isEmpty() && !tfAno.getText().isEmpty() && !tfCor.getText().isEmpty()&&
   !tfTipo.getText().isEmpty()){
	
  automovel.setNome(tfNome.getText());
  automovel.setMarca(tfMarca.getText());
  automovel.setModelo(tfModelo.getText());
  automovel.setCor(tfCor.getText());
  automovel.setAno(Integer.parseInt(tfAno.getText()));
  automovel.setMotor(tfMotor.getText());
  automovel.setCodigo_tipo(Integer.parseInt(tfTipo.getText()));
  
 
  AutomovelDao dao=new AutomovelDaoImplementation();
  boolean inserido = dao.inserir(automovel);
  
  if(inserido){
  JOptionPane.showMessageDialog(null,"Automóvel inserido com sucesso","Êxito",JOptionPane.INFORMATION_MESSAGE);
  limpaCampo();
  }
  else{
  JOptionPane.showMessageDialog(null,"Automóvel não inserido, por favor verifique os campos informados","Atenção", JOptionPane.CANCEL_OPTION);
  }
  }
  else{
 JOptionPane.showMessageDialog(null,"Automóvel não inserido, há campos vázios","Atenção", JOptionPane.CANCEL_OPTION);
  }
  }

  public void pesquisar(){    
  Automovel automovel=new Automovel();
  Automovel consulta=new Automovel();
  
  if(tfCodigo.getText().isEmpty()){
  JOptionPane.showMessageDialog(null,"Por favor insira o código do usuário","Atenção",JOptionPane.CANCEL_OPTION);
  }
  else{
  automovel.setCodigo(Integer.parseInt(tfCodigo.getText()));
  
  AutomovelDao dao=new AutomovelDaoImplementation();
  consulta =dao.pesquisarPorId(automovel.getCodigo());
  
  tfCodigo.setText(String.valueOf(consulta.getCodigo()));
  tfNome.setText(consulta.getNome());
  tfMarca.setText(consulta.getMarca());
  tfModelo.setText(consulta.getModelo());
  tfCor.setText(consulta.getCor());
  tfAno.setText(String.valueOf(consulta.getAno()));
  tfMotor.setText(consulta.getMotor());
  tfTipo.setText(String.valueOf(consulta.getCodigo_tipo()));
 
  if(consulta.getCodigo()>=1 && rbAlterar.isSelected()){
  btnAlterar.setEnabled(true);
  habilitaCampos();
  }
  else
  if(consulta.getCodigo()>=1 && rbExcluir.isSelected()){
  btnExcluir.setEnabled(true);
  desabilitaCampos();
  tfCodigo.setEnabled(false);
  }
  else{
  JOptionPane.showMessageDialog(null, "Dados não localizados", "Atenção",JOptionPane.CANCEL_OPTION);
  btnAlterar.setEnabled(false);
  btnExcluir.setEnabled(false);
  }
  }
  }
  
  
  public void alterar(){
	  Automovel automovel=new Automovel();
	  if(!tfNome.getText().isEmpty() && !tfMarca.getText().isEmpty() && !tfModelo.getText().isEmpty() &&
	   !tfMotor.getText().isEmpty() && !tfAno.getText().isEmpty() && !tfCor.getText().isEmpty()&&
	   !tfTipo.getText().isEmpty()){
		
	  automovel.setNome(tfNome.getText());
	  automovel.setMarca(tfMarca.getText());
	  automovel.setModelo(tfModelo.getText());
	  automovel.setCor(tfCor.getText());
	  automovel.setAno(Integer.parseInt(tfAno.getText()));
	  automovel.setMotor(tfMotor.getText());
	  automovel.setCodigo_tipo(Integer.parseInt(tfTipo.getText()));
	  automovel.setCodigo(Integer.parseInt(tfCodigo.getText()));
	  
	  System.out.println(automovel.getNome());
	  AutomovelDao dao=new AutomovelDaoImplementation();
	
	  boolean atualizado = dao.atualizar(automovel);
	  
	  if(atualizado){
	  JOptionPane.showMessageDialog(null,"Automóvel atualizado com sucesso","Êxito",JOptionPane.INFORMATION_MESSAGE);
	  limpaCampo();
	  desabilitaCampos();
	  tfCodigo.setEnabled(true);
	  }
	  else{
	  JOptionPane.showMessageDialog(null,"Automóvel não atualizado, verifique os campos informados","Atenção", JOptionPane.CANCEL_OPTION);
	  }
	  }
	  else{
	  JOptionPane.showMessageDialog(null,"Automóvel não atualizado, há campos vázios","Atenção", JOptionPane.CANCEL_OPTION);
	   }
  }
  
  
  public void excluir(){
  Automovel automovel=new Automovel();
  if(!tfCodigo.getText().isEmpty()){
  automovel.setCodigo(Integer.parseInt(tfCodigo.getText()));
  AutomovelDao dao=new AutomovelDaoImplementation();
  boolean excluido=dao.remover(automovel.getCodigo());
  if(excluido){
  JOptionPane.showMessageDialog(null,"Automóvel excluído com sucesso", "Êxito", JOptionPane.INFORMATION_MESSAGE);
  limpaCampo();
  
  }
  else{
  JOptionPane.showMessageDialog(null,"Automóvel não excluído", "Atenção",JOptionPane.CANCEL_OPTION);
  }
  }
  }
  
  
  public void limpaCampo(){
  tfCodigo.setText("0");
  tfNome.setText("");
  tfMarca.setText("");
  tfModelo.setText("");
  tfCor.setText("");
  tfAno.setText("2013");
  tfMotor.setText("");
  tfTipo.setText("1");
  }
  
  
  public void desabilitaCampos(){
  tfCodigo.setEnabled(false);
  tfNome.setEnabled(false);;
  tfMarca.setEnabled(false);
  tfModelo.setEnabled(false);
  tfCor.setEnabled(false);
  tfAno.setEnabled(false);
  tfMotor.setEnabled(false);
  tfTipo.setEnabled(false);
  }
  
  public void habilitaCampos(){
  tfCodigo.setEnabled(false);
  tfNome.setEnabled(true);;
  tfMarca.setEnabled(true);
  tfModelo.setEnabled(true);
  tfCor.setEnabled(true);
  tfAno.setEnabled(true);
  tfMotor.setEnabled(true);
  tfTipo.setEnabled(true);
  }
}
  
  


