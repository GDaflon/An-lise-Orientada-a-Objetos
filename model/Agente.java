package model;

import java.util.ArrayList;
import java.util.List;

public class Agente {
    private String cpf;
    private String nome;
    private String cargo;
    private Empresa empresa;
    private List<Transporte> transportes;

    public Agente(String cpf, String nome, String cargo, Empresa empresa) {
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
        this.setEmpresa(empresa);
        this.transportes = new ArrayList<>();
    }

    public void adicionarTransporte(Transporte transporte) {
        if (!this.transportes.contains(transporte)) {
            this.transportes.add(transporte);
            transporte.adicionarAgente(this);
        }
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        if (this.empresa != null) {
            this.empresa.getAgentes().remove(this);
        }
        this.empresa = empresa;
        if (empresa != null) {
            empresa.adicionarAgente(this);
        }
    }

    public List<Transporte> getTransportes() {
        return transportes;
    }
}