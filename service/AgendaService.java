package service;

import entidades.Agenda;

public class AgendaService {
  
  public void listarAgenda(Agenda agenda){

    if(agenda.getListaContato() != null && agenda.getListaContato().size() > 0){
      System.out.println("Contatos");
      System.out.println("Nome: "+agenda.getListaContato().get(0).getNome());
      System.out.println("Data Nascimento: "+agenda.getListaContato().get(0).getDtNascimentoFormatado());
      System.out.println("Endereço: "+agenda.getListaContato().get(0).getEndereco());
    }

    if(agenda.getListaEvento() != null && agenda.getListaEvento().size() > 0){
      System.out.println("Eventos");
      System.out.println("Nome do Evento: "+agenda.getListaEvento().get(0).getNomeEvento());
      System.out.println("Data do Evento: "+agenda.getListaEvento().get(0).getDtEventoFormatado());
      System.out.println("Nome Pessoa do Evento: "+agenda.getListaEvento().get(0).getListaContatos().get(0).getNome());
      System.out.println("Endereço Pessoa do Evento: "+agenda.getListaEvento().get(0).getListaContatos().get(0).getEndereco());
      System.out.println("Dt nascimento Pessoa do Evento: "+agenda.getListaEvento().get(0).getListaContatos().get(0).getDtNascimentoFormatado());
    }
    
  }

}
