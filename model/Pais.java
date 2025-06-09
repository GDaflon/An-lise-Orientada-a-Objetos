package model;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private int codigo;
    private String continente;
    private String nome;
    private List<Cidade> cidades;

    public Pais(int codigo, String continente, String nome) {
        this.codigo = codigo;
        this.continente = continente;
        this.nome = nome;
        this.cidades = new ArrayList<>();
    }

    public void adicionarCidade(Cidade cidade) {
        if (!this.cidades.contains(cidade)) {
            this.cidades.add(cidade);
            cidade.setPais(this);
        }
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }
}