package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import enumeration.SituacaoEventoEnum;

public class Evento {

  private int codigo;
  
  private String nomeEvento;

  private LocalDateTime dtEvento;

  private List<Contato> listaContatos;

  private SituacaoEventoEnum statusEvento;

  public LocalDateTime getDtEvento() {
    return dtEvento;
  }

  public String getDtEventoFormatado(){
    String dtFormatado = "";

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    dtFormatado = getDtEvento().format(dtf);

    return dtFormatado;
  }

  public List<Contato> getListaContatos() {
    return listaContatos;
  }

  public String getNomeEvento() {
    return nomeEvento;
  }

  public SituacaoEventoEnum getStatusEvento() {
    return statusEvento;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setDtEvento(LocalDateTime dtEvento) {
    this.dtEvento = dtEvento;
  }

  public void setListaContatos(List<Contato> listaContatos) {
    this.listaContatos = listaContatos;
  }

  public void setNomeEvento(String nomeEvento) {
    this.nomeEvento = nomeEvento;
  }

  public void setStatusEvento(SituacaoEventoEnum statusEvento) {
    this.statusEvento = statusEvento;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

}
