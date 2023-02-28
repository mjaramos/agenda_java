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

    System.out.println("##################");
    System.out.println("######OPÇÕES######");
    System.out.println("1 - Criar Contato");
    System.out.println("2 - Criar Evento");
    System.out.println("3 - Visualizar Agenda");
    System.out.println("99 - Sair");
    System.out.println("##################");
    System.out.print("Digite a opção: ");
    int opcao = s.nextInt();

    if(opcao == 1){
      Contato c = contatoService.criarContato();
      listaContatos.add(c);
      agenda.setListaContato(listaContatos);
    } else if(opcao == 2){
      Contato c1 = new Contato();
      c1.setNome("Nome mockado");
      c1.setDtNascimento(LocalDate.now());
      c1.setEndereco("Endereço mockado");
      Evento e = eventoService.criarEvento(c1);
      listaEventos.add(e);
      agenda.setListaEvento(listaEventos);
    } else if(opcao == 3) {
      agendaService.listarAgenda(agenda);
    } else if(opcao == 99) {
      System.exit(0);
    } else {
      System.out.println("Opção inválida!");
    }

    agendaService.listarAgenda(agenda);

    s.close();
  }

}
