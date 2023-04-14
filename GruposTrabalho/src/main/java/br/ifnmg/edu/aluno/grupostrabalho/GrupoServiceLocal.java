/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package br.ifnmg.edu.aluno.grupostrabalho;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lucas Freitas &lt;lpf1 at ifnmg.edu.br&gt;
 */
@Local
public interface GrupoServiceLocal {

    List<GrupoNomeLiderNomeDTO> buscarGruposNomesLiderNomes();

    List<String> buscarNomesMembrosGrupo(String grupo);

    List<Grupo> buscarGruposDoLider(String lider);

    List<Object[]> buscarDatasNomeGrupoMembro(String nome);

    List<Grupo> buscarGrupoNomeParte(String nome);

    List<Object[]> buscarNomesQtdMembros();

    List<Object[]> buscarNomesMaiorQtd(Integer qtd);

    List<String> buscarGrupoDataNome(Integer ano, Long grupoid);

    List<MembroDTO> buscarNomesMembrosInicioParam(Long gid, LocalDate data);

    List<Object[]> buscarNomesMembrosSemTermino();

    List<Object[]> buscarNomeLiderMembros();
    
}
