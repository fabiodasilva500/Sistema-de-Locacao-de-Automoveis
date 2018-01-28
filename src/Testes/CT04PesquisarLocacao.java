package Testes;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;


import org.junit.BeforeClass;
import org.junit.Test;

import Dao.JTDSUtil;
import Dao.LocacaoDao;
import Dao.LocacaoDaoImplementation;
import Entidades.Locacao;

public class CT04PesquisarLocacao {
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
	public  void CT01Pesquisar_Locacao_com_sucesso(){
	try{
    List<Locacao> list = Arrays.asList(daoLocacao.pesquisar(1, "11111111111"));
    
    Assert.assertTrue(list!=null);
    	}
	catch(Exception e){
	fail("disparou uma exception");
	}
	}
}
