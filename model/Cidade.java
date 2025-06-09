package model;

import java.util.ArrayList;
import java.util.List;

public class Cidade {
    private int codigo;
    private String estado;
    private String nome;
    private Pais pais;
    private List<Produto> produtosOrigem;
    private List<Armazem> armazens;

    public Cidade(int codigo, String estado, String nome, Pais pais) {
        this.codigo = codigo;
        this.estado = estado;
        this.nome = nome;
        this.setPais(pais);
        this.produtosOrigem = new ArrayList<>();
        this.armazens = new ArrayList<>();
    }

    public void adicionarProdutoOrigem(Produto produto) {
        if (!this.produtosOrigem.contains(produto)) {
            this.produtosOrigem.add(produto);
            produto.setOrigem(this);
        }
    }
    
    public void adicionarArmazem(Armazem armazem) {
        if (!this.armazens.contains(armazem)) {
            this.armazens.add(armazem);
            armazem.setCidade(this);
        }
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        if (this.pais != null) {
            this.pais.getCidades().remove(this);
        }
        this.pais = pais;
        if (pais != null) {
            pais.adicionarCidade(this);
        }
    }

    public List<Produto> getProdutosOrigem() {
        return produtosOrigem;
    }

    public List<Armazem> getArmazens() {
        return armazens;
    }
}