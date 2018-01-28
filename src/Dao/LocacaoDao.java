package Dao;

import Entidades.Locacao;

public interface LocacaoDao {
public boolean inserir(Locacao locacao);
public Locacao pesquisar (int codigo_automovel, String cpf_cliente);
public boolean atualizar (Locacao locacao);
public boolean remover (int codigo_automovel, String cpf_cliente);

}
