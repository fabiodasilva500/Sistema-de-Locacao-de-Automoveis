package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

import Controller.ControllerCliente;
import Dao.ClienteDao;
import Dao.ClienteDaoImplementation;
import Entidades.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClienteView extends JFrame implements ControllerCliente {

	private JPanel contentPane;
	private JTextField tfCPF;
	private JTextField tfNome;
	private JTextField tfCNH;
	private JTextField tfEndereco;
	private JTextField tfTelefone;
	private JTextField tfDataDeNascimento;
	private final JRadioButton rbCadastrar = new JRadioButton("Cadastrar");
	private final JRadioButton rbAlterar = new JRadioButton("Alterar");
	private final JRadioButton rbExcluir = new JRadioButton("Excluir");
	private final JButton btnInserir = new JButton("Inserir");
	private final JButton btnAlterar = new JButton("Alterar");
	private final JButton btnExcluir = new JButton("Excluir");
	private final JButton btnPesquisar = new JButton("Pesquisar");


	private void verificaInputCPF(KeyEvent key){
		char sub = key.getKeyChar();		
		if(Character.isDigit(sub) == false){
			key.consume();		
		}
			if(tfCPF.getText().length() >= 11){
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

	
	private void verificaInputCNH(KeyEvent key){		
		if(tfNome.getText().length() >= 30){
			key.consume();			
		}
	}

	private void verificaInputEndereco(KeyEvent key){
		if(tfEndereco.getText().length() >= 100){
			key.consume();			
		}
	}
	
	private void verificaInputTelefone(KeyEvent key){
		char sub = key.getKeyChar();		
		if(Character.isDigit(sub) == false){
			key.consume();		
		}
			if(tfTelefone.getText().length() >= 12){
				key.consume();			
			  }
		
	}
	
	
	private void verificaInputDataNasc(KeyEvent key){
		char sub = key.getKeyChar();		
			if(tfDataDeNascimento.getText().length() >= 10){
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
					ClienteView frame = new ClienteView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public ClienteView(){
	super("Manutenção do Cadastro de Clientes");
	GerarFormulario();
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 794, 562);
		contentPane.add(panel);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(22, 34, 46, 14);
		panel.add(lblCpf);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(92, 31, 282, 20);
		panel.add(tfCPF);
		tfCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputCPF(tecla);
			}
		});
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(22, 83, 46, 14);
		panel.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(92, 80, 531, 20);
		panel.add(tfNome);
		tfNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputNome(tecla);
			}
		});
		
		JLabel lblCNH = new JLabel("CNH");
		lblCNH.setBounds(22, 135, 46, 14);
		panel.add(lblCNH);
		
		tfCNH = new JTextField();
		tfCNH.setColumns(10);
		tfCNH.setBounds(92, 132, 337, 20);
		panel.add(tfCNH);
		
		tfCNH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputCNH(tecla);
			}
		});
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(22, 199, 60, 14);
		panel.add(lblEndereco);
		
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(92, 193, 531, 20);
		panel.add(tfEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(22, 250, 60, 14);
		panel.add(lblTelefone);
		
		tfEndereco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputEndereco(tecla);
			}
		});
		
		tfTelefone = new JTextField();
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(92, 247, 163, 20);
		panel.add(tfTelefone);
		
		tfTelefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputTelefone(tecla);
			}
		});
		
		rbCadastrar.setBounds(146, 362, 109, 23);
		panel.add(rbCadastrar);
		
		rbAlterar.setBounds(331, 362, 93, 23);
		panel.add(rbAlterar);
		
		rbExcluir.setBounds(530, 362, 93, 23);
		panel.add(rbExcluir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 290, 784, 14);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 450, 784, 14);
		panel.add(separator_1);
		
		btnInserir.setBounds(96, 500, 89, 23);
		panel.add(btnInserir);
		
		btnAlterar.setBounds(409, 500, 89, 23);
		panel.add(btnAlterar);
		
		btnExcluir.setBounds(571, 500, 89, 23);
		panel.add(btnExcluir);
		
		btnPesquisar.setBounds(260, 500, 93, 23);
		panel.add(btnPesquisar);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(304, 250, 130, 14);
		panel.add(lblDataDeNascimento);
		
		tfDataDeNascimento = new JTextField();
		tfDataDeNascimento.setColumns(10);
		tfDataDeNascimento.setBounds(438, 247, 163, 20);
		panel.add(tfDataDeNascimento);
		
		tfDataDeNascimento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tecla) {
				verificaInputDataNasc(tecla);
			}
		});
		
		JLabel lblSelecao = new JLabel("Menu de Sele\u00E7\u00E3o");
		lblSelecao.setBounds(22, 290, 100, 14);
		panel.add(lblSelecao);
        limpaCampo();
        desabilitaCampos();
        
    	ButtonGroup GrupoRB = new ButtonGroup(); 
		GrupoRB.add(rbCadastrar);
		GrupoRB.add(rbAlterar);
		GrupoRB.add(rbExcluir);
		
		btnInserir.setEnabled(false);
		btnPesquisar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
        
    	ActionListener rbCadastrarListener = new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			limpaCampo();
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
    			tfCPF.setEnabled(true);
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
                tfCPF.setEnabled(true);
                
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
	Cliente cliente=new Cliente();
	if(!tfCPF.getText().isEmpty() && !tfNome.getText().isEmpty() &&
	!tfEndereco.getText().isEmpty() && !tfTelefone.getText().isEmpty()&&
	!tfDataDeNascimento.getText().isEmpty() && !tfCNH.getText().isEmpty()){
	
    cliente.setCpf(tfCPF.getText());
    cliente.setNome(tfNome.getText());
    cliente.setCnh(tfCNH.getText());
    cliente.setEndereco(tfEndereco.getText());
    cliente.setTelefone(tfTelefone.getText());
    
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    
    try{
    cliente.setData_nascimento(sdf.parse(tfDataDeNascimento.getText()));
    }
    catch(ParseException e){
    JOptionPane.showMessageDialog(null, "Data inválida","Atenção",JOptionPane.CANCEL_OPTION);
    e.printStackTrace();
    }
    
    ClienteDao dao=new ClienteDaoImplementation();
    if(tfCPF.getText().length()<=10){
    JOptionPane.showMessageDialog(null,"CPF inválido, digite um CPF com 11 caracteres", "Atenção",JOptionPane.CANCEL_OPTION);
     }
        else{
    boolean inserido = dao.inserir(cliente);
    
    if(inserido){
    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso","Êxito",JOptionPane.INFORMATION_MESSAGE);
    desabilitaCampos();
    limpaCampo();
    }
    else{
    JOptionPane.showMessageDialog(null, "Cliente não cadastrado", "Atenção",JOptionPane.CANCEL_OPTION);
    }
    }
	}
	}

    public void pesquisar(){
    Cliente cliente=new Cliente();
    Cliente consulta=new Cliente();
    
    if(tfCPF.getText().isEmpty()){
    JOptionPane.showMessageDialog(null, "CPF não informado, por favor digite um CPF válido", "Atenção", JOptionPane.CANCEL_OPTION);
    }
    else{
    cliente.setCpf(tfCPF.getText());
    ClienteDao dao=new ClienteDaoImplementation();
    consulta=dao.pesquisar(cliente.getCpf());
    
    tfCPF.setText(consulta.getCpf());
    tfNome.setText(consulta.getNome());
    tfCNH.setText(consulta.getCnh());
    tfEndereco.setText(consulta.getEndereco());
    tfTelefone.setText(consulta.getTelefone());
    
    if(tfDataDeNascimento.getText()!=null){
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    tfDataDeNascimento.setText(sdf.format(consulta.getData_nascimento()));
    }
    
    if(tfCPF.getText().length()<=10){
    JOptionPane.showMessageDialog(null,"CPF inválido, digite um CPF com 11 caracteres", "Atenção",JOptionPane.CANCEL_OPTION);
    }
    else{
    if(consulta.getCpf()!=null && rbAlterar.isSelected()){
    btnAlterar.setEnabled(true);
    habilitaCampos();
    tfCPF.setEnabled(false);

    }
    else
    if(consulta.getCpf()!=null && rbExcluir.isSelected()){
    btnExcluir.setEnabled(true);
    desabilitaCampos();
    tfCPF.setEnabled(false);
    }
    else{
    
    JOptionPane.showMessageDialog(null,"Cliente não localizado", "Atenção",JOptionPane.CANCEL_OPTION);
    desabilitaCampos();
    tfCPF.setEnabled(true);
    tfDataDeNascimento.setText("");
    }
  
    }
    }
    }
    
    public void alterar(){
    	Cliente cliente=new Cliente();
    	if (!tfNome.getText().isEmpty() && !tfEndereco.getText().isEmpty() && !tfTelefone.getText().isEmpty()&&
    	!tfDataDeNascimento.getText().isEmpty() && !tfCNH.getText().isEmpty()){
    	
        cliente.setNome(tfNome.getText());
        cliente.setCnh(tfCNH.getText());
        cliente.setEndereco(tfEndereco.getText());
        cliente.setTelefone(tfTelefone.getText());
        
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        try{
        cliente.setData_nascimento(sdf.parse(tfDataDeNascimento.getText()));
        }
        catch(ParseException e){
        JOptionPane.showMessageDialog(null, "Data inválida","Atenção",JOptionPane.CANCEL_OPTION);
        e.printStackTrace();
        }
        
        cliente.setCpf(tfCPF.getText());

        ClienteDao dao=new ClienteDaoImplementation();
        
        boolean atualizado = dao.atualizar(cliente);
        
        if(atualizado){
        JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso","Êxito",JOptionPane.INFORMATION_MESSAGE);
        desabilitaCampos();
        limpaCampo();
        tfCPF.setEnabled(true);
        }
        else{
        JOptionPane.showMessageDialog(null, "Cliente não atualizado", "Atenção",JOptionPane.CANCEL_OPTION);
        }
        }
    	    
    }
    
    public void excluir(){
    Cliente cliente=new Cliente();
    if(!tfCPF.getText().isEmpty()){
    cliente.setCpf(tfCPF.getText());
    ClienteDao dao=new ClienteDaoImplementation();
    boolean excluido=dao.remover(cliente.getCpf());
    
    
    if(excluido){
    JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso","Êxito", JOptionPane.INFORMATION_MESSAGE);
    desabilitaCampos();
    limpaCampo();
    tfCPF.setEnabled(true);
    }
    else{
    JOptionPane.showMessageDialog(null, "Cliente não excluído", "Atenção",JOptionPane.CANCEL_OPTION);
    }
    }
    }
 	
	
	
	public void desabilitaCampos(){
	tfCPF.setEnabled(false);
	tfNome.setEnabled(false);
	tfEndereco.setEnabled(false);
	tfTelefone.setEnabled(false);
	tfDataDeNascimento.setEnabled(false);
	tfCNH.setEnabled(false);
	}
	
	public void habilitaCampos(){
		tfCPF.setEnabled(true);
		tfNome.setEnabled(true);
		tfEndereco.setEnabled(true);
		tfTelefone.setEnabled(true);
		tfDataDeNascimento.setEnabled(true);
		tfCNH.setEnabled(true);
		}
	
	
	public void limpaCampo(){
	tfCPF.setText("");
	tfNome.setText("");
	tfEndereco.setText("");
	tfTelefone.setText("");
	tfDataDeNascimento.setText("");
	tfCNH.setText("");
    }
	
	
}
