package model;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int codigo;
    private float preco;
    private String nome;
    private String categoria;
    private Cidade origem;
    private List<Item> itens; // Composição

    public Produto(int codigo, float preco, String nome, String categoria, Cidade origem) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
        this.categoria = categoria;
        this.setOrigem(origem);
        this.itens = new ArrayList<>();
    }
    
    public void adicionarItem(Item item) {
        if (!this.itens.contains(item)) {
            this.itens.add(item);
        }
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public void setOrigem(Cidade origem) {
        if (this.origem != null) {
            this.origem.getProdutosOrigem().remove(this);
        }
        this.origem = origem;
        if (origem != null) {
            origem.adicionarProdutoOrigem(this);
        }
    }

    public List<Item> getItens() {
        return new ArrayList<>(itens); // Retorna uma cópia para proteger a composição
    }
}