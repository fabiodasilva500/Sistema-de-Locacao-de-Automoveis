package Entidades;

import java.util.Date;

public class Cliente {
private String cpf;
private String nome;
private String cnh;
private String endereco;
private String telefone;
private Date data_nascimento;


public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCnh() {
	return cnh;
}
public void setCnh(String cnh) {
	this.cnh = cnh;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public Date getData_nascimento() {
	return data_nascimento;
}
public void setData_nascimento(Date data_nascimento) {
	this.data_nascimento = data_nascimento;
}

}
