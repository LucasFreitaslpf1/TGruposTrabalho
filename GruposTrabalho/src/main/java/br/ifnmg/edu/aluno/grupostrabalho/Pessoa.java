/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifnmg.edu.aluno.grupostrabalho;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Lucas Freitas &lt;lpf1 at ifnmg.edu.br&gt;
 */
@NamedQueries({
    @NamedQuery(
            name = "Pessoa.findAll",
            query = "SELECT p FROM Pessoa p"
    ),
    @NamedQuery(
            name = "Pessoa.findNomeAll",
            query = "SELECT p.nome FROM Pessoa p"
    ),
    @NamedQuery(
            name = "Pessoa.findNomeEndereco",
            query = "SELECT new br.ifnmg.edu.aluno.grupostrabalho.PessoaNomeEnderecoDTO(p.nome, p.endereco) FROM Pessoa p"
    ),
    @NamedQuery(
            name = "Pessoa.findPessoasAvenida",
            query = "SELECT p FROM Pessoa p "
            + "JOIN p.endereco e "
            + "WHERE e.tipoLogradouro = "
            + ":tipo"
    ),
    @NamedQuery(
            name = "Pessoa.findPessoaNaoPraca",
            query = "SELECT p FROM Pessoa p "
            + "JOIN p.endereco e "
            + "WHERE e.tipoLogradouro != "
            + ":tipo"
    ),
    @NamedQuery(
            name = "Pessoa.findPessoaNascimento",
            query = "SELECT p FROM Pessoa p WHERE p.nascimento"
            + " BETWEEN :dataMinima AND :dataMaxima"
    ),
    @NamedQuery(
            name = "Pessoa.findPessoaNaoTelefone",
            query = "SELECT p FROM Pessoa p WHERE p.telefones IS EMPTY"
    ),
    @NamedQuery(
            name = "Pessoa.findPessoaNomeQtdTelefone",
            query = "SELECT p.nome, COUNT(t.id)"
                    + " FROM Pessoa p JOIN p.telefones t GROUP BY p.nome"
    ),
    @NamedQuery(
            name = "Pessoa.findGrupoInativo",
            query = "SELECT g FROM Pessoa p JOIN p.gruposLider g"
                    + " WHERE g.ativo = false"
    )
})
@Entity
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 65)
    private String nome;

    @Column(nullable = false, length = 250)
    private String email;

    @Column(nullable = false)
    private LocalDate nascimento;

    @Transient
    private Byte idade;

    @OneToOne(orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "pessoa",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Atuacao> atuacoes;

    @OneToMany(mappedBy = "lider",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Grupo> gruposLider;

    public Pessoa() {
        telefones = new ArrayList<>();
        atuacoes = new ArrayList<>();
        gruposLider = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;

        idade = (byte) nascimento.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public Byte getIdade() {
        return idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public List<Grupo> getGrupos() {
        return gruposLider;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.gruposLider = grupos;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//</editor-fold>
    
    @Override
    public String toString() {
        return "Pessoa{" 
                + "id=" + id 
                + ", nome=" + nome 
                + ", email=" + email 
                + ", nascimento=" + nascimento 
                + ", idade=" + idade 
                + ", endereco=" + endereco 
                + ", telefones=" + telefones 
                + ", atuacoes=" + atuacoes 
                + '}';
    }

}
