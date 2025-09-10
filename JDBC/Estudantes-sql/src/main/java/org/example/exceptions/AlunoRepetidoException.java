package org.example.exceptions;

public class AlunoRepetidoException extends RuntimeException {

  @Override
  public String getMessage() {
    return super.getMessage() + "-- Aluno ja cadastrado no sistema... ";
  }
}
