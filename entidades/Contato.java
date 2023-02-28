package entidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Contato {
  
  private String nome;

  private LocalDate dtNascimento;

  private String endereco;

  public LocalDate getDtNascimento() {
    return dtNascimento;
  }

  public String getDtNascimentoFormatado(){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return dtNascimento.format(dtf);
  }

  public int idade(){
    LocalDate ldAtual = LocalDate.now();

    Period p = Period.between(dtNascimento, ldAtual);

    return p.getYears();
  }

  public String getEndereco() {
    return endereco;
  }

  public String getNome() {
    return nome;
  }

  public void setDtNascimento(LocalDate dtNascimento) {
    this.dtNascimento = dtNascimento;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
