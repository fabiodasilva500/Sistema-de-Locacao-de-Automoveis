package Dao;

import net.sf.jasperreports.engine.JasperPrint;
import Entidades.Simulacao;

public interface SimulacaoDao {
public boolean inserir(Simulacao simulacao);
public boolean inserirProjetaTela(Simulacao simulacao);
public Simulacao pesquisar();
public boolean remover(int codigo_automovel, String cpf_cliente);
public JasperPrint gerar();

}
