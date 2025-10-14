package org.example.view;

import org.example.DAO.AuthorDAO;
import org.example.DAO.PublisherDAO;
import org.example.models.Author;
import org.example.models.Book;
import org.example.models.Publisher;
import org.example.models.Review;
import org.example.validation.Validator;

import java.util.HashSet;
import java.util.Set;

public class EntityViewer {
    public static Book inputBook() {
        String title = Reader.lerString("Insira o nome do livro: ");
        PublisherDAO DAO = new PublisherDAO();
        Publisher publisher = PublisherDAO.ensurePublisherExists(Reader.lerString("Insira o nome da editora: "));
        Set<Author> authors = getAuthors();

        Review review = inputReview();

        Book book = new Book(title);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setReview(review);

        Validator.validateEntity(book);
        return book;
    }

    public static Author inputAuthor() {
        String name = Reader.lerString("Insira o nome do autor: ");
        Author author = new Author(name);
        Validator.validateEntity(author);
        return author;
    }

    public static Publisher inputPublisher() {
        String name = Reader.lerString("Insira o nome da editora: ");
        Publisher pub = new Publisher(name);
        Validator.validateEntity(pub);
        return pub;
    }

    public static Review inputReview() {
        String comment = Reader.lerString("Insira a resenha do livro: ");
        Review review = new Review();
        review.setComment(comment);
        Validator.validateEntity(review);
        return review;
    }

    protected static Set<Author> getAuthors(){
        Set<Author> authors = new HashSet<>();
        while(true){
            System.out.println("Insira o(s) autores que estao no seu livro: ");
            Author author = inputAuthor();
            author = AuthorDAO.ensureAuthorExists(author.getName());
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
