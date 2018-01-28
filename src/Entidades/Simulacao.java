package Entidades;

import java.util.Date;

public class Simulacao{
private String cpf_cliente;
private String nome_cliente;
private int codigo_automovel;
private String nome_automovel;
private String modelo_automovel;
private String cor_automovel;
private int ano_automovel;
private String motor_automovel;
private Date data_locacao;
private Date data_devolucao;
private float valor_total;

public String getCpf_cliente() {
	return cpf_cliente;
}
public void setCpf_cliente(String cpf_cliente) {
	this.cpf_cliente = cpf_cliente;
}
public String getNome_cliente() {
	return nome_cliente;
}
public void setNome_cliente(String nome_cliente) {
	this.nome_cliente = nome_cliente;
}
public int getCodigo_automovel() {
	return codigo_automovel;
}
public void setCodigo_automovel(int codigo_automovel) {
	this.codigo_automovel = codigo_automovel;
}
public String getNome_automovel() {
	return nome_automovel;
}
public void setNome_automovel(String nome_automovel) {
	this.nome_automovel = nome_automovel;
}
public String getModelo_automovel() {
	return modelo_automovel;
}
public void setModelo_automovel(String modelo_automovel) {
	this.modelo_automovel = modelo_automovel;
}
public String getCor_automovel() {
	return cor_automovel;
}
public void setCor_automovel(String cor_automovel) {
	this.cor_automovel = cor_automovel;
}
public int getAno_automovel() {
	return ano_automovel;
}
public void setAno_automovel(int ano_automovel) {
	this.ano_automovel = ano_automovel;
}
public String getMotor_automovel() {
	return motor_automovel;
}
public void setMotor_automovel(String motor_automovel) {
	this.motor_automovel = motor_automovel;
}
public Date getData_locacao() {
	return data_locacao;
}
public void setData_locacao(Date data_locacao) {
	this.data_locacao = data_locacao;
}
public Date getData_devolucao() {
	return data_devolucao;
}
public void setData_devolucao(Date data_devolucao) {
	this.data_devolucao = data_devolucao;
}
public float getValor_total() {
	return valor_total;
}
public void setValor_total(float valor_total) {
	this.valor_total = valor_total;
}


}
