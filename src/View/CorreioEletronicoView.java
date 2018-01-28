package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

public class CorreioEletronicoView extends JFrame {

	private JPanel contentPane;
	private JTextField tfArquivo;
	private JTextField tfEmail;
	private JPasswordField tfSenha;
	private JTextField tfDestinatario;
	private JTextField tfAssunto;
	private JTextArea tfConteudo;
	private JComboBox cbEmail;
	private String selecionado;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CorreioEletronicoView frame = new CorreioEletronicoView();
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
	public CorreioEletronicoView() {
		super("Servi�o de Correio Eletr�nico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfArquivo = new JTextField();
		tfArquivo.setColumns(10);
		tfArquivo.setBounds(221, 20, 396, 20);
		contentPane.add(tfArquivo);
		tfArquivo.setVisible(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 51, 1041, 2);
		contentPane.add(separator);
		
		JLabel lblProvedor = new JLabel("Provedor de email usado");
		lblProvedor.setBounds(10, 84, 151, 14);
		contentPane.add(lblProvedor);
		
		final JComboBox cbEmail = new JComboBox();
		cbEmail.setModel(new DefaultComboBoxModel(new String[] {"gmail", "hotmail"}));
		cbEmail.setToolTipText("gmail\r\nhotmail");
		cbEmail.setBounds(176, 81, 143, 20);
		contentPane.add(cbEmail);
		
		JLabel lblRemetente = new JLabel("Email Remetente");
		lblRemetente.setBounds(10, 134, 101, 14);
		contentPane.add(lblRemetente);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(121, 131, 646, 20);
		contentPane.add(tfEmail);
		
		JLabel lblSenha = new JLabel("Senha do Email Remetente");
		lblSenha.setBounds(10, 189, 166, 14);
		contentPane.add(lblSenha);
		
		tfSenha = new JPasswordField();
		tfSenha.setBounds(194, 186, 301, 20);
		contentPane.add(tfSenha);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 228, 914, 2);
		contentPane.add(separator_1);
		
		JLabel lblDestinatario = new JLabel("Email de Destinat\u00E1rio");
		lblDestinatario.setBounds(10, 253, 130, 14);
		contentPane.add(lblDestinatario);
		
		tfDestinatario = new JTextField();
		tfDestinatario.setColumns(10);
		tfDestinatario.setBounds(167, 250, 571, 20);
		contentPane.add(tfDestinatario);
		
		JLabel lblAssunto = new JLabel("Assunto");
		lblAssunto.setBounds(10, 304, 78, 14);
		contentPane.add(lblAssunto);
		
		tfAssunto = new JTextField();
		tfAssunto.setColumns(10);
		tfAssunto.setBounds(167, 301, 375, 20);
		contentPane.add(tfAssunto);
		
		JLabel lblConteudo = new JLabel("Conte\u00FAdo do Email");
		lblConteudo.setBounds(261, 352, 193, 14);
		contentPane.add(lblConteudo);
		
		tfConteudo = new JTextArea();
		tfConteudo.setBounds(35, 377, 721, 101);
		contentPane.add(tfConteudo);
		
		tfAssunto.setText("Relat�rio de Simula��o de Loca��o");
		tfConteudo.setText("Caro usu�rio, segue em anexo conforme solicitado o relat�rio de simula��o."+"\n\nAtenciosamente,\nN�cleo de Administra��o de Autom�veis");
		
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 348, 914, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 489, 914, 2);
		contentPane.add(separator_3);
		
		JButton btnEnviar = new JButton("Selecionar e Enviar");
		btnEnviar.setBounds(139, 528, 147, 23);
		contentPane.add(btnEnviar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(499, 528, 89, 23);
		contentPane.add(btnVoltar);
        
		btnEnviar.addActionListener(new ActionListener() {
			
			
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
            	
				selecionado = (String) cbEmail.getSelectedItem();
				SelecionarArquivo();
			}
		});
		}
	
	public void SelecionarArquivo(){
		String caminhoArquivo = "";
		JFileChooser arquivo = new JFileChooser();
		int retorno = arquivo.showOpenDialog(null);
		if(retorno == JFileChooser.APPROVE_OPTION){
		caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();
		
		try {
			EnviarArquivo(caminhoArquivo);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}else{
		//n�o abriu
		}

		
	}
	
	public  void EnviarArquivo(String caminhoArquivo)
			throws AddressException, MessagingException {
		
		String host = null;
		String port = null;
		final String email = tfEmail.getText();
		final String senha = tfSenha.getText();

		String destinatario = tfDestinatario.getText();
		String assunto = tfAssunto.getText();
		String conteudo = tfConteudo.getText();

		
		String[] attachFiles = new String[1];
		attachFiles[0] = caminhoArquivo;
		
		Properties dados = new Properties();

		
		if(selecionado=="gmail"){
		
		
		
	    host = "smtp.gmail.com";
	    port = "587";
		dados.put("mail.smtp.host", host);
		dados.put("mail.smtp.port", port);
		dados.put("mail.smtp.auth", "true");
		dados.put("mail.smtp.starttls.enable", "true");
		dados.put("mail.user", email);
		dados.put("mail.password", senha);
		}
		else{
			 host = "smtp.live.com";
			 port = "587";
			    
				dados.put("mail.transport.protocol", "smtp");
				dados.put("mail.smtp.host", host);
				dados.put("mail.smtp.socketFactory.port", "587");
				dados.put("mail.smtp.socketFactory.fallback", "false");
				dados.put("mail.smtp.starttls.enable", "true");
				dados.put("mail.smtp.auth", "true");
				dados.put("mail.smtp.port", port);
		}

		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		};
		Session session = Session.getInstance(dados, auth);

		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(email));
		InternetAddress[] toAddresses = { new InternetAddress(destinatario) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(assunto);
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(conteudo, "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		if (attachFiles != null && attachFiles.length > 0) {
			for (String filePath : attachFiles) {
				MimeBodyPart attachPart = new MimeBodyPart();

				try {
					attachPart.attachFile(filePath);
                    JOptionPane.showMessageDialog(null,"O relat�rio gerado foi enviado com sucesso para o endere�o\n"+
					tfDestinatario.getText(),"�xito",JOptionPane.INFORMATION_MESSAGE);
    				CorreioEletronicoView.this.dispose();

                    new  LocacaoView().setVisible(true);
                    
				} catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"Erro no envio do relat�rio","Aten��o",JOptionPane.CANCEL_OPTION);
					ex.printStackTrace();
				}

				multipart.addBodyPart(attachPart);
			}
		
		
		
		msg.setContent(multipart);

		Transport.send(msg);

	}
		}
	

		


		
		
	
		

	
}
