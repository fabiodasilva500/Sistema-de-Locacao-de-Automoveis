package Dao;

import Entidades.Cliente;

public interface ClienteDao {
public boolean inserir (Cliente c);
public Cliente pesquisar (String cpf);
public boolean atualizar (Cliente c);
public boolean remover (String cpf);
}
