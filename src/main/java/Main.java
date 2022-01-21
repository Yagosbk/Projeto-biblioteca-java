import com.mycompany.biblioteca.Biblioteca;
import com.mycompany.biblioteca.Estudante;
import com.mycompany.biblioteca.Livro;
import java.util.Scanner;


public class Main {

   
 public static void main(String[] args){
        //Cria uma nova biblioteca.
        Biblioteca biblioteca = new Biblioteca();
        
        //Recebe os livros e os estudantes dos seus respectivos arquivos
        biblioteca.recebeLivros();
        biblioteca.recebeEstudantes();
        
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("----Bem vindo ao sistema da biblioteca de faculdade UFMS, escolha uma das opções----");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("A: Adicionar um novo livro");
        System.out.println("B: Adicionar um novo estudante");
        System.out.println("C: Buscar um livro");
        System.out.println("D: Buscar um estudante");
        System.out.println("E: Lista os livros");
        System.out.println("F: Lista os estudante");
        System.out.println("G: Checa se o livro esta disponivel no campus do aluno");
        System.out.println("H: Sai do sistema");
        
        
        Scanner scan = new Scanner(System.in);
        String entrada;
        //Aqui começa o funcionametno do menu a partir da letra escolhida pelo usuario.
        do{
            //Recebe a letra escolhida.
            System.out.println("Entrada: ");
            entrada = scan.nextLine();
            
            //Caso a entrada seja "A" ele pede ISBN, Autor, Titulo e Local e põe eles dentro do arquivo livro
            //já formatados do modo correto.
            switch(entrada){
                case "A":
             System.out.println("ISBN:");
             String ISBN = scan.nextLine();
              if(biblioteca.repeticaolivro(ISBN) == true)
              {
                  System.out.println("Repetiu o ISBN por favor selecione novamente uma das opções\n");
                  System.out.println("A: Adicionar um novo livro");
                  System.out.println("B: Adicionar um novo estudante");
                  System.out.println("C: Buscar um livro");
                  System.out.println("D: Buscar um estudante");
                  System.out.println("E: Lista os livros");
                  System.out.println("F: Lista os estudante");
                  System.out.println("G: Checa se o livro esta disponivel no campus do aluno");
                  System.out.println("H: Sai do sistema");
                  break;
              }
             System.out.println("Autor:");
             String autor = scan.nextLine();
             System.out.println("Titulo:");
             String titulo = scan.nextLine();
             System.out.println("Local:");
             String local = scan.nextLine();
             Livro novolivro = new Livro(ISBN, autor, titulo, local);
             biblioteca.insere(novolivro);
                  System.out.println("O livro foi inserido no arquivo\n");
                  System.out.println("A: Adicionar um novo livro");
                  System.out.println("B: Adicionar um novo estudante");
                  System.out.println("C: Buscar um livro");
                  System.out.println("D: Buscar um estudante");
                  System.out.println("E: Lista os livros");
                  System.out.println("F: Lista os estudante");
                  System.out.println("G: Checa se o livro esta disponivel no campus do aluno");
                  System.out.println("H: Sai do sistema");
             break;


             
             //Caso a entrada seja "B" ele pede RGA, Nome, Curso e Campus e põe eles dentro do arquivo estudantes
            //já formatados do modo correto.
             case "B":
             System.out.println("RGA:");
             String RGA = scan.nextLine();
             if(biblioteca.repeticaoestudante(RGA) == true)
             {
                  System.out.println("Repetiu o RGA por favor selecione novamente uma das opções\n");
                  System.out.println("A: Adicionar um novo livro");
                  System.out.println("B: Adicionar um novo estudante");
                  System.out.println("C: Buscar um livro");
                  System.out.println("D: Buscar um estudante");
                  System.out.println("E: Lista os livros");
                  System.out.println("F: Lista os estudante");
                  System.out.println("G: Checa se o livro esta disponivel no campus do aluno");
                  System.out.println("H: Sai do sistema");
                 break;
             }
             System.out.println("Nome:");
             String nome = scan.nextLine();
             System.out.println("Curso:");
             String curso = scan.nextLine();
             System.out.println("Campus:");
             String campus = scan.nextLine();
             Estudante novoestudante = new Estudante(RGA, nome, curso, campus);
             biblioteca.insere(novoestudante);
             System.out.println("O estudante foi inserido no arquivo\n");
                  System.out.println("A: Adicionar um novo livro");
                  System.out.println("B: Adicionar um novo estudante");
                  System.out.println("C: Buscar um livro");
                  System.out.println("D: Buscar um estudante");
                  System.out.println("E: Lista os livros");
                  System.out.println("F: Lista os estudante");
                  System.out.println("G: Checa se o livro esta disponivel no campus do aluno");
                  System.out.println("H: Sai do sistema");
             break;
             
             
             //Para a busca é necessario que o usuario digite "ISBN", "Autor", "Titulo" ou "Local"
             //Depois precisamos que ele digite especificamente o ISBN, autor, titulo, ou local que ele quer buscar
             case "C":
             System.out.println("Digite o seu parametro: ");
             System.out.println("ISBN");
             System.out.println("Autor");
             System.out.println("Titulo");
             System.out.println("Local");
             System.out.println("Parametro: ");
             String parametrolivro = scan.nextLine();
             
             System.out.println("Digite a sua entrada: ");
             String entradalivro = scan.nextLine();
             biblioteca.mostraBuscaLivro(entradalivro, parametrolivro);
                  System.out.println("A: Adicionar um novo livro");
                  System.out.println("B: Adicionar um novo estudante");
                  System.out.println("C: Buscar um livro");
                  System.out.println("D: Buscar um estudante");
                  System.out.println("E: Lista os livros");
                  System.out.println("F: Lista os estudante");
                  System.out.println("G: Checa se o livro esta disponivel no campus do aluno");
                  System.out.println("H: Sai do sistema");
             break;
             
             
             //Para a busca é necessario que o usuario digite "RGA", "Nome", "Curso" ou "Campus"
             //Depois precisamos que ele digite especificamente o RGA, Nome, Curso, ou Campus que ele quer buscar
             case "D":
             System.out.println("Digite o seu parametro: ");
             System.out.println("RGA");
             System.out.println("Nome");
             System.out.println("Curso");
             System.out.println("Campus");
             System.out.println("Parametro: ");
             String parametroestudante = scan.nextLine();
             
             System.out.println("Digite a sua entrada: ");
             String entradaestudante = scan.nextLine();
             biblioteca.mostraBuscaEstudante(entradaestudante, parametroestudante);
                  System.out.println("A: Adicionar um novo livro");
                  System.out.println("B: Adicionar um novo estudante");
                  System.out.println("C: Buscar um livro");
                  System.out.println("D: Buscar um estudante");
                  System.out.println("E: Lista os livros");
                  System.out.println("F: Lista os estudante");
                  System.out.println("G: Checa se o livro esta disponivel no campus do aluno");
                  System.out.println("H: Sai do sistema");
             break;
             
             //Lista todos os livros da biblioteca.
             case "E":
             System.out.println("Estes sao os livros da biblioteca: ");
             biblioteca.printLivros();
                  System.out.println("A: Adicionar um novo livro");
                  System.out.println("B: Adicionar um novo estudante");
                  System.out.println("C: Buscar um livro");
                  System.out.println("D: Buscar um estudante");
                  System.out.println("E: Lista os livros");
                  System.out.println("F: Lista os estudante");
                  System.out.println("G: Checa se o livro esta disponivel no campus do aluno");
                  System.out.println("H: Sai do sistema");
             break;
             
             //Lista todos os alunos.
             case "F":
             System.out.println("Estes sao os alunos: ");
             biblioteca.printEstudantes();
                  System.out.println("A: Adicionar um novo livro");
                  System.out.println("B: Adicionar um novo estudante");
                  System.out.println("C: Buscar um livro");
                  System.out.println("D: Buscar um estudante");
                  System.out.println("E: Lista os livros");
                  System.out.println("F: Lista os estudante");
                  System.out.println("G: Checa se o livro esta disponivel no campus do aluno");
                  System.out.println("H: Sai do sistema");
             break;
             
             //Passando o RGA do aluno e o ISBN do livro ele verifica se os dois estão
             //no mesmo local.
             case "G":
             System.out.println("Digite o RGA do aluno: ");
             String RGA_busca = scan.nextLine();
             System.out.println("Digite o ISBN do livro: ");
             String ISBN_busca = scan.nextLine();
             biblioteca.disponibilidade(RGA_busca, ISBN_busca);
                  System.out.println("A: Adicionar um novo livro");
                  System.out.println("B: Adicionar um novo estudante");
                  System.out.println("C: Buscar um livro");
                  System.out.println("D: Buscar um estudante");
                  System.out.println("E: Lista os livros");
                  System.out.println("F: Lista os estudante");
                  System.out.println("G: Checa se o livro esta disponivel no campus do aluno");
                  System.out.println("H: Sai do sistema");
             break;
             
             //Fecha o menu.
             case "H":
             System.out.println("Obrigado por utilizar o sistema !");
             break;
                   
             //Caso a entrada seja invalida o usuário é avisado.
             default:
                 System.out.println("Opcao Invalida, escolha novamente");
                 System.out.println("A: Adicionar um novo livro");
                 System.out.println("B: Adicionar um novo estudante");
                 System.out.println("C: Buscar um livro");
                 System.out.println("D: Buscar um estudante");
                 System.out.println("E: Lista os livros");
                 System.out.println("F: Lista os estudante");
                 System.out.println("G: Checa se o livro esta disponivel no campus do aluno");
                 System.out.println("H: Sai do sistema");
            }        }while(!"H".equals(entrada)); //Termina quando a entrada é "H"
        
    }
    
}
