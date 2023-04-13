/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package br.ifnmg.edu.aluno.grupostrabalho;

import java.time.LocalDate;
import java.time.Month;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Lucas Freitas &lt;lpf1 at ifnmg.edu.br&gt;
 */
@Singleton
@Startup
public class CargaDados implements CargaDadosLocal {

    @Inject
    private PessoaServiceLocal psl;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    @Override
    public void popularBanco() {
        
        //<editor-fold defaultstate="collapsed" desc="Criação dos objetos">
        // Criar pessoas, telefones, atuacoes, enderecos e grupos
        Endereco e1 = new Endereco();
        e1.setBairro("Humberto");
        e1.setLogradouro("Rua 1");
        e1.setNumero(1111);
        e1.setTipoLogradouro(Endereco.TipoLogradouro.RUA);

        Endereco e2 = new Endereco();
        e2.setBairro("Doisberto");
        e2.setLogradouro("Avenida 2");
        e2.setNumero(2222);
        e2.setTipoLogradouro(Endereco.TipoLogradouro.AVENIDA);

        Endereco e3 = new Endereco();
        e3.setBairro("Trêsberto");
        e3.setLogradouro("Avenida 3");
        e3.setNumero(3333);
        e3.setTipoLogradouro(Endereco.TipoLogradouro.AVENIDA);

        Endereco e4 = new Endereco();
        e4.setBairro("Quatroberto");
        e4.setLogradouro("Praca 4");
        e4.setNumero(4444);
        e4.setTipoLogradouro(Endereco.TipoLogradouro.PRACA);

        Telefone t1 = new Telefone();
        t1.setDdd((byte) 11);
        t1.setNumero(11111111);

        Telefone t2 = new Telefone();
        t2.setDdd((byte) 12);
        t2.setNumero(12121212);

        Telefone t3 = new Telefone();
        t3.setDdd((byte) 13);
        t3.setNumero(13131313);

        Telefone t4 = new Telefone();
        t4.setDdd((byte) 22);
        t4.setNumero(22222222);

        Telefone t5 = new Telefone();
        t5.setDdd((byte) 44);
        t5.setNumero(44444444);

        Telefone t6 = new Telefone();
        t6.setDdd((byte) 45);
        t6.setNumero(45454545);

        Atuacao g1a1 = new Atuacao();
        g1a1.setInicio(LocalDate.of(2011, Month.JANUARY, 01));
        g1a1.setTermino(LocalDate.of(2021, Month.NOVEMBER, 11));

        Atuacao g1a2 = new Atuacao();
        g1a2.setInicio(LocalDate.of(2012, Month.JANUARY, 01));
        g1a2.setTermino(LocalDate.of(2022, Month.NOVEMBER, 11));

        Atuacao g1a3 = new Atuacao();
        g1a3.setInicio(LocalDate.of(2012, Month.JANUARY, 02));
        g1a3.setTermino(LocalDate.of(2021, Month.JANUARY, 12));

        Atuacao g1a4 = new Atuacao();
        g1a4.setInicio(LocalDate.of(2013, Month.JANUARY, 03));
        g1a4.setTermino(LocalDate.of(2021, Month.JANUARY, 13));

        Atuacao g1a5 = new Atuacao();
        g1a5.setInicio(LocalDate.of(2014, Month.JANUARY, 04));
        g1a5.setTermino(LocalDate.of(2021, Month.NOVEMBER, 14));

        Atuacao g2a1 = new Atuacao();
        g2a1.setInicio(LocalDate.of(2012, Month.JANUARY, 02));

        Atuacao g2a2 = new Atuacao();
        g2a2.setInicio(LocalDate.of(2012, Month.JANUARY, 02));

        Atuacao g3a1 = new Atuacao();
        g3a1.setInicio(LocalDate.of(2012, Month.JANUARY, 03));
        g3a1.setTermino(LocalDate.of(2023, Month.JANUARY, 13));

        Atuacao g3a2 = new Atuacao();
        g3a2.setInicio(LocalDate.of(2012, Month.JANUARY, 03));
        g3a2.setTermino(LocalDate.of(2023, Month.JANUARY, 13));
       
        Atuacao g4a1 = new Atuacao();
        g4a1.setInicio(LocalDate.of(2012, Month.JANUARY, 04));
        g4a1.setTermino(LocalDate.of(2024, Month.JANUARY, 14));
       
        Atuacao g4a2 = new Atuacao();
        g4a2.setInicio(LocalDate.of(2012, Month.JANUARY, 04));
        g4a2.setTermino(LocalDate.of(2024, Month.JANUARY, 14));
       
        Atuacao g4a3 = new Atuacao();
        g4a3.setInicio(LocalDate.of(2012, Month.JANUARY, 04));
        g4a3.setTermino(LocalDate.of(2024, Month.JANUARY, 14));
        
        Grupo g1 = new Grupo();
        g1.setAtivo(false);
        g1.getAtuacoes().add(g1a1);
        g1.getAtuacoes().add(g1a2);
        g1.getAtuacoes().add(g1a3);
        g1.getAtuacoes().add(g1a4);
        g1.getAtuacoes().add(g1a5);
        g1.setNome("Estudo I");
        g1a1.setGrupo(g1);
        g1a2.setGrupo(g1);
        g1a3.setGrupo(g1);
        g1a4.setGrupo(g1);
        g1a5.setGrupo(g1);

        Grupo g2 = new Grupo();
        g2.setAtivo(true);
        g2.getAtuacoes().add(g2a1);
        g2.getAtuacoes().add(g2a2);
        g2.setNome("Estudo II");
        g2a1.setGrupo(g2);
        g2a2.setGrupo(g2);

        Grupo g3 = new Grupo();
        g3.setAtivo(false);
        g3.getAtuacoes().add(g3a1);
        g3.getAtuacoes().add(g3a2);
        g3.setNome("Estudo III");
        g3a1.setGrupo(g3);
        g3a2.setGrupo(g3);

        Grupo g4 = new Grupo();
        g4.setAtivo(true);
        g4.getAtuacoes().add(g4a1);
        g4.getAtuacoes().add(g4a2);
        g4.getAtuacoes().add(g4a3);
        g4.setNome("Estudo IV");
        g4a1.setGrupo(g4);
        g4a2.setGrupo(g4);
        g4a3.setGrupo(g4);

        Pessoa p1 = new Pessoa();
        p1.setNome("Ana Zaira");
        p1.setEmail("ana@mail.com");
        p1.setNascimento(LocalDate.of(2001, Month.JANUARY, 01));
        p1.getTelefones().add(t1);
        p1.getTelefones().add(t2);
        p1.getTelefones().add(t3);
        p1.getAtuacoes().add(g1a1);
        p1.getAtuacoes().add(g1a2);
        g1a1.setPessoa(p1);
        g1a2.setPessoa(p1);
        p1.setEndereco(e1);

        Pessoa p2 = new Pessoa();
        p2.setNome("Beatriz Yana");
        p2.setEmail("beatriz@mail.com");
        p2.setNascimento(LocalDate.of(2002, Month.FEBRUARY, 02));
        p2.getTelefones().add(t3);
        p2.getAtuacoes().add(g1a3);
        p2.getAtuacoes().add(g2a1);
        p2.getAtuacoes().add(g4a1);
        g1a3.setPessoa(p2);
        g2a1.setPessoa(p2);
        g4a1.setPessoa(p2);
        p2.setEndereco(e2);
        
        Pessoa p3 = new Pessoa();
        p3.setNome("Cecília Xerxes");
        p3.setEmail("cecilia@mail.com");
        p3.setNascimento(LocalDate.of(2003, Month.MARCH, 03));
        p3.getAtuacoes().add(g1a4);
        p3.getAtuacoes().add(g3a1);
        p3.getAtuacoes().add(g4a2);
        g1a4.setPessoa(p3);
        g3a1.setPessoa(p3);
        g4a2.setPessoa(p3);
        p3.setEndereco(e3);

        Pessoa p4 = new Pessoa();
        p4.setNome("Débora Wendel");
        p4.setEmail("debora@mail.com");
        p4.setNascimento(LocalDate.of(2004, Month.APRIL, 04));
        p4.getTelefones().add(t5);
        p4.getTelefones().add(t6);
        p4.getAtuacoes().add(g1a4);
        p4.getAtuacoes().add(g2a2);
        p4.getAtuacoes().add(g3a2);
        p4.getAtuacoes().add(g4a3);
        g1a4.setPessoa(p4);
        g2a2.setPessoa(p4);
        g3a2.setPessoa(p4);
        g4a3.setPessoa(p4);
        p4.setEndereco(e4);
        
        g1.setLider(p1);
        g2.setLider(p2);
        g3.setLider(p3);
        g4.setLider(p2);

        System.out.println("TESTE");
//</editor-fold>

        // Salvar pessoas
        psl.salvar(p1);
        psl.salvar(p2);
    }
}
