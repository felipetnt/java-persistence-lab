package org.example.command.update;

import org.example.command.Command;
import org.example.view.EntityViewer;

public class updateAuthorCommand implements Command {
    public void execute(){
        EntityViewer.inputAuthor();
    }
}
