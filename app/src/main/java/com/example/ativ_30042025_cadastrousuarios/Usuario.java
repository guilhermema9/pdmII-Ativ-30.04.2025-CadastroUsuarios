package com.example.ativ_30042025_cadastrousuarios;

public class Usuario {
    private String nome, sexo;
    private boolean estudante, estagiario, profissional, doador;

    // Para mudar a apresentação dos dados
    // linearlayoutmanager.setreverlayout(true)

    public Usuario(String nome, String sexo, boolean estudante, boolean estagiario, boolean profissional, boolean doador) {
        this.nome = nome;
        this.sexo = sexo;
        this.estudante = estudante;
        this.estagiario = estagiario;
        this.profissional = profissional;
        this.doador = doador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isEstudante() {
        return estudante;
    }

    public void setEstudante(boolean estudante) {
        this.estudante = estudante;
    }

    public boolean isEstagiario() {
        return estagiario;
    }

    public void setEstagiario(boolean estagiario) {
        this.estagiario = estagiario;
    }

    public boolean isProfissional() {
        return profissional;
    }

    public void setProfissional(boolean profissional) {
        this.profissional = profissional;
    }

    public boolean isDoador() {
        return doador;
    }

    public void setDoador(boolean doador) {
        this.doador = doador;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", estudante=" + estudante +
                ", estagiario=" + estagiario +
                ", profissional=" + profissional +
                ", doador=" + doador +
                '}';
    }
}
