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
  
  public Evento criarEvento(Agenda a, Scanner s){

    System.out.print("Digite o nome do evento: ");
    String nmEvento = s.next();

    s.nextLine();
    System.out.print("Digite a data do evento(dd/MM/yyyy HH:mm): ");
    String dtEvento = s.nextLine();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime ldt = LocalDateTime.parse(dtEvento, dtf);

    Evento e = new Evento();
    e.setDtEvento(ldt);
    e.setNomeEvento(nmEvento);
    e.setStatusEvento(SituacaoEventoEnum.CRIADO);
    
    List<Contato> contatosEvento = new ArrayList<Contato>();
    String nome = "";
    do{
      System.out.println("Informe os contatos do evento: ");

      for(Contato c : a.getListaContato()){
        System.out.printf("Contato %s \n",c.getNome());
      }

      System.out.print("Digite o contato para adicionar(Para sair digite 77): ");
      nome = s.next();

      if(!nome.equals("77")){

        for(Contato c : a.getListaContato()){

          if(c.getNome().equals(nome)){
            contatosEvento.add(c);
          }

        }

      }

    }while(!nome.equals("77"));

    e.setListaContatos(contatosEvento);
    
    return e;
  }

}
