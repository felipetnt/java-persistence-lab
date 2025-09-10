package org.example.view;

import org.example.models.Author;
import org.example.models.Book;
import org.example.models.Publisher;
import org.example.models.Review;
import org.example.validation.Validator;

import java.util.HashSet;
import java.util.Set;

public class EntityViewer {
    public static Book inputBook(){
        String title = Reader.lerString("Insira o nome do livro: ");

        Publisher publisher = inputPublisher();
        Set<Author> authors = getAuthors();
        Review review = inputReview();

        Book book = new Book(title);
        book.setAuthors(authors);
        book.setReview(review);
        book.setPublisher(publisher);

        Validator.validateEntity(book);

        return book;
    }

    public static Author inputAuthor(){
        String name = Reader.lerString("Insira o nome do autor: ");
        Set<Book> books = getBooks();

        Author author = new Author(name);
        author.setBooks(books);

        Validator.validateEntity(author);

        return author;
    }

    public static Review inputReview(){
        String coment = Reader.lerString("Insira a resenha do livro: ");
        Book book = EntityViewer.inputBook();

        Review review = new Review();
        review.setComment(coment);
        review.setBook(book);

        Validator.validateEntity(review);

        return review;
    }

    public static Publisher inputPublisher(){
        String name = Reader.lerString("Insira o nome da Editora: ");
        Set<Book> books = getBooks();

        Publisher pub = new Publisher(name);
        pub.setBooks(books);

        Validator.validateEntity(pub);
        
        return pub;
    }

    protected static Set<Author> getAuthors(){
        Set<Author> authors = new HashSet<>();
        while(true){
            System.out.println("Insira o(s) autores que estao no seu livro: ");
            Author author = inputAuthor();
            authors.add(author);
            boolean b = Reader.lerContinue("Deseja inserir mais um autor? (Sim/Nao) ");
            if(!b) {
                break;
            }
        }
        return authors;
    }

    protected static Set<Book> getBooks(){
        Set<Book> books = new HashSet<>();
        while(true){
            System.out.println("Insira o(s) livros que-os escreveram ou publicaram: ");
            Book book = inputBook();
            books.add(book);
            boolean b = Reader.lerContinue("Deseja inserir mais um livro? (Sim/Nao) ");
            if(!b) {
                break;
            }
        }
        return books;
    }
}
