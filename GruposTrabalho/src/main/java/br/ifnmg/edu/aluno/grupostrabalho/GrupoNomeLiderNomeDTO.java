/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifnmg.edu.aluno.grupostrabalho;

/**
 *
 * @author Lucas
 */
public class GrupoNomeLiderNomeDTO {

    private String grupoNome;
    private String liderNome;

    public GrupoNomeLiderNomeDTO() {
    }

    public GrupoNomeLiderNomeDTO(String grupoNome, String liderNome) {
        this.grupoNome = grupoNome;
        this.liderNome = liderNome;
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

    @Override
    public String toString() {
        return "GrupoNomeLiderNomeDTO{" + "grupoNome=" + grupoNome + ", liderNome=" + liderNome + '}';
    }

}
