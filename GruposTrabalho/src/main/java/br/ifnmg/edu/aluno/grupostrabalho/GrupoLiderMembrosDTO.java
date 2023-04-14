/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifnmg.edu.aluno.grupostrabalho;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class GrupoLiderMembrosDTO {

    private String grupoNome;
    private String liderNome;
    private List<String> nomesMembros;

    public GrupoLiderMembrosDTO() {
        nomesMembros = new ArrayList<>();
    }

    public GrupoLiderMembrosDTO(String grupoNome, String liderNome, List<String> nomesMembros) {
        this.grupoNome = grupoNome;
        this.liderNome = liderNome;
        this.nomesMembros = nomesMembros;
    }

    public String getGrupoNome() {
        return grupoNome;
    }

    public void setGrupoNome(String grupoNome) {
        this.grupoNome = grupoNome;
    }

    public String getLiderNome() {
        return liderNome;
    }

    public void setLiderNome(String liderNome) {
        this.liderNome = liderNome;
    }

    public List<String> getNomesMembros() {
        return nomesMembros;
    }

    public void setNomesMembros(List<String> nomesMembros) {
        this.nomesMembros = nomesMembros;
    }

    @Override
    public String toString() {
        return "GrupoLiderMembrosDTO{" + "grupoNome=" + grupoNome + ", liderNome=" + liderNome + ", nomesMembros=" + nomesMembros + '}';
    }

}
