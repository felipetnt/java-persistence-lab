package org.example.command.list;

import org.example.DAO.BookDAO;
import org.example.command.Command;
import org.example.models.Book;

import java.util.List;

public class ListAllOfBookCommand implements Command {
    @Override
    public void execute() {
        BookDAO dao = new BookDAO();
        List<Book> books = dao.listAll();

        if (books.isEmpty()) {
            System.out.println("Nenhum livro cadastrado ainda.");
        } else {
            System.out.println("=== LISTA DE LIVROS ===");
            for (Book b : books) {
                System.out.println("Título: " + b.getTitle());
                if (b.getPublisher() != null)
                    System.out.println("Editora: " + b.getPublisher().getName());
                System.out.println("------------------------");
            }
        }
    }
}
