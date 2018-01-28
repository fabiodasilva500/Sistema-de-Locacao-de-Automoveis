package Entidades;

import java.util.Date;

public class Locacao {
private int codigo_automovel;
private String cpf_cliente;
private Date data_locacao;
private Date data_devolucao;
private float valor_total;

public int getCodigo_automovel() {
	return codigo_automovel;
}
public void setCodigo_automovel(int codigo_automovel) {
	this.codigo_automovel = codigo_automovel;
}
public String getCpf_cliente() {
	return cpf_cliente;
}
public void setCpf_cliente(String cpf_cliente) {
	this.cpf_cliente = cpf_cliente;
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
public float getValor_Total() {
	return valor_total;
}
public void setValor_Total(float valor_total) {
	this.valor_total = valor_total;
}


}
