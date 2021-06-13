package br.com.tinnova.crudsb.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class VeiculoDto {

	@NotNull
	private Integer id;
	private String modelo;
	private String marca;
	private Integer ano;
	private String descricao;
	private Boolean disponivel;
	private Date created;
	private Date updated;
	private Double valor;
		
	
	public VeiculoDto() {
		super();
	}

	public VeiculoDto(Integer id, String modelo, String marca, Integer ano, String descricao, Boolean disponivel,
			Date created, Date updated, Double valor) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.disponivel = disponivel;
		this.created = created;
		this.updated = updated;
		this.valor = valor;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getDisponivel() {
		return disponivel;
	}
	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
