package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Agenda;
import entidades.Contato;
import entidades.Evento;
import enumeration.SituacaoEventoEnum;

public class EventoService {

  private ContatoService contatoService;

  private int codigoEvento;

  public ContatoService getContatoService() {
    if(contatoService == null){
      contatoService = new ContatoService();
    }
    return contatoService;
  }
  
  public Evento criarEvento(Agenda a, Scanner s){

    System.out.print("Digite o nome do evento: ");
    s.nextLine();
    String nmEvento = s.nextLine();

    System.out.print("Digite a data do evento(dd/MM/yyyy HH:mm): ");
    String dtEvento = s.nextLine();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime ldt = LocalDateTime.parse(dtEvento, dtf);

    Evento e = new Evento();
    ++codigoEvento;
    e.setCodigo(codigoEvento);
    e.setDtEvento(ldt);
    e.setNomeEvento(nmEvento);
    e.setStatusEvento(SituacaoEventoEnum.CRIADO);
    
    List<Contato> contatosEvento = new ArrayList<Contato>();
    int codigo = 0;
    do{
      System.out.println("Informe os contatos do evento: ");

      for(Contato c : a.getListaContato()){
        System.out.printf("%d - %s \n",c.getCodigo(),c.getNome());
      }

      System.out.print("Digite o código do contato para adicionar(Para sair digite 77): ");
      codigo = s.nextInt();

      if(codigo != 77){

        for(Contato c : a.getListaContato()){

          if(c.getCodigo() == codigo){
            contatosEvento.add(c);
          }

        }

      }

    }while(codigo != 77);

    e.setListaContatos(contatosEvento);
    
    return e;
  }

  public void listarEventosComPessoas(List<Evento> listaEvento) {

    contatoService = getContatoService();
    
    for(Evento evento : listaEvento){
      System.out.println("Código do Evento: "+evento.getCodigo());
      System.out.println("Nome do Evento: "+evento.getNomeEvento());
      System.out.println("Data do Evento: "+evento.getDtEventoFormatado());
      System.out.println("Situação do Evento: "+evento.getStatusEvento().getDescricao());
      System.out.println("###PESSOAS DO EVENTO###");
      contatoService.listarContatos(evento.getListaContatos());
      System.out.println("#######################");
    }
  }

  public void listarEventosSemPessoas(List<Evento> listaEvento) {
    for(Evento evento : listaEvento){
      System.out.println("Código do Evento: "+evento.getCodigo());
      System.out.println("Nome do Evento: "+evento.getNomeEvento());
      System.out.println("Data do Evento: "+evento.getDtEventoFormatado());
      System.out.println("Situação do Evento: "+evento.getStatusEvento().getDescricao());
    }
  }

  public void atualizarEventoConcluido(List<Evento> listaEvento){
    LocalDateTime ld = LocalDateTime.now();
    for(Evento evento : listaEvento){
      if(evento.getStatusEvento().equals(SituacaoEventoEnum.CRIADO) && ld.isAfter(evento.getDtEvento())){
        evento.setStatusEvento(SituacaoEventoEnum.CONCLUIDO);
      }
    }
  }

  public void cancelarEvento(List<Evento> listaEvento, Scanner s){
    System.out.println("####################");
    System.out.println("EVENTOS CRIADOS");
    for(Evento evento : listaEvento){
      if(evento.getStatusEvento().equals(SituacaoEventoEnum.CRIADO)){
        System.out.println("Código do Evento: "+evento.getCodigo());
        System.out.println("Nome do Evento: "+evento.getNomeEvento());
        System.out.println("Data do Evento: "+evento.getDtEventoFormatado());
        System.out.println("Situação do Evento: "+evento.getStatusEvento().getDescricao());
      }
    }
    System.out.println("####################");
    System.out.print("Digite o código do evento para ser cancelado: ");
    int codigo = s.nextInt();

    for(Evento evento : listaEvento){
      if(codigo == evento.getCodigo()){
        evento.setStatusEvento(SituacaoEventoEnum.CANCELADO);
      }
    }
  }

}
