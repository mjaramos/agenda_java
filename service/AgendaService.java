package service;

import java.util.Scanner;

import entidades.Agenda;
import entidades.Contato;
import entidades.Evento;

public class AgendaService {
  
  public void listarAgenda(Agenda agenda, Scanner s){

    System.out.println("##################");
    System.out.println("######OPÇÕES DE LISTA######");
    System.out.println("1 - Listar Contatos");
    System.out.println("2 - Listar Eventos");
    System.out.println("##################");
    System.out.print("Digite a opção: ");
    int opcao = s.nextInt();

    switch(opcao){
      case 1:
        listarContatos(agenda);
        break;
      case 2:
        listarEventos(agenda);
        break;
      default:
        System.out.println("Opção de listagem invalida!");
    }
    
  }

  static void listarContatos(Agenda a) {
    for(Contato contato : a.getListaContato()){
      System.out.println("Nome: "+contato.getNome());
      System.out.println("Data Nascimento: "+contato.getDtNascimentoFormatado());
      System.out.println("Endereço: "+contato.getEndereco());
    }
  }

  static void listarEventos(Agenda a) {
    for(Evento evento : a.getListaEvento()){
      System.out.println("Nome do Evento: "+evento.getNomeEvento());
      System.out.println("Data do Evento: "+evento.getDtEventoFormatado());
      for(Contato contato : evento.getListaContatos()){
        System.out.println("Nome Pessoa do Evento: "+contato.getNome());
      }
    }
  }

}
