package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;



public class MenuView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
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
	public MenuView() {
		super("Menu Principal");
	
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setLocation(275, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1000, 21);
		contentPane.add(menuBar);

		JMenuItem menuCliente = new JMenuItem("Cliente");
		menuBar.add(menuCliente);


		JMenuItem menuAutomóvel = new JMenuItem("Automóvel");
		menuBar.add(menuAutomóvel);


		JMenuItem menuLocacao = new JMenuItem("Locação");
		menuBar.add(menuLocacao);
		
		JLabel lblPlanoDeFundo = new JLabel("");
		lblPlanoDeFundo.setIcon(new ImageIcon(MenuView.class
				.getResource("planoDeFundo.jpg")));
		lblPlanoDeFundo.setBounds(0, 76, 868, 507);
		contentPane.add(lblPlanoDeFundo);
		
		JLabel lblSistemaDeLocao = new JLabel("Sistema de Loca\u00E7\u00E3o de Autom\u00F3veis");
		lblSistemaDeLocao.setForeground(Color.BLUE);
		lblSistemaDeLocao.setFont(new Font("Arial", Font.PLAIN, 25));
		lblSistemaDeLocao.setBounds(177, 32, 472, 33);
		contentPane.add(lblSistemaDeLocao);
		
		JLabel label = new JLabel("Biblioteca Prof\u00AA Lourdes Aparecida Brito");
		label.setFont(new Font("Arial", Font.PLAIN, 25));
		label.setBounds(177, 162, 472, 33);
		contentPane.add(label);
		

		ActionListener listenerMenuCliente = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ClienteView().setVisible(true);
			}
		};

		ActionListener listenerMenuAutomóvel = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AutomovelView().setVisible(true);
			}

		};

		ActionListener listenerMenuLocacao = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new LocacaoView().setVisible(true);
			}
		};

	



		menuCliente.addActionListener(listenerMenuCliente);
		menuAutomóvel.addActionListener(listenerMenuAutomóvel);
		menuLocacao.addActionListener(listenerMenuLocacao);


	}
}
