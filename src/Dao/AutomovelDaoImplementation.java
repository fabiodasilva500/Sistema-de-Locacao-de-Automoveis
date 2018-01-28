package Dao;

import Entidades.Automovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AutomovelDaoImplementation  implements AutomovelDao{

	@Override
	public boolean inserir(Automovel a) {
    boolean inserido=false;
    try{
    Connection con=JTDSUtil.getConnection();
    String sql = "INSERT INTO Automovel VALUES (?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement stmt=con.prepareStatement(sql);
    stmt.setString(1, a.getNome());
    stmt.setString(2, a.getMarca());
    stmt.setString(3, a.getModelo());
    stmt.setString(4, a.getCor());
    stmt.setInt(5, a.getAno());
    stmt.setString(6, a.getMotor());
    stmt.setInt(7, a.getCodigo_tipo());
    stmt.executeUpdate();
    inserido = true;
    }
    catch(SQLException e){
    e.printStackTrace();
    }
		return inserido;
	}

	@Override
	public Automovel pesquisarPorId(int codigo) {
    Automovel automovel=new Automovel();
    try{
    Connection con=JTDSUtil.getConnection();
    String sql = "SELECT codigo, nome, marca, modelo, cor, ano, motor, codigo_tipo from Automovel Where codigo = ?";
    PreparedStatement stmt=con.prepareStatement(sql);
    stmt.setInt(1, codigo);
    ResultSet rs=stmt.executeQuery();
    
    if(rs.next()){
    automovel.setCodigo(rs.getInt("codigo"));
    automovel.setNome(rs.getString("nome"));
    automovel.setMarca(rs.getString("marca"));
    automovel.setModelo(rs.getString("modelo"));
    automovel.setCor(rs.getString("cor"));
    automovel.setAno(rs.getInt("ano"));
    automovel.setMotor(rs.getString("motor"));
    automovel.setCodigo_tipo(rs.getInt("codigo_tipo"));
    }
    }
    catch(SQLException e){
    e.printStackTrace();
    }
		return automovel;
	}

	@Override
	public List<Automovel> pesquisarPorNome(String nome) {
		List<Automovel> automoveis=new ArrayList<Automovel>();
		Automovel automovel=new Automovel();
		    try{
		    Connection con=JTDSUtil.getConnection();
		    String sql = "SELECT codigo, nome, marca, modelo, cor, ano, motor, codigo_tipo from Automovel" +
		    		"Where nome = ?";
		    PreparedStatement stmt=con.prepareStatement(sql);
		    stmt.setString(1, nome);
		    ResultSet rs=stmt.executeQuery();
		    
		    while(rs.next()){
		    automovel.setCodigo(rs.getInt("codigo"));
		    automovel.setNome(rs.getString("nome"));
		    automovel.setMarca(rs.getString("marca"));
		    automovel.setModelo(rs.getString("modelo"));
		    automovel.setCor(rs.getString("cor"));
		    automovel.setAno(rs.getInt("ano"));
		    automovel.setMotor(rs.getString("motor"));
		    automovel.setCodigo_tipo(rs.getInt("codigo_tipo"));
		    automoveis.add(automovel);
		    }
		    }
		    catch(SQLException e){
		    e.printStackTrace();
		    }
				return automoveis;
			}

	

	@Override
	public List<Automovel> pesquisarPorMarca(String marca) {
		List<Automovel> automoveis=new ArrayList<Automovel>();
		Automovel automovel=new Automovel();
		    try{
		    Connection con=JTDSUtil.getConnection();
		    String sql = "SELECT codigo, nome, marca, modelo, cor, ano, motor, codigo_tipo from Automovel" +
		    		"Where marca = ?";
		    PreparedStatement stmt=con.prepareStatement(sql);
		    stmt.setString(1, marca);
		    ResultSet rs=stmt.executeQuery();
		    
		    if(rs.next()){
		    automovel.setCodigo(rs.getInt("codigo"));
		    automovel.setNome(rs.getString("nome"));
		    automovel.setMarca(rs.getString("marca"));
		    automovel.setModelo(rs.getString("modelo"));
		    automovel.setCor(rs.getString("cor"));
		    automovel.setAno(rs.getInt("ano"));
		    automovel.setMotor(rs.getString("motor"));
		    automovel.setCodigo_tipo(rs.getInt("codigo_tipo"));
		    automoveis.add(automovel);
		    }
		    }
		    catch(SQLException e){
		    e.printStackTrace();
		    }
				return automoveis;
			}


	@Override
	public List<Automovel> pesquisarPorModelo(String modelo) {
		List<Automovel> automoveis=new ArrayList<Automovel>();
		Automovel automovel=new Automovel();
		    try{
		    Connection con=JTDSUtil.getConnection();
		    String sql = "SELECT codigo, nome, marca, modelo, cor, ano, motor, codigo_tipo from Automovel" +
		    		"Where modelo = ?";
		    PreparedStatement stmt=con.prepareStatement(sql);
		    stmt.setString(1, modelo);
		    ResultSet rs=stmt.executeQuery();
		    
		    while(rs.next()){
		    automovel.setCodigo(rs.getInt("codigo"));
		    automovel.setNome(rs.getString("nome"));
		    automovel.setMarca(rs.getString("marca"));
		    automovel.setModelo(rs.getString("modelo"));
		    automovel.setCor(rs.getString("cor"));
		    automovel.setAno(rs.getInt("ano"));
		    automovel.setMotor(rs.getString("motor"));
		    automovel.setCodigo_tipo(rs.getInt("codigo_tipo"));
		    automoveis.add(automovel);
		    }
		    }
		    catch(SQLException e){
		    e.printStackTrace();
		    }
				return automoveis;
			}
	
	
	
	public List<Automovel> pesquisarTodos() {
		List<Automovel> automoveis=new ArrayList<Automovel>();
		   
		try{
		    Connection con=JTDSUtil.getConnection();
		    String sql = "SELECT codigo, nome, modelo from Automovel";
		    PreparedStatement stmt=con.prepareStatement(sql);

		    ResultSet rs=stmt.executeQuery();
		    
		    while(rs.next()){
			Automovel automovel=new Automovel();
		    automovel.setCodigo(rs.getInt("codigo"));
		    automovel.setNome(rs.getString("nome"));
		    automovel.setModelo(rs.getString("modelo"));
		    automoveis.add(automovel);
		    }
		    }
		    catch(SQLException e){
		    e.printStackTrace();
		    }
				return automoveis;
			}



	@Override
	public boolean atualizar(Automovel a) {
	boolean atualizado = false;
	try{
	Connection con = JTDSUtil.getConnection();
	String sql = "UPDATE automovel set nome = ?, marca = ?, modelo = ?, " +
	"cor = ?, ano = ?, motor = ?, codigo_tipo = ? Where codigo = ?";
	
	PreparedStatement stmt=con.prepareStatement(sql);
    stmt.setString(1, a.getNome());
    stmt.setString(2, a.getMarca());
    stmt.setString(3, a.getModelo());
    stmt.setString(4, a.getCor());
    stmt.setInt(5, a.getAno());
    stmt.setString(6, a.getMotor());
    stmt.setInt(7, a.getCodigo_tipo());
    stmt.setInt(8, a.getCodigo());
    stmt.executeUpdate();
    atualizado = true;
	}
	catch(SQLException e){
	e.printStackTrace();
	}
		
		return atualizado;
	}

	@Override
	public boolean remover(int codigo) {
	boolean excluido = false;
	try{
	Connection con=JTDSUtil.getConnection();
	String sql = "DELETE Automovel Where codigo = ?";
	PreparedStatement stmt=con.prepareStatement(sql);
	stmt.setInt(1, codigo);
	stmt.executeUpdate();
	excluido = true;
	}
	catch(SQLException e){
	e.printStackTrace();
	}
		return excluido;
	}

}
