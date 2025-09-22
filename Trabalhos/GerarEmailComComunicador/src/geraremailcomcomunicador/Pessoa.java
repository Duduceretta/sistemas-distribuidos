/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geraremailcomcomunicador;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {
    String nome;
    String email;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    public static Pessoa gerarEmail(String nomeCompleto){
        String nomePessoa = nomeCompleto;                    
        String vetorNome [] = nomePessoa.split(" ");
        String email = vetorNome[0] + "." + vetorNome[vetorNome.length-1] +
                "@ufn.edu.br";
        
        nomePessoa = nomePessoa.toUpperCase();
        email = email.toLowerCase();

        Pessoa pessoaComEmail = new Pessoa(nomePessoa, email);        
        return pessoaComEmail;
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

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.nome, other.nome);
    }

}