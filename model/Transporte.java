package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transporte {
    private int codigo;
    private String status;
    private LocalDate dataFim;
    private Armazem origem;
    private Armazem destino;
    private List<Agente> agentes;
    private List<Item> itens;

    public Transporte(int codigo, String status, LocalDate dataFim, Armazem origem, Armazem destino) {
        this.codigo = codigo;
        this.status = status;
        this.dataFim = dataFim;
        this.setOrigem(origem);
        this.setDestino(destino);
        this.agentes = new ArrayList<>();
        this.itens = new ArrayList<>();
    }

    public void adicionarAgente(Agente agente) {
        if (!this.agentes.contains(agente)) {
            this.agentes.add(agente);
            agente.adicionarTransporte(this);
        }
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Armazem getOrigem() {
        return origem;
    }

    public void setOrigem(Armazem origem) {
        if (this.origem != null) {
            this.origem.getTransportesOrigem().remove(this);
        }
        this.origem = origem;
        if (origem != null) {
            origem.adicionarTransporteOrigem(this);
        }
    }

    public Armazem getDestino() {
        return destino;
    }

    public void setDestino(Armazem destino) {
        if (this.destino != null) {
            this.destino.getTransportesDestino().remove(this);
        }
        this.destino = destino;
        if (destino != null) {
            destino.adicionarTransporteDestino(this);
        }
    }

    public List<Agente> getAgentes() {
        return agentes;
    }

    public List<Item> getItens() {
        return itens;
    }
}