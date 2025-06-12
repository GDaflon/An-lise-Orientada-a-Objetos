package model;

public class Item {
    private String nome;
    private String situacao;
    private Produto produto; // Referência ao todo (Produto)

    public Item(String nome, String situacao, Produto produto) {
        this.nome = nome;
        this.situacao = situacao;
        this.produto = produto;
        produto.adicionarItem(this); // Garante a consistência da composição
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Produto getProduto() {
        return produto;
    }
    public void validarItem() {
        if (nomeItem == null || nomeItem.isEmpty()) {
            throw new IllegalArgumentException("Nome do item inválido");
        }
    }
}
