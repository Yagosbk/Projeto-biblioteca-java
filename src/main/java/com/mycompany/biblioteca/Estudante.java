//Nesta classe criamos um estudante para a array list.
//Tambem criamos uma string para ser utilizada mais para frente.
package com.mycompany.biblioteca;

  public class Estudante extends Dados{
  private String RGA;     //Número identificador dos estudantes.
  private String nome;    //Nome do estudante.
  private String curso;   //Curso do estudante.
  private String campus;  //Campus em que o aluno estuda.
  
  //Construtor.
  public Estudante(String num, String nom, String cur, String camp)
  {
    super(num, nom, cur, camp);
    this.RGA = num;
    this.nome = nom;
    this.curso = cur;
    this.campus = camp;
  }
  
  public String pegaRGA(){
        return RGA;
    }
  
  public String pegaNome(){
        return nome;
    }
  
  public String pegaCurso(){
        return curso;
    }
   public String pegaCampus(){
        return campus;
    }

  //Formata os dados do estudante em uma string no formato do arquivo.
  @Override
  public String toString()
{
    return RGA + "/" + nome + "/" + curso + "/" + campus;
}
  //Override da classe abstrata que é utilizado para não ocorrer repetições de estudantes
  @Override
  public Boolean jaExiste(String dataRga)
  {
      return RGA.equals(dataRga);
  }
  
}
