package org.example.command.find;

import org.example.DAO.BookDAO;
import org.example.command.Command;
import org.example.models.Book;
import org.example.view.Printer;
import org.example.view.Reader;

import java.util.List;

public class FindBookByTitleCommand implements Command {
    @Override
    public void execute() {
        String findTitle = Reader.lerString("Voce escolheu buscar um livro pelo seu titulo, digite o titulo que deseja: ");
        BookDAO DAO = new BookDAO();
        List<Book> booksByName = DAO.findBy(findTitle);
        Printer.printList(booksByName);
    }
}
