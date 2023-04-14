/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package br.ifnmg.edu.aluno.grupostrabalho;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lucas Freitas &lt;lpf1 at ifnmg.edu.br&gt;
 */
@Stateless
public class PessoaService implements PessoaServiceLocal {

    @PersistenceContext
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void salvar(Pessoa pessoa) {
        em.persist(pessoa);
    }

    //<editor-fold defaultstate="collapsed" desc="TodasPessoas">
    @Override
    public List<Pessoa> buscarTodasPessoasQ() {
        Query q = em.createQuery("SELECT p FROM Pessoa p");

        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> buscarTodasPessoasTQ() {
        TypedQuery q = em.createQuery("SELECT p FROM Pessoa p", Pessoa.class);

        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscarTodasPessoasNQ() {
        return em.createNamedQuery("Pessoa.findAll", Pessoa.class)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="NomesPessoas">
    @Override
    public List<String> buscarNomesPessoas() {

        return (List<String>) em.createQuery("SELECT p.nome FROM Pessoa p")
                .getResultList();
    }

    @Override
    public List<String> buscarNomePessoasTQ() {
        return em.createQuery("SELECT p.nome FROM Pessoa p", String.class)
                .getResultList();
    }

    @Override
    public List<String> buscarNomesPessoasNQ() {
        return em.createNamedQuery("Pessoa.findNomeAll", String.class)
                .getResultList();
    }
//</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc="NomeEndereco">

    @Override
    public List<PessoaNomeEnderecoDTO> buscarPessoaNomeEndereco() {

        return (List<PessoaNomeEnderecoDTO>) em.createQuery("SELECT new "
                + "br.ifnmg.edu.aluno.grupostrabalho.PessoaNomeEnderecoDTO(p.nome, p.endereco)"
                + " FROM Pessoa p").getResultList();
    }

    @Override
    public List<PessoaNomeEnderecoDTO> buscarPessoaNomeEnderecoTQ() {
        return em.createQuery("SELECT new "
                + "br.ifnmg.edu.aluno.grupostrabalho.PessoaNomeEnderecoDTO(p.nome, p.endereco)"
                + " FROM Pessoa p", PessoaNomeEnderecoDTO.class)
                .getResultList();
    }

    @Override
    public List<PessoaNomeEnderecoDTO> buscarPessoaNomeEnderecoNQ() {
        return em.createNamedQuery("Pessoa.findNomeEndereco", PessoaNomeEnderecoDTO.class)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="PessoasAvenida">
    @Override
    public List<Pessoa> buscarPessoasAvenida() {
        Query q = em.createQuery("SELECT p FROM Pessoa p "
                + "JOIN p.endereco e "
                + "WHERE e.tipoLogradouro = "
                + ":tipo");

        q.setParameter("tipo", Endereco.TipoLogradouro.AVENIDA);

        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> buscarPessoasAvenidaTQ() {
        TypedQuery q = em.createQuery("SELECT p FROM Pessoa p "
                + "JOIN p.endereco e "
                + "WHERE e.tipoLogradouro = "
                + ":tipo", Pessoa.class);
        q.setParameter("tipo", Endereco.TipoLogradouro.AVENIDA);

        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscaPessoasAvenidaNQ() {
        TypedQuery q = em.createNamedQuery("Pessoa.findPessoasAvenida", Pessoa.class);
        q.setParameter("tipo", Endereco.TipoLogradouro.AVENIDA);
        return q.getResultList();
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="PessoasNaoPraca">

    @Override
    public List<Pessoa> buscarPessoasNaoPraca() {
        Query q = em.createQuery("SELECT p FROM Pessoa p "
                + "JOIN p.endereco e "
                + "WHERE e.tipoLogradouro != "
                + ":tipo");
        q.setParameter("tipo", Endereco.TipoLogradouro.PRACA);
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> buscarPessoasNaoPracaTQ() {
        TypedQuery q = em.createQuery("SELECT p FROM Pessoa p "
                + "JOIN p.endereco e "
                + "WHERE e.tipoLogradouro != "
                + ":tipo", Pessoa.class);
        q.setParameter("tipo", Endereco.TipoLogradouro.PRACA);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscaPessoasNaoPracaNQ() {
        TypedQuery q = em.createNamedQuery("Pessoa.findPessoaNaoPraca", Pessoa.class);
        q.setParameter("tipo", Endereco.TipoLogradouro.PRACA);
        return q.getResultList();
    }
//</editor-fold>

    @Override
    public List<Object[]> buscarPessoasNomesTelefones() {
        Query q = em.createQuery("SELECT p.nome, t FROM Pessoa p JOIN p.telefones t");
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Pessoa> buscarPessoasNascimento(LocalDate dataMinima, LocalDate dataMaxima) {
        TypedQuery q = em.createNamedQuery("Pessoa.findPessoaNascimento", Pessoa.class);
        q.setParameter("dataMinima", dataMinima);
        q.setParameter("dataMaxima", dataMaxima);
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> buscarSemTelefone() {
        return em.createNamedQuery("Pessoa.findPessoaNaoTelefone", Pessoa.class)
                .getResultList();
    }

    @Override
    public List<Object[]> buscarPessoaNomeQtdTelefone() {

        Query q = em.createNamedQuery("Pessoa.findPessoaNomeQtdTelefone", Object[].class);

        return q.getResultList();
    }

    @Override
    public List<Grupo> buscarGruposInativos() {
        return em.createNamedQuery("Pessoa.findGrupoInativo", Grupo.class)
                .getResultList();
    }

}
