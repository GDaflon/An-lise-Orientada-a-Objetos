package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private int codigo;
    private String nome;
    private LocalDate dataParceria;
    private List<Agente> agentes;

    public Empresa(int codigo, String nome, LocalDate dataParceria) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataParceria = dataParceria;
        this.agentes = new ArrayList<>();
    }
    
    public void adicionarAgente(Agente agente) {
        if (!this.agentes.contains(agente)) {
            this.agentes.add(agente);
            agente.setEmpresa(this);
        }
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataParceria() {
        return dataParceria;
    }

    public void setDataParceria(LocalDate dataParceria) {
        this.dataParceria = dataParceria;
    }

    public List<Agente> getAgentes() {
        return agentes;
    }
    public void validarEmpresa() {
        if (cnpj == null || cnpj.isEmpty()) {
            throw new IllegalArgumentException("CNPJ inválido");
        }
    }
}
