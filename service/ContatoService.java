package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import entidades.Contato;

public class ContatoService {

  private int codigoContato;
  
  public Contato criarContato(Scanner sc){

    System.out.print("Digite seu nome: ");
    sc.nextLine();
    String nome = sc.nextLine();

    System.out.print("Digite seu endereço: ");
    String endereco = sc.nextLine();

    System.out.print("Digite sua data de nascimento(dd/MM/yyyy): ");
    String dtNascimento = sc.next();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate lDtNascimento = LocalDate.parse(dtNascimento, dtf);

    Contato c = new Contato();

    ++codigoContato;

    c.setCodigo(codigoContato);
    c.setNome(nome);
    c.setEndereco(endereco);
    c.setDtNascimento(lDtNascimento);

    return c;
  }

  public void listarContatos(List<Contato> listaContato) {
    for(Contato contato : listaContato){
      System.out.println("Código: "+contato.getCodigo());
      System.out.println("Nome: "+contato.getNome());
      System.out.println("Data Nascimento: "+contato.getDtNascimentoFormatado());
      System.out.println("Endereço: "+contato.getEndereco());
    }
  }

}
