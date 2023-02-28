package enumeration;

public enum SituacaoEventoEnum {
  
  CRIADO(1, "Evento criado."),
  CONCLUIDO(2, "Evento concluído."),
  CANCELADO(3, "Evento cancelado."),
  INDEFINDO("Evento com status indefinido.");

  private int codigo;

  private String descricao;

  public String getDescricao(){
    return descricao;
  }

  public int getCodigo(){
    return codigo;
  }

  SituacaoEventoEnum(String ds){
    descricao = ds;
  }

  SituacaoEventoEnum(int cd, String ds){
    codigo = cd;
    descricao = ds;
  }

}
