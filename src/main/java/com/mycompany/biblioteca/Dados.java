package com.mycompany.biblioteca;


public abstract class Dados {
   
  private String ID;             //Número identificador dos estudantes.
  private String nome_autor;     //Nome do estudante ou do livro.
  private String curso_titulo;   //Curso do estudante ou titulo do livro.
  private String campus_local;   //Local onde o estudante ou o livro
    
  public Dados(String id, String n, String ct, String cl)
  {
      this.ID = id;
      this.nome_autor = n;
      this.curso_titulo = ct;
      this.campus_local = cl;
  }    
    public abstract Boolean jaExiste(String dado);
}
