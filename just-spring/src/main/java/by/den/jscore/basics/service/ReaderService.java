package by.den.jscore.basics.service;

import by.den.jscore.basics.readers.IReader;

public class ReaderService {
  private IReader reader = null;

  public ReaderService(IReader reader) {
    this.reader = reader;
  }

  public String fetchData() {
    return reader.read();
  }
}
