/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.ifnmg.edu.aluno.grupostrabalho;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "Relatorios", urlPatterns = {"/Relatorios"})
@Transactional
public class Relatorios extends HttpServlet {

    @Inject
    PessoaServiceLocal psl;

    @Inject
    GrupoServiceLocal gsl;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Relatorios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Relatórios criados com sucesso!</h1>");

            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 1">
            List<Pessoa> ps;
            out.println("<h2>1 - Quais as pessoas (dados completos) cadastradas?</h2>");
            out.println("<h3>Por meio de Query:</h3>");
            out.println("<ul>");
            ps = psl.buscarTodasPessoasQ();
            for (Pessoa p : ps) {
                out.println("<li>" + p + "</li>");
            }
            out.println("</ul>");
            out.println("<h3>Por meio de TypedQuery:</h3>");
            out.println("<ul>");
            ps = psl.buscarTodasPessoasTQ();
            for (Pessoa p : ps) {
                out.println("<li>" + p + "</li>");
            }
            out.println("</ul>");
            out.println("<h4>Por meio de TypedQuery:</h4>");
            out.println("<ul>");
            ps = psl.buscarTodasPessoasNQ();
            for (Pessoa p : ps) {
                out.println("<li>" + p + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 2">
            List<String> nomes;
            out.println("<h2>2 - Quais os nomes das pessoas?</h2>");
            out.println("<h3>Por meio de Query:</h3>");
            out.println("<ul>");
            nomes = psl.buscarNomesPessoas();
            for (String s : nomes) {
                out.println("<li>" + s + "</li>");
            }
            out.println("</ul>");
            out.println("<h3>Por meio de TypedQuery:</h3>");
            out.println("<ul>");
            nomes = psl.buscarNomePessoasTQ();
            for (String s : nomes) {
                out.println("<li>" + s + "</li>");
            }
            out.println("</ul>");
            out.println("<h3>Por meio de NamedQuery:</h3>");
            out.println("<ul>");
            nomes = psl.buscarNomesPessoasNQ();
            for (String s : nomes) {
                out.println("<li>" + s + "</li>");
            }
            out.println("</ul>");

//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 3">
            List<PessoaNomeEnderecoDTO> nomesEnderecos;
            out.println("<h2>3 - Quais as pessoas (nome) e seus respectivos endereços (dados completos)?</h2>");
            out.println("<h3>Por meio de Query:</h3>");
            nomesEnderecos = psl.buscarPessoaNomeEndereco();
            out.println("<ul>");
            for (PessoaNomeEnderecoDTO nomesEndereco : nomesEnderecos) {
                out.println("<li>" + nomesEndereco + "</li>");
            }
            out.println("</ul>");

            out.println("<h3>Por meio de TypedQuery:</h3>");
            nomesEnderecos = psl.buscarPessoaNomeEnderecoTQ();
            out.println("<ul>");
            for (PessoaNomeEnderecoDTO nomesEndereco : nomesEnderecos) {
                out.println("<li>" + nomesEndereco + "</li>");
            }
            out.println("</ul>");

            out.println("<h3>Por meio de NamedQuery:</h3>");
            nomesEnderecos = psl.buscarPessoaNomeEnderecoNQ();
            out.println("<ul>");
            for (PessoaNomeEnderecoDTO nomesEndereco : nomesEnderecos) {
                out.println("<li>" + nomesEndereco + "</li>");
            }
            out.println("</ul>");

//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 4">
            List<Pessoa> pessoaAvenida;
            out.println("<h2>4 - Quais pessoas (dados completos) moram em avenidas?</h2>");
            out.println("<h3>Por meio de Query:</h3>");
            pessoaAvenida = psl.buscarPessoasAvenida();
            out.println("<ul>");
            for (Pessoa pessoa : pessoaAvenida) {
                out.println("<li>" + pessoa.getNome() + " ; "
                        + pessoa.getEndereco().getTipoLogradouro() + "</li>");
            }
            out.println("</ul>");

            out.println("<h3>Por meio de TypedQuery:</h3>");
            pessoaAvenida = psl.buscarPessoasAvenidaTQ();
            out.println("<ul>");
            for (Pessoa pessoa : pessoaAvenida) {
                out.println("<li>" + pessoa.getNome() + " ; "
                        + pessoa.getEndereco().getTipoLogradouro() + "</li>");
            }
            out.println("</ul>");

            out.println("<h3>Por meio de NamedQuery:</h3>");
            pessoaAvenida = psl.buscaPessoasAvenidaNQ();
            out.println("<ul>");
            for (Pessoa pessoa : pessoaAvenida) {
                out.println("<li>" + pessoa.getNome() + " ; "
                        + pessoa.getEndereco().getTipoLogradouro() + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 5">
            List<Pessoa> pessoasNaoPraca;
            out.println("<h2>5 - Quais pessoas (dados completos) não moram em praças?</h2>");
            out.println("<h3>Por meio de Query:</h3>");
            pessoasNaoPraca = psl.buscarPessoasNaoPraca();
            out.println("<ul>");
            for (Pessoa pessoa : pessoasNaoPraca) {
                out.println("<li>" + pessoa.getNome() + " ; "
                        + pessoa.getEndereco().getTipoLogradouro() + "</li>");
            }
            out.println("</ul>");

            out.println("<h3>Por meio de TypedQuery:</h3>");
            pessoasNaoPraca = psl.buscarPessoasNaoPracaTQ();
            out.println("<ul>");
            for (Pessoa pessoa : pessoasNaoPraca) {
                out.println("<li>" + pessoa.getNome() + " ; "
                        + pessoa.getEndereco().getTipoLogradouro() + "</li>");
            }
            out.println("</ul>");

            out.println("<h3>Por meio de NamedQuery:</h3>");
            pessoasNaoPraca = psl.buscaPessoasNaoPracaNQ();
            out.println("<ul>");
            for (Pessoa pessoa : pessoasNaoPraca) {
                out.println("<li>" + pessoa.getNome() + " ; "
                        + pessoa.getEndereco().getTipoLogradouro() + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 6">
            List<Object[]> neobj = psl.buscarPessoasNomesTelefones();
            out.println("<h2>6 - Quais pessoas (nomes) e seus respectivos telefones (dados completos)?</h2>");
            for (Object[] objects : neobj) {
                out.println("<p>" + objects[0] + " ; " + objects[1] + "</p>");
            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 7">
            out.println("<h2>7 - Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004?</h2>");
            List<Pessoa> pessoaNascimento = psl.
                    buscarPessoasNascimento(
                            LocalDate.of(2001, Month.APRIL, 01),
                            LocalDate.of(2004, Month.APRIL, 30)
                    );
            out.println("<ul>");
            for (Pessoa pessoa : pessoaNascimento) {
                out.println("<li>" + pessoa.getNome() + " ; "
                        + pessoa.getNascimento() + "</li>");
            }
            out.println("</ul>");

//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 9">
            out.println("<h2>9 - Quais pessoas (dados completos) não possuem telefone?</h2>");
            List<Pessoa> pessoaNaoTelefone = psl.buscarSemTelefone();
            for (Pessoa pessoa : pessoaNaoTelefone) {
                out.print("<p>" + pessoa.getNome() + " ; " + pessoa.getTelefones() + "</p>");
            }
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 10">
            out.println("<h2>10 - Quantos telefones cada pessoa (nome) tem?</h2>");
            List<Object[]> nomeTelefoneqtd = psl.buscarPessoaNomeQtdTelefone();
            out.println("<ul>");
            for (Object[] pessoa : nomeTelefoneqtd) {
                out.print("<li>" + pessoa[0] + " ; " + pessoa[1] + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 11">
            out.println("<h2>11 - Quais grupos (dados completos) não estão ativos?</h2>");
            List<Grupo> gruposInativos = psl.buscarGruposInativos();
            out.println("<ul>");
            for (Grupo grupo : gruposInativos) {
                out.print("<li>" + grupo + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 12">
            out.println("<h2>12 - Quais são os líderes (nomes) dos grupos (nomes)?</h2>");
            List<GrupoNomeLiderNomeDTO> grupoNomeLiderNome = gsl.buscarGruposNomesLiderNomes();
            out.println("<ul>");
            for (GrupoNomeLiderNomeDTO grupo : grupoNomeLiderNome) {
                out.print("<li>" + grupo + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 13">
            out.println("<h2>13 - Quais são os membros (nomes) do grupo com nome “Estudo IV” com ordenação alfabética "
                    + "inversa?</h2>");
            List<String> grupoNomeMembros = gsl.buscarNomesMembrosGrupo("Estudo IV");
            out.println("<ul>");
            for (String grupo : grupoNomeMembros) {
                out.print("<li>" + grupo + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 14">
            out.println("<h2>14 - Quais são os grupos (dados completos) liderados por “Beatriz Yana”?</h2>");
            List<Grupo> grupoDoLider = gsl.buscarGruposDoLider("Beatriz Yana");
            out.println("<ul>");
            for (Grupo grupo : grupoDoLider) {
                out.print("<li>" + grupo + "</li>");
            }
            out.println("</ul>");

//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 15">
            out.println("<h2>15 - Quais são as datas de início e de término da atuação e os grupos (nomes) nos quais “Cecília"
                    + " Xerxes” é membro?</h2>");
            List<Object[]> datasGrupoNome = gsl.buscarDatasNomeGrupoMembro("Cecília Xerxes");
            out.println("<ul>");
            for (Object[] grupo : datasGrupoNome) {
                out.print("<li>" + "Inicio: " + grupo[0] + " ; "
                        + "Termino: " + grupo[1]
                        + " ; " + "Nome: " + grupo[2] + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 16">
            out.println("<h2>16 - Quais são os grupos (dados completos) que contêm “II” em seus nomes?</h2>");
            List<Grupo> grupoNomeParte = gsl.buscarGrupoNomeParte("II");
            out.println("<ul>");
            for (Grupo grupo : grupoNomeParte) {
                out.print("<li>" + grupo + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 17">
            out.println("<h2>17 - Quais são os grupos (nomes) e os respectivos"
                    + " totais de membros distintos já alocados?</h2>");
            List<Object[]> nomesQtdMembros = gsl.buscarNomesQtdMembros();
            out.println("<ul>");
            for (Object[] nomeqtd : nomesQtdMembros) {
                out.print("<li>" + nomeqtd[0] + " ; " + nomeqtd[1] + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 18">
            out.println("<h2>18 - Quais grupos (nomes) têm 3 ou mais atuações "
                    + "de membros e quanto são esses totais de atuações?</h2>");
            List<Object[]> nomesQtdAtuacoes = gsl.buscarNomesMaiorQtd(3);
            out.println("<ul>");
            for (Object[] nomeqtd : nomesQtdAtuacoes) {
                out.print("<li>" + nomeqtd[0] + " ; " + nomeqtd[1] + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 19">
            out.println("<h2>19 - Quais membros (nomes) entraram a partir de 2012 no primeiro grupo?</h2>");
            List<String> nomeDataGrupo = gsl.buscarGrupoDataNome(2012, 1L);
            out.println("<ul>");
            for (String nome : nomeDataGrupo) {
                out.print("<li>" + nome + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 20">
            out.println("<h2>20 - Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada daqueles que"
                    + " entraram a partir de 2012 em qualquer grupo?</h2>");
            List<MembroDTO> nomeMembroData = gsl
                    .buscarNomesMembrosInicioParam(1L, LocalDate.of(2012, Month.JANUARY, 01));
            out.println("<ul>");
            for (MembroDTO nmd : nomeMembroData) {
                out.print("<li>" + nmd + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 21">
            out.println("<h2>21 - Quais os grupos (nomes) e respectivos membros (nomes)"
                    + "que não possuem data de término de "
                    + "atuação em seus grupos?</h2>");
            List<Object[]> nomeMembroSemTermino = gsl
                    .buscarNomesMembrosSemTermino();
            out.println("<ul>");
            for (Object[] nmst : nomeMembroSemTermino) {
                out.print("<li>" + nmst[0] + " ; " + nmst[1] + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 22">
            out.println("<h2>22 - Quais são os grupos (nomes) e líderes (nomes) com respectivos membros (nomes)?</h2>");
            List<Object[]> nomeLiderMembros = gsl
                    .buscarNomeLiderMembros();
            out.println("<ul>");
            for (Object[] nlm : nomeLiderMembros) {
                out.print("<li> Nome do Grupo: " + nlm[0] + " ; "
                        + "Nome do Lider: " + nlm[1] + " ; "
                        + " Membros: " + nlm[2] + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
