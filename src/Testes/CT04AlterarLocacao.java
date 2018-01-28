package Testes;


import static org.junit.Assert.*;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Dao.JTDSUtil;
import Dao.LocacaoDao;
import Dao.LocacaoDaoImplementation;
import Entidades.Locacao;



public class CT04AlterarLocacao {

	static LocacaoDao daoLocacao;
	static Locacao l;
	static Connection con;
	
	
	@BeforeClass
	public  static void setUpBeforeClass() throws Exception {
	con = JTDSUtil.getConnection();
	daoLocacao = new LocacaoDaoImplementation();
	l=new Locacao();

	l.setCodigo_automovel(1);
	l.setCpf_cliente("11111111111");

	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

	try{
	l.setData_locacao(sdf.parse("25/10/2013"));
	l.setData_devolucao(sdf.parse("01/11/2013"));
	}
	catch(ParseException e){
	e.printStackTrace();
	}
	
	daoLocacao.inserir(l);
	}

	
	@Test
	public  void CT021Alterar_Locacao_com_sucesso(){
	try{
	l.setCodigo_automovel(1);
	l.setCpf_cliente("11111111111");

	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

	try{
	l.setData_locacao(sdf.parse("25/10/2013"));
	l.setData_devolucao(sdf.parse("02/11/2013"));
	}
	catch(ParseException e){
	e.printStackTrace();
	}

	assertTrue(daoLocacao.atualizar(l));
	}
	catch(Exception e){
	fail("disparou uma exception");
	}
	}
	
	

@AfterClass
  public static void tearDownAfterClass() throws Exception {
	con.close();
}


}
