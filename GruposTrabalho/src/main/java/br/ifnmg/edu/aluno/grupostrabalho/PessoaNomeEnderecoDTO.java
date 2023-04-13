/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifnmg.edu.aluno.grupostrabalho;

/**
 *
 * @author Lucas
 */
public class PessoaNomeEnderecoDTO {
    private String nome;
    private Endereco endereco;

    public PessoaNomeEnderecoDTO(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public PessoaNomeEnderecoDTO() {
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "PessoaNomeEndereco{" + "nome=" + nome + ", endereco=" + endereco + '}';
    }
    
    
}
