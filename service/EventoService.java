package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Contato;
import entidades.Evento;
import enumeration.SituacaoEventoEnum;

public class EventoService {
  
  public Evento criarEvento(Contato c){

    Scanner s = new Scanner(System.in);

    System.out.print("Digite o nome do evento: ");
    String nmEvento = s.nextLine();

    System.out.print("Digite a data do evento(dd/MM/yyyy HH:mm): ");
    String dtEvento = s.nextLine();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime ldt = LocalDateTime.parse(dtEvento, dtf);

    Evento e = new Evento();
    e.setDtEvento(ldt);
    e.setNomeEvento(nmEvento);
    e.setStatusEvento(SituacaoEventoEnum.CRIADO);

    List<Contato> contatosEvento = new ArrayList<Contato>();
    contatosEvento.add(c);
    e.setListaContatos(contatosEvento);

    s.close();
    
    return e;
  }

}
