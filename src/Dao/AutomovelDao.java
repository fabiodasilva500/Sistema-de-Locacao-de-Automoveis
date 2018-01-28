package Dao;

import java.util.List;

import Entidades.Automovel;

public interface AutomovelDao {
public boolean inserir(Automovel a);
public Automovel pesquisarPorId(int codigo);
public List<Automovel> pesquisarTodos ();
public List<Automovel> pesquisarPorNome(String nome);
public List<Automovel> pesquisarPorMarca(String marca);
public List<Automovel> pesquisarPorModelo (String modelo);
public boolean atualizar (Automovel a);
public boolean remover (int codigo);

}
