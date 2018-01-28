package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JButton;

import Controller.ControllerSimulacao;
import Dao.SimulacaoDaoImplementation;
import Entidades.Simulacao;

public class SimulacaoView extends JFrame implements ControllerSimulacao {

	private JPanel contentPane;
	private JTextField tfCPF;
	private JTextField tfCodigoAutomovel;
	private JLabel lblNomeCliente;
	private JTextField tfNomeCliente;
	private JLabel lblNomeAutomovel;
	private JTextField tfNomeAutomovel;
	private JTextField tfModelo;
	private JTextField tfCor;
	private JTextField tfAno;
	private JTextField tfMotor;
	private JTextField tfDataLocacao;
	private JTextField tfDataDevolucao;
	private JTextField tfValorTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulacaoView frame = new SimulacaoView();
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
	
	public SimulacaoView(){
	super("Consulta da Simulação da Locação");
    GerarFormulario();
    }
	

	public void GerarFormulario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 512, 804, 2);
		contentPane.add(separator);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(10, 36, 46, 14);
		contentPane.add(lblCPF);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(66, 33, 264, 20);
		contentPane.add(tfCPF);
		tfCPF.setColumns(10);
		
		JLabel lblIDAutomovel = new JLabel("C\u00F3digo do Autom\u00F3vel");
		lblIDAutomovel.setBounds(379, 36, 139, 14);
		contentPane.add(lblIDAutomovel);
		
		tfCodigoAutomovel = new JTextField();
		tfCodigoAutomovel.setColumns(10);
		tfCodigoAutomovel.setBounds(518, 33, 163, 20);
		contentPane.add(tfCodigoAutomovel);
		
		lblNomeCliente = new JLabel("Nome do Cliente");
		lblNomeCliente.setBounds(10, 102, 120, 14);
		contentPane.add(lblNomeCliente);
		
		tfNomeCliente = new JTextField();
		tfNomeCliente.setColumns(10);
		tfNomeCliente.setBounds(158, 99, 575, 20);
		contentPane.add(tfNomeCliente);
		
		lblNomeAutomovel = new JLabel("Nome do Autom\u00F3vel");
		lblNomeAutomovel.setBounds(10, 159, 138, 14);
		contentPane.add(lblNomeAutomovel);
		
		tfNomeAutomovel = new JTextField();
		tfNomeAutomovel.setColumns(10);
		tfNomeAutomovel.setBounds(158, 156, 575, 20);
		contentPane.add(tfNomeAutomovel);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 211, 72, 14);
		contentPane.add(lblModelo);
		
		tfModelo = new JTextField();
		tfModelo.setBounds(74, 208, 264, 20);
		contentPane.add(tfModelo);
		tfModelo.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(392, 211, 72, 14);
		contentPane.add(lblCor);
		
		tfCor = new JTextField();
		tfCor.setColumns(10);
		tfCor.setBounds(429, 208, 206, 20);
		contentPane.add(tfCor);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(10, 270, 72, 14);
		contentPane.add(lblAno);
		
		tfAno = new JTextField();
		tfAno.setColumns(10);
		tfAno.setBounds(74, 267, 72, 20);
		contentPane.add(tfAno);
		
		JLabel lblMotor = new JLabel("Motor");
		lblMotor.setBounds(197, 270, 72, 14);
		contentPane.add(lblMotor);
		
		tfMotor = new JTextField();
		tfMotor.setColumns(10);
		tfMotor.setBounds(266, 267, 211, 20);
		contentPane.add(tfMotor);
		
		JLabel lblDataLocacao = new JLabel("Data da Loca\u00E7\u00E3o");
		lblDataLocacao.setBounds(10, 330, 120, 14);
		contentPane.add(lblDataLocacao);
		
		tfDataLocacao = new JTextField();
		tfDataLocacao.setColumns(10);
		tfDataLocacao.setBounds(140, 327, 211, 20);
		contentPane.add(tfDataLocacao);
		
		JLabel lblDataDevolução = new JLabel("Data da Devolu\u00E7\u00E3o");
		lblDataDevolução.setBounds(10, 389, 120, 14);
		contentPane.add(lblDataDevolução);
		
		tfDataDevolucao = new JTextField();
		tfDataDevolucao.setColumns(10);
		tfDataDevolucao.setBounds(140, 386, 211, 20);
		contentPane.add(tfDataDevolucao);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setBounds(10, 451, 120, 14);
		contentPane.add(lblValorTotal);
		
		tfValorTotal = new JTextField();
		tfValorTotal.setColumns(10);
		tfValorTotal.setBounds(140, 448, 211, 20);
		contentPane.add(tfValorTotal);
	
	
	    desabilitaCampos();
	    consultaDados();
	
	}
	
	
	public void desabilitaCampos(){
		 tfCPF.setEnabled(false);
		 tfCodigoAutomovel.setEnabled(false);
		 tfNomeCliente.setEnabled(false);
		 tfNomeAutomovel.setEnabled(false);
		 tfModelo.setEnabled(false);
		 tfCor.setEnabled(false);
		 tfAno.setEnabled(false);
		 tfMotor.setEnabled(false);
		 tfDataLocacao.setEnabled(false);
		 tfDataDevolucao.setEnabled(false);
		 tfValorTotal.setEnabled(false);
	}
	
	public void consultaDados(){
		 SimulacaoDaoImplementation dao=new SimulacaoDaoImplementation();

		    Simulacao consulta=new Simulacao();
		    consulta=dao.pesquisar();
		    
		tfCPF.setText(consulta.getCpf_cliente());
		tfCodigoAutomovel.setText(String.valueOf(consulta.getCodigo_automovel()));
		tfNomeCliente.setText(consulta.getNome_cliente());
		tfNomeAutomovel.setText(consulta.getNome_automovel());
		tfModelo.setText(consulta.getModelo_automovel());
		tfCor.setText(consulta.getCor_automovel());
		tfAno.setText(String.valueOf(consulta.getAno_automovel()));
		tfMotor.setText(consulta.getMotor_automovel());
		
		if(consulta.getData_locacao()!=null){
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	    tfDataLocacao.setText(sdf.format(consulta.getData_locacao()));
	    tfDataDevolucao.setText(sdf.format(consulta.getData_devolucao()));
		}
	    tfValorTotal.setText("R$ "+String.valueOf(consulta.getValor_total()));
	 
   
    }
	
}

