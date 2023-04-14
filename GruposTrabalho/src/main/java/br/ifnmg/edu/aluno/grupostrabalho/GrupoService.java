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

/**
 *
 * @author Lucas Freitas &lt;lpf1 at ifnmg.edu.br&gt;
 */
@Stateless
public class GrupoService implements GrupoServiceLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<GrupoNomeLiderNomeDTO> buscarGruposNomesLiderNomes() {
        return em.createNamedQuery("Grupo.findNomeGrupoLider", GrupoNomeLiderNomeDTO.class)
                .getResultList();
    }

    @Override
    public List<String> buscarNomesMembrosGrupo(String grupo) {

        return em.createNamedQuery("Atuacao.findMembrosGrupo", String.class)
                .setParameter("grupo", grupo)
                .getResultList();
    }

    @Override
    public List<Grupo> buscarGruposDoLider(String lider) {

        return em.createNamedQuery("Grupo.buscarGrupoDoLider", Grupo.class)
                .setParameter("nome", lider)
                .getResultList();
    }

    @Override
    public List<Object[]> buscarDatasNomeGrupoMembro(String nome) {
        return em.createNamedQuery("Atuacao.findDatasNomeGrupoMembro", Object[].class)
                .setParameter("nome", nome)
                .getResultList();
    }

    @Override
    public List<Grupo> buscarGrupoNomeParte(String nome) {
        return em.createNamedQuery("Grupo.findGrupoNomeParte", Grupo.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    @Override
    public List<Object[]> buscarNomesQtdMembros() {
        return em.createNamedQuery("Grupo.findNomeQtdMembros", Object[].class)
                .getResultList();
    }

    @Override
    public List<Object[]> buscarNomesMaiorQtd(Integer qtd) {

        return em.createNamedQuery("Grupo.findNomesQtdAtuacoes", Object[].class)
                .setParameter("qtd", qtd)
                .getResultList();
    }

    @Override
    public List<String> buscarGrupoDataNome(Integer ano, Long grupoid) {
        return em.createNamedQuery("Grupo.findMembrosAPartirData", String.class)
                .setParameter("ano", ano)
                .setParameter("id", grupoid)
                .getResultList();
    }

    @Override
    public List<MembroDTO> buscarNomesMembrosInicioParam(Long gid, LocalDate data) {
        return em.createNamedQuery("Grupo.findNomesMembrosEntradaParam", MembroDTO.class)
                .setParameter("gid", gid)
                .setParameter("data", data)
                .getResultList();
    }

    @Override
    public List<Object[]> buscarNomesMembrosSemTermino() {
        return em.createNamedQuery("Grupo.nomeMembroSemTermino",Object[].class)
                .getResultList();
    }

    @Override
    public List<Object[]> buscarNomeLiderMembros() {
        return em.createNamedQuery("Grupo.findNomeLiderMembros",Object[].class)
                .getResultList();
    }
    
    

}
