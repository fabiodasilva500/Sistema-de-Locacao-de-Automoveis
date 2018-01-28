package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Entidades.Locacao;

public class LocacaoDaoImplementation implements LocacaoDao {

	@Override
	public boolean inserir(Locacao locacao) {
		boolean inserido = false;

		try {
			Connection con = JTDSUtil.getConnection();
			String sql = "{call insere_Locacao(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, locacao.getCodigo_automovel());
			cs.setString(2, locacao.getCpf_cliente());
            cs.setDate(3, new java.sql.Date(locacao.getData_locacao().getTime()));
            cs.setDate(4, new java.sql.Date(locacao.getData_devolucao().getTime()));
			cs.execute();
			cs.close();
			inserido = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Atenção",JOptionPane.CANCEL_OPTION);
		}

		return inserido;
	}
	
	
	@Override
	public Locacao pesquisar(int codigo_automovel, String cpf_cliente) {
    Locacao locacao=new Locacao();
    try{
    Connection con=JTDSUtil.getConnection();	
    String sql = "Select codigo_automovel, cpf_cliente, data_locacao, data_devolucao, valor_total from consulta_Locacao (?,?)";
    
    PreparedStatement stmt=con.prepareStatement(sql);
    stmt.setInt(1, codigo_automovel);
    stmt.setString(2, cpf_cliente);

    ResultSet rs=stmt.executeQuery();
    
    if(rs.next()){
    locacao.setCodigo_automovel(rs.getInt("codigo_automovel"));
    locacao.setCpf_cliente(rs.getString("cpf_cliente"));
    locacao.setData_locacao(rs.getDate("data_locacao"));
    locacao.setData_devolucao(rs.getDate("data_devolucao"));
    locacao.setValor_Total(rs.getFloat("valor_total"));
    }
    }
    catch(SQLException e){
	JOptionPane.showMessageDialog(null,e.getMessage(),"Atenção",JOptionPane.CANCEL_OPTION);
    }
    return locacao;
	}

	public boolean atualizar(Locacao locacao) {
		boolean atualizado = false;

		try {
			Connection con = JTDSUtil.getConnection();
			String sql = "{call altera_Locacao(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, locacao.getCodigo_automovel());
			cs.setString(2, locacao.getCpf_cliente());
            cs.setDate(3, new java.sql.Date(locacao.getData_locacao().getTime()));
            cs.setDate(4, new java.sql.Date(locacao.getData_devolucao().getTime()));
			cs.execute();
			cs.close();
			atualizado = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Atenção",JOptionPane.CANCEL_OPTION);
		}

		return atualizado;
	}
	
	@Override
	public boolean remover(int codigo_automovel, String cpf_cliente) {
    boolean removido = false;
    
    try{
    Connection con = JTDSUtil.getConnection();
    String sql = "{call exclui_Locacao(?,?)}";
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


}
