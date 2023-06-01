package br.com.livros.modelo;
/*
 * CREATE TABLE livro
(
    id bigserial NOT NULL,
    nome character varying(50),
    autor character varying(30),
    categoria character varying(30),
    CONSTRAINT livro_pkey PRIMARY KEY (id)
);
 * */
public class Livro {
	
	private Long id;
	private String nome;
	private String autor;
	private String categoria;
	
	public Livro() {
		super();
		
	}

	public Livro(String nome, String autor, String categoria) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setModelo(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
