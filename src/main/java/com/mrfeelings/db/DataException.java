package com.mrfeelings.db;

public class DataException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DataException(Exception cause) {
    super(cause);
  }
  
}
