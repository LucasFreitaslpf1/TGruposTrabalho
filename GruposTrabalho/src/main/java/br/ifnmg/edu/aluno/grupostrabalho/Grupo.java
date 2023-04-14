/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifnmg.edu.aluno.grupostrabalho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Lucas Freitas &lt;lpf1 at ifnmg.edu.br&gt;
 */
@NamedQueries({
    @NamedQuery(
            name = "Grupo.findNomeGrupoLider",
            query = "SELECT new br.ifnmg.edu.aluno"
            + ".grupostrabalho.GrupoNomeLiderNomeDTO(g.nome,l.nome)"
            + " FROM Grupo g JOIN g.lider l"
    ),

    @NamedQuery(
            name = "Grupo.buscarGrupoDoLider",
            query = "SELECT g FROM Grupo g WHERE "
            + "g.lider.nome = :nome"
    ),
    @NamedQuery(
            name = "Grupo.findGrupoNomeParte",
            query = "SELECT g FROM Grupo g "
            + "WHERE g.nome LIKE CONCAT('%', :nome , '%')"
    ),
    @NamedQuery(
            name = "Grupo.findNomeQtdMembros",
            query = "SELECT g.nome, COUNT(DISTINCT p.id)"
            + " FROM Grupo g"
            + " JOIN g.atuacoes a"
            + " JOIN a.pessoa p"
            + " GROUP BY g.id, g.nome"
    ),
    @NamedQuery(
            name = "Grupo.findNomesQtdAtuacoes",
            query = "SELECT g.nome, COUNT(DISTINCT a.id)"
                    + " FROM Grupo g JOIN g.atuacoes a"
                    + " WHERE SIZE(g.atuacoes) >= :qtd"
                    + " GROUP BY g.id, g.nome"
    ),
    
    //Quais membros (nomes) entraram a partir de 2012 no primeiro grupo?
    @NamedQuery(
            name = "Grupo.findMembrosAPartirData",
            query = "SELECT DISTINCT p.nome FROM Atuacao a"
                    + " JOIN a.pessoa p"
                    + " JOIN a.grupo g"
                    + " WHERE EXTRACT(YEAR FROM a.inicio) >= :ano"
                    + " AND g.id = :id"
    ),
//    Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada daqueles que
//    entraram a partir de 2012 em qualquer grupo?
    @NamedQuery(
            name = "Grupo.findNomesMembrosEntradaParam",
            query = "SELECT new br.ifnmg.edu.aluno.grupostrabalho.MembroDTO(g.nome, p.nome, a.inicio)"
                    + " FROM Atuacao a"
                    + " JOIN a.pessoa p"
                    + " JOIN a.grupo g"
                    + " WHERE a.inicio >= :data"
                    + " AND g.id = :gid"
                    + " ORDER BY g.nome, a.inicio"
    ),
//    Quais os grupos (nomes) e respectivos membros (nomes) que não possuem data de término de
//    atuação em seus grupos?
    @NamedQuery(
            name = "Grupo.nomeMembroSemTermino",
            query = "SELECT g.nome, p.nome FROM Atuacao a"
                    + " JOIN a.pessoa p"
                    + " JOIN a.grupo g "
                    + " WHERE a.termino IS NULL"
    ),
    //Quais são os grupos (nomes) e líderes (nomes) com respectivos membros (nomes)?
    @NamedQuery(
            name = "Grupo.findNomeLiderMembros",
            query = "SELECT DISTINCT g.nome, l.nome, p.nome FROM Grupo g"
                    + " JOIN g.atuacoes a"
                    + " JOIN a.pessoa p"
                    + " JOIN g.lider l"
                    + " WHERE a.grupo.nome = g.nome"
                    + " ORDER BY g.nome, l.nome, p.nome"
    )
})
@Entity
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 65)
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lider_id")
    private Pessoa lider;

    @Column(nullable = false)
    private Boolean ativo = true;

    @OneToMany(mappedBy = "grupo",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Atuacao> atuacoes;

    public Grupo() {
        atuacoes = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="GS">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public Pessoa getLider() {
        return lider;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
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
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//</editor-fold>
    @Override
    public String toString() {
        return "Grupo{"
                + "id=" + id
                + ", nome=" + nome
                + ", lider=" + lider.getNome()
                + ", ativo=" + ativo
                + '}';
    }

}
