/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifnmg.edu.aluno.grupostrabalho;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lucas Freitas &lt;lpf1 at ifnmg.edu.br&gt;
 */
@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String logradouro;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false, length = 25)
    private String bairro;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoLogradouro tipoLogradouro;

    //<editor-fold defaultstate="collapsed" desc="GS">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ETC">
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id 
                + ", logradouro=" + logradouro 
                + ", numero=" + numero 
                + ", bairro=" + bairro 
                + ", tipoLogradouro=" + tipoLogradouro 
                + '}';
    }

//</editor-fold>
    public enum TipoLogradouro {
        RUA,
        AVENIDA,
        PRACA,
        OUTRO;
    }
}
