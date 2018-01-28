package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Cliente;


public class ClienteDaoImplementation implements ClienteDao {

	@Override
	public boolean inserir(Cliente c) {
       boolean inserido = false;
       
		try{
    	Connection con=JTDSUtil.getConnection();
    	String sql = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?)";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	stmt.setString(1, c.getCpf());
    	stmt.setString(2, c.getNome());
    	stmt.setString(3, c.getCnh());
    	stmt.setString(4, c.getEndereco());
    	stmt.setString(5, c.getTelefone());
    	stmt.setDate(6, new java.sql.Date(c.getData_nascimento().getTime()));
    	stmt.executeUpdate();
    	inserido = true;
		}
         catch(SQLException e){
         e.printStackTrace();
         }
		
		return inserido;
	}

	@Override
	public Cliente pesquisar(String cpf) {
	 Cliente cliente=new Cliente();

     try{
     Connection con = JTDSUtil.getConnection();
     String sql = "SELECT cpf, nome, cnh, endereco, telefone, data_nascimento from Cliente Where cpf = ?";

     PreparedStatement stmt=con.prepareStatement(sql);
     stmt.setString(1, cpf);
     
     ResultSet rs=stmt.executeQuery();
     
     if(rs.next()){
     cliente.setCpf(rs.getString("cpf"));
     cliente.setNome(rs.getString("nome"));
     cliente.setCnh(rs.getString("cnh"));
     cliente.setEndereco(rs.getString("endereco"));
     cliente.setTelefone(rs.getString("telefone"));
     cliente.setData_nascimento(rs.getDate("data_nascimento"));
     }
     }
	 catch(SQLException e){
	 e.printStackTrace();
	 }
		return  cliente;
	}

	@Override
	public boolean atualizar(Cliente c) {
	boolean atualizado = false;
	try{
    Connection con=JTDSUtil.getConnection();
    String sql = "UPDATE Cliente set nome = ?, cnh = ?, endereco = ?, " +
    		"telefone = ?, data_nascimento = ? Where cpf = ?";
   PreparedStatement stmt=con.prepareStatement(sql);
   
   stmt.setString(1, c.getNome());
   stmt.setString(2, c.getCnh());
   stmt.setString(3, c.getEndereco());
   stmt.setString(4, c.getTelefone());
   stmt.setDate(5, new java.sql.Date(c.getData_nascimento().getTime()));
   stmt.setString(6, c.getCpf());
   stmt.executeUpdate();
   atualizado = true;
	}
	catch(SQLException e){
	e.printStackTrace();
	}
	return atualizado;
	}

	@Override
	public boolean remover(String cpf) {
    boolean excluido = false;
	try{
    Connection con=JTDSUtil.getConnection();
    String sql = "DELETE Cliente Where cpf = ?";
    PreparedStatement stmt=con.prepareStatement(sql);
    stmt.setString(1, cpf);
    stmt.executeUpdate();
    excluido=true;
    }
    catch(SQLException e){
    e.printStackTrace();
    }
	return excluido;
	}

}
