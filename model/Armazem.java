package model;

import java.util.ArrayList;
import java.util.List;

public class Armazem {
    private int codigo;
    private String historico;
    private int estoque;
    private Cidade cidade;
    private List<Transporte> transportesOrigem;
    private List<Transporte> transportesDestino;

    public Armazem(int codigo, String historico, int estoque, Cidade cidade) {
        this.codigo = codigo;
        this.historico = historico;
        this.estoque = estoque;
        this.setCidade(cidade);
        this.transportesOrigem = new ArrayList<>();
        this.transportesDestino = new ArrayList<>();
    }

    public void adicionarTransporteOrigem(Transporte transporte) {
        if (!this.transportesOrigem.contains(transporte)) {
            this.transportesOrigem.add(transporte);
            transporte.setOrigem(this);
        }
    }

    public void adicionarTransporteDestino(Transporte transporte) {
        if (!this.transportesDestino.contains(transporte)) {
            this.transportesDestino.add(transporte);
            transporte.setDestino(this);
        }
    }
    
    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        if (this.cidade != null) {
            this.cidade.getArmazens().remove(this);
        }
        this.cidade = cidade;
        if (cidade != null) {
            cidade.adicionarArmazem(this);
        }
    }

    public List<Transporte> getTransportesOrigem() {
        return transportesOrigem;
    }

    public List<Transporte> getTransportesDestino() {
        return transportesDestino;
    }
    public void validarArmazem() {
        if (nomeArmazem == null || nomeArmazem.isEmpty()) {
            throw new IllegalArgumentException("Nome do armazém inválido");
        }
    }
}
