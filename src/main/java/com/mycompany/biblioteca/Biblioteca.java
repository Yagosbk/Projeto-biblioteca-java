//Nesta classe nos temos a array list de estudantes e livros
//Com esses dois podemos adicionar mais alunos ou estudantes
//demonstrar a lista completa dos dois, achar estudantes ou alunos
//e checar se o aluno tem o livro disponível em seu campus.

package com.mycompany.biblioteca;
import java.io.*;
import java.util.ArrayList;


public class Biblioteca {
  private final ArrayList<Livro> catalogo = new ArrayList<Livro>();//Guarda os livros
  private final ArrayList<Estudante> estudantes = new ArrayList<Estudante>();//Guarda os alunos

 //Aqui nos recebemos os estudantes do arquivo "Estudantes.txt". 
 public void recebeEstudantes(){
    String linha;
    
    try {
      //Cria um leitor de arquivos  .
      FileReader leitor = new FileReader("Estudantes.txt");
        
        try (
                //Utilizando o bufferedReader nos passamos os caracteres um por um
                //e colocamos em buffer até ele encontrar o fim da linha
                //assim transformando uma linha em uma string unica.
                BufferedReader bufferedReader = new BufferedReader(leitor)) 
        {
            
            //Neste momento guardamos cada uma das linhas em um objeto Estudante.
            while ((linha = bufferedReader.readLine()) != null) 
            {
                
                //Decidimos aqui que a divisão é feita pelo "/ ".
                String[] string = linha.split("/");
                
                //O formato utilizado é (RGA, nome, curso, campus).
                Estudante estudante = new Estudante(string[0], string[1], string[2], string[3]);
                estudantes.add(estudante);
            }
        }
    }
    //Avisa caso o arquivo estja no diretório errado
    catch(FileNotFoundException ex) {
      System.out.println("Nao foi possivel abrir o arquivo, garanta que ele está no diretório certo");                
    }
    //Avisa caso o arquivo esteja no formato errado
    catch(IOException ex) {
      System.out.println("Nao foi possivel ler o arquivo, garanta que ele esteja no formato certo");                  
    }    
 }
 
 //Aqui nos recebemos os estudantes do arquivo "Livros.txt". 
 public void recebeLivros(){
    String linha;
    
    try {
      //Cria um leitor de arquivos
      FileReader leitor = new FileReader("Livros.txt");
      
        try (
                
                //Utilizando o bufferedReader nos passamos os caracteres um por um
                //e colocamos em buffer até ele encontrar o fim da linha
                //assim transformando uma linha em uma string unica.
                BufferedReader bufferedReader = new BufferedReader(leitor)) 
        {
           
            //Neste momento guardamos cada uma das linhas em um objeto Livro.
            while ((linha = bufferedReader.readLine()) != null) 
            {
                
                //Decidimos aqui que a divisão é feita pelo "/ ".
                String[] string = linha.split("/");
                
                //O formato utilizado é (ISBN, autor, local, titulo).
                Livro livro = new Livro(string[0], string[1], string[2], string[3]);
                catalogo.add(livro);
            }
        }
    }
    //Avisa que o arquivo está no diretorio errado.
    catch(FileNotFoundException ex) {
      System.out.println("Nao foi possivel abrir o arquivo, garanta que ele está no diretório certo");                
    }
    //Avisa caso o arquivo esteja no formato errado.
    catch(IOException ex) {
      System.out.println("Nao foi possivel ler o arquivo, garanta que ele esteja no formato certo");                  
    }    
 }
 
 //Aqui inserimos novos dados no "Livros.txt".
 public void insere(Livro livro)
 {
     //Adiciona o livro na array list.
     catalogo.add(livro);
     
     //Passa a string para o arquivo Livros.txt.
     try {
      File arquivo = new File("Livros.txt");
       
      
      PrintWriter f_writer = new PrintWriter(new FileWriter(arquivo, true));
         try (BufferedWriter escreve = new BufferedWriter(f_writer)) 
         {
             escreve.newLine();
             escreve.append(livro.toString());
         }  
       //Caso o arquivo esteja formatado do modo errado ele manda um aviso.
    } catch (IOException e) {
        System.out.println("Nao foi possivel escrever no arquivo, verifique se o arquivo está formatado do modo certo");
    }
 }
 
 //Aqui inserimos novos dados no "Estudantes.txt".
 public void insere(Estudante estudante)
 {
     //Adiciona o livro na array list.
     estudantes.add(estudante);
     
     //Passa a string para o arquivo Livros.txt.
     try {
      File arquivo = new File("Estudantes.txt");
       
      
      PrintWriter f_writer = new PrintWriter(new FileWriter(arquivo, true));
         try (BufferedWriter escreve = new BufferedWriter(f_writer)) 
         {
             escreve.newLine();
             escreve.append(estudante.toString());
         }  
      //Caso o arquivo esteja formatado do modo errado ele manda um aviso.
    } catch (IOException e) {
        System.out.println("Nao foi possivel escrever no arquivo, verifique se o arquivo está formatado do modo certo");
    }
 }
 
 //Busca livro a partir de um parametro e uma entrada especifica
 public void mostraBuscaLivro(String entrada, String parametro)
 {
     //Garante uma resposta caso a entrada não seja encontrada
     Boolean existe = false;
     
     //Percorre a array list catalogo.
     for(int i = 0;i < catalogo.size();i++)
     {
         //Lista os livros com o titulo igual a entrada.
         if(parametro.equals("Titulo"))
         {
             String titulo = (catalogo.get(i)).pegaTitulo();
             if(entrada.equals(titulo))
             {
                 System.out.println(catalogo.get(i));
                 existe = true;
             }
         }
         
         //Lista os livros com o ISBN igual a entrada.
         else if(parametro.equals("ISBN"))
         {
             String ISBN = (catalogo.get(i)).pegaISBN();
             if(entrada.equals(ISBN))
             {
                 System.out.println(catalogo.get(i));
                 existe = true;
             }
         }
         
         //Lista os livros com o autor igual a entrada.
         else if(parametro.equals("Autor"))
         {
             String autor = (catalogo.get(i)).pegaAutor();
             if(entrada.equals(autor))
             {
                 System.out.println(catalogo.get(i));
                 existe = true;
             }
         }
         
         //Lista os livros com o local igual a entrada.
         else if(parametro.equals("Local"))
         {
             String local = (catalogo.get(i)).pegaLocal();
             if(entrada.equals(local))
             {
                 System.out.println(catalogo.get(i));
                 existe = true;
             }
         }
 }
      //Resposta caso o livro não exista.
      if(existe == false)
             System.out.println("O livro que buscado não existe\n");
}
 
 //Busca estudante a partir de um parametro e uma entrada especifica.
 public void mostraBuscaEstudante(String entrada, String parametro)
 {
     //Garante uma resposta caso a entrada não seja encontrada
     Boolean existe = false;
     
     //Percorre a array list catalogo.
     for(int i = 0;i < estudantes.size();i++)
     {
         //Lista os estudantes com o RGA igual a entrada.
         if(parametro.equals("RGA"))
         {
             String RGA = (estudantes.get(i)).pegaRGA();
             if(entrada.equals(RGA))
             {
                 System.out.println(estudantes.get(i));
                 existe = true;
             }
         }
         
         //Lista os estudantes com o nome igual a entrada.
         else if(parametro.equals("Nome"))
         {
             String nome = (estudantes.get(i)).pegaNome();
             if(entrada.equals(nome))
             {
                 System.out.println(estudantes.get(i));
                 existe = true;
             }
         }
         
         //Lista os estudantes com o curso igual a entrada.
         else if(parametro.equals("Curso"))
         {
             String curso = (estudantes.get(i)).pegaCurso();
             if(entrada.equals(curso))
             {
                 System.out.println(estudantes.get(i));
                 existe = true;
             }
         }
         
         //Lista os estudantes com o campus igual a entrada.
         else if(parametro.equals("Campus"))
         {
             String campus = (estudantes.get(i)).pegaCampus();
             if(entrada.equals(campus))
             {
                 System.out.println(estudantes.get(i));
                 existe = true;   
             }
         }
     }
     //Resposta caso o livro não exista.
     if(existe == false)
             System.out.println("O estudante que buscado não existe\n");
 }
 
 //Devolve estudantes pelo RGA pois é o unico que é garantido de ser unico de cada aluno
 //este método é utilizado para achar a disponibilidade
 public Estudante achaEstudante(String entrada)
 {
     for(int i = 0;i < estudantes.size();i++){
         String RGA = (estudantes.get(i)).pegaRGA();
         if(entrada.equals(RGA))
             return estudantes.get(i);
     }
         return null;
 }
 
 //Devolve livros pelo ISBN pois é o unico que é garantido de ser unico de cada aluno
 //este método é utilizado para achar a disponibilidade
 public Livro achaLivro(String entrada)
 {
     for(int i = 0;i < catalogo.size();i++){
         String ISBN = (catalogo.get(i)).pegaISBN();
         if(entrada.equals(ISBN))
             return catalogo.get(i);
     }
         return null;
 }
 
 //Verifica se o estudante tem o livro disponivel na biblioteca do seu campus
 public void disponibilidade(String estudante, String livro)
 {
    String local_livro = achaLivro(livro).pegaLocal();
    String local_estudante = achaEstudante(estudante).pegaCampus();
    
    if(local_livro.equals(local_estudante))
        System.out.println("O estudante pode retirar o livro na biblioteca do campus");
    else
        System.out.println("Este livro nao esta disponivel neste local, procure na biblioteca de " + achaLivro(livro).pegaLocal());
 }
 
 //Lista todos os livros.
 public void printLivros()
 {
      for(int i = 0; i < catalogo.size(); i++)
       System.out.println(catalogo.get(i));
      System.out.print("\n");
 }
 
 //Lista todos os estudantes.
 public void printEstudantes()
 {
      for(int i = 0; i < estudantes.size(); i++)
       System.out.println(estudantes.get(i));
      System.out.print("\n");
 }
 
 //Garante que não existem estudantes repetidos.
 public Boolean repeticaoestudante (String RGA)
 {
     for(int i = 0;i < estudantes.size();i++)
     {
          if(estudantes.get(i).jaExiste(RGA) == true){
           return true;
         }
     } 
     return false;
 }
 
 //Garante que não existem livros repetidos.
 public Boolean repeticaolivro (String ISBN)
 {
     for(int i = 0;i < catalogo.size();i++)
     {
         if(catalogo.get(i).jaExiste(ISBN) == true){
           return true;
         }
     }
     return false;
 }
}
