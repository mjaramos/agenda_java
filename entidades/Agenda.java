package entidades;

import java.util.List;

public class Agenda {
  
  private List<Contato> listaContato;

  private List<Evento> listaEvento;

  public List<Contato> getListaContato() {
    return listaContato;
  }

  public List<Evento> getListaEvento() {
    return listaEvento;
  }

  public void setListaContato(List<Contato> listaContato) {
    this.listaContato = listaContato;
  }

  public void setListaEvento(List<Evento> listaEvento) {
    this.listaEvento = listaEvento;
  }

}
