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
public interface PessoaServiceLocal {

    void salvar(Pessoa pessoa);

    List<Pessoa> buscarTodasPessoasQ();

    List<Pessoa> buscarTodasPessoasTQ();

    List<Pessoa> buscarTodasPessoasNQ();

    List<String> buscarNomesPessoas();

    List<String> buscarNomePessoasTQ();

    List<String> buscarNomesPessoasNQ();

    List<PessoaNomeEnderecoDTO> buscarPessoaNomeEndereco();

    List<PessoaNomeEnderecoDTO> buscarPessoaNomeEnderecoTQ();

    List<PessoaNomeEnderecoDTO> buscarPessoaNomeEnderecoNQ();

    List<Pessoa> buscarPessoasAvenida();

    List<Pessoa> buscarPessoasAvenidaTQ();

    List<Pessoa> buscaPessoasAvenidaNQ();

    List<Pessoa> buscarPessoasNaoPraca();

    List<Pessoa> buscarPessoasNaoPracaTQ();

    List<Pessoa> buscaPessoasNaoPracaNQ();

    List<Object[]> buscarPessoasNomesTelefones();

    List<Pessoa> buscarPessoasNascimento(LocalDate dataMinima, LocalDate dataMaxima);

    List<Pessoa> buscarSemTelefone();

    List<Object[]> buscarPessoaNomeQtdTelefone();

    List<Grupo> buscarGruposInativos();

}
