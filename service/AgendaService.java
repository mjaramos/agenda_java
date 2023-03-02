package service;

import java.util.List;
import java.util.Scanner;

import entidades.Agenda;
import entidades.Contato;
import entidades.Evento;

public class AgendaService {

  private ContatoService contatoService;

  private EventoService eventoService;

  public ContatoService getContatoService() {
    if(contatoService == null){
      contatoService = new ContatoService();
    }
    return contatoService;
  }

  public EventoService getEventoService() {
    if(eventoService == null){
      eventoService = new EventoService();
    }
    return eventoService;
  }
  
  public void listarAgenda(Agenda agenda, Scanner s){

    contatoService = getContatoService();
    eventoService = getEventoService();

    System.out.println("##################");
    System.out.println("######OPÇÕES DE LISTA######");
    System.out.println("1 - Listar Contatos");
    System.out.println("2 - Listar Eventos");
    System.out.println("##################");
    System.out.print("Digite a opção: ");
    int opcao = s.nextInt();

    switch(opcao){
      case 1:
        contatoService.listarContatos(agenda.getListaContato());
        break;
      case 2:
        eventoService.listarEventosComPessoas(agenda.getListaEvento());
        break;
      default:
        System.out.println("Opção de listagem invalida!");
    }
    
  }

}
