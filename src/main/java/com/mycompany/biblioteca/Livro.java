//Nesta classe criamos um livro para a array list.
//Tambem criamos uma string para ser utilizada mais para frente.
package com.mycompany.biblioteca;

public class Livro extends Dados{
    private String ISBN;  //Número identificador dos livros.
    private String autor; //Nome do autor.
    private String titulo;//Título do livro.
    private String local; //O local da biblioteca que tem o livro.
    
    //Construtor.
    public Livro(String num, String aut, String tit, String loc)
    {
        super(num, aut, tit, loc);
        this.ISBN = num;
        this.autor = aut;
        this.titulo = tit;
        this.local = loc;
    }
    
    public String pegaISBN(){
        return ISBN;
    }
    
    public String pegaAutor(){
        return autor;
    }
    
    public String pegaTitulo(){
        return titulo;
    }
    
    public String pegaLocal(){
        return local;
    }
    
   //Formata os dados do livro em uma string no formato do arquivo.
    @Override
    public String toString()
    {
        return ISBN + "/" + autor + "/" + titulo + "/" + local;
    }
    
    //Override da classe abstrata que é utilizado para não ocorrer repetições de livros
    @Override
     public Boolean jaExiste(String dataRga)
  {
        return ISBN.equals(dataRga);
  }
}
