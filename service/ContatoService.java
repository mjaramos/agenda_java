package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entidades.Contato;

public class ContatoService {
  
  public Contato criarContato(){

    Scanner sc = new Scanner(System.in);

    System.out.print("Digite seu nome: ");
    String nome = sc.nextLine();

    System.out.print("Digite seu endereço: ");
    String endereco = sc.nextLine();

    System.out.print("Digite sua data de nascimento(dd/MM/yyyy): ");
    String dtNascimento = sc.nextLine();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate lDtNascimento = LocalDate.parse(dtNascimento, dtf);

    Contato c = new Contato();
    c.setNome(nome);
    c.setEndereco(endereco);
    c.setDtNascimento(lDtNascimento);

    sc.close();

    return c;
  }

}
