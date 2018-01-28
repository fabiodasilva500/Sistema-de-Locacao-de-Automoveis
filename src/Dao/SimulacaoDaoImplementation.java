package Dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Entidades.Locacao;
import Entidades.Simulacao;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class SimulacaoDaoImplementation implements SimulacaoDao{

	
	public boolean inserir(Simulacao simulacao) {
		boolean inserido = false;

		try {
			Connection con = JTDSUtil.getConnection();
			String sql = "{call insere_Simulacao(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, simulacao.getCodigo_automovel());
			cs.setString(2, simulacao.getCpf_cliente());
            cs.setDate(3, new java.sql.Date(simulacao.getData_locacao().getTime()));
            cs.setDate(4, new java.sql.Date(simulacao.getData_devolucao().getTime()));
			cs.execute();
			cs.close();
			inserido = true;
			gerar();
	        JasperPrint relat;
			relat = gerar();
			JasperViewer.viewReport(relat, false);
			remover(simulacao.getCodigo_automovel(), simulacao.getCpf_cliente());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Atenção",JOptionPane.CANCEL_OPTION);
		}

		return inserido;
	}
	
	
	public boolean inserirProjetaTela(Simulacao simulacao) {
		boolean inserido = false;

		try {
			Connection con = JTDSUtil.getConnection();
			String sql = "{call insere_Simulacao(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, simulacao.getCodigo_automovel());
			cs.setString(2, simulacao.getCpf_cliente());
            cs.setDate(3, new java.sql.Date(simulacao.getData_locacao().getTime()));
            cs.setDate(4, new java.sql.Date(simulacao.getData_devolucao().getTime()));
			cs.execute();
			cs.close();
			inserido = true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Atenção",JOptionPane.CANCEL_OPTION);
		}

		return inserido;
	}
	
	
	public Simulacao pesquisar() {
	    Simulacao simulacao=new Simulacao();
	    try{
	    Connection con=JTDSUtil.getConnection();	
	    String sql = "Select  cpf_cliente, nome_cliente, codigo_automovel, nome_automovel, modelo_automovel, cor_automovel, ano_automovel, motor_automovel, data_locacao, data_devolucao, valor_total from consulta_Simulacao ()";
	    
	    PreparedStatement stmt=con.prepareStatement(sql);
	

	    ResultSet rs=stmt.executeQuery();
	    
	    if(rs.next()){
		simulacao.setCpf_cliente(rs.getString("cpf_cliente"));
        simulacao.setNome_cliente(rs.getString("nome_cliente"));
	    simulacao.setCodigo_automovel(rs.getInt("codigo_automovel"));
        simulacao.setNome_automovel(rs.getString("nome_automovel"));
        simulacao.setModelo_automovel(rs.getString("modelo_automovel"));
        simulacao.setCor_automovel(rs.getString("cor_automovel"));
        simulacao.setAno_automovel(rs.getInt("ano_automovel"));
        simulacao.setMotor_automovel(rs.getString("motor_automovel"));
	    simulacao.setData_locacao(rs.getDate("data_locacao"));
	    simulacao.setData_devolucao(rs.getDate("data_devolucao"));
	    simulacao.setValor_total(rs.getFloat("valor_total"));
	    }
        }
	    catch(SQLException e){
		JOptionPane.showMessageDialog(null,e.getMessage(),"Atenção",JOptionPane.CANCEL_OPTION);
	    }
	    return simulacao;
		}

	
	//public SimulacaoDaoImplementation(){
	//gerar();
	
	//	   JasperPrint relat;
		//	relat = gerar();
		//	JasperViewer.viewReport(relat, false);
		//}
	
	public boolean remover(int codigo_automovel, String cpf_cliente) {
    boolean removido = false;
    
    try{
    Connection con = JTDSUtil.getConnection();
    String sql = "{call exclui_Simulacao(?,?)}";
    CallableStatement cs = con.prepareCall(sql);
    cs.setInt(1, codigo_automovel);
    cs.setString(2, cpf_cliente);
    cs.execute();
    cs.close();
    removido=true;
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e.getMessage(),"Atenção",JOptionPane.CANCEL_OPTION);

    }
		return removido;
	}

	public JasperPrint gerar(){
		JasperPrint rel = null;
		try {
			Connection con = JTDSUtil.getConnection();
			HashMap map = new HashMap();
			String arquivoJasper = "avaliacao2.jasper";
			rel = JasperFillManager.fillReport(arquivoJasper, map, con);
		} catch (JRException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return rel;
	}
	
	
	//public static void main(String[]args){
	//new SimulacaoDaoImplementation();
    //}

}
