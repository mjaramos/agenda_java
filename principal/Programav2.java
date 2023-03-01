package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Agenda;
import entidades.Contato;
import entidades.Evento;
import service.AgendaService;
import service.ContatoService;
import service.EventoService;

public class Programav2 {
  
  public static void main(String[] args) {
    ContatoService contatoService = new ContatoService();
    EventoService eventoService = new EventoService();
    AgendaService agendaService = new AgendaService();
    
    Scanner s = new Scanner(System.in);
    Agenda agenda = new Agenda();

    List<Contato> listaContatos = new ArrayList<Contato>();
    List<Evento> listaEventos = new ArrayList<Evento>();

    int opcao = 0;
    do{

      System.out.println("##################");
      System.out.println("######OPÇÕES######");
      System.out.println("1 - Criar Contato");
      System.out.println("2 - Criar Evento");
      System.out.println("3 - Visualizar Agenda");
      System.out.println("99 - Sair");
      System.out.println("##################");
      System.out.print("Digite a opção: ");
      opcao = s.nextInt();

      switch(opcao){
        case 1:
          Contato c = contatoService.criarContato(s);
          listaContatos.add(c);
          agenda.setListaContato(listaContatos);
          break;
        case 2:
          Evento e = eventoService.criarEvento(agenda, s);
          listaEventos.add(e);
          agenda.setListaEvento(listaEventos);
          break;
        case 3:
          agendaService.listarAgenda(agenda, s);
          break;
        case 99:
          System.out.println("Volte Sempre!");
          break;
        default:
          System.out.println("Opção inválida!");
      }

    }while(opcao != 99);

    s.close();
  }

}
