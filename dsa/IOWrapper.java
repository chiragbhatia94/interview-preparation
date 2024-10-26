package dsa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import dsa.iowrapper_test.Test;

public class IOWrapper {

    static final File ip = new File("input.txt");
    static final File op = new File("output.txt");

    static {
        try {
            boolean autoFlush = true;
            OutputStream fout = new FileOutputStream(op);
            TeeOutputStream myOut=new TeeOutputStream(System.out, fout);
            PrintStream ps = new PrintStream(myOut, autoFlush);
            System.setOut(ps);
            System.setIn(new FileInputStream(ip));
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Test.main(args);
    }

    final static class TeeOutputStream extends OutputStream {

        private final OutputStream out;
        private final OutputStream tee;
      
        public TeeOutputStream(OutputStream out, OutputStream tee) {
          if (out == null)
            throw new NullPointerException();
          else if (tee == null)
            throw new NullPointerException();
      
          this.out = out;
          this.tee = tee;
        }
      
        @Override
        public void write(int b) throws IOException {
          out.write(b);
          tee.write(b);
        }
      
        @Override
        public void write(byte[] b) throws IOException {
          out.write(b);
          tee.write(b);
        }
      
        @Override
        public void write(byte[] b, int off, int len) throws IOException {
          out.write(b, off, len);
          tee.write(b, off, len);
        }
      
        @Override
        public void flush() throws IOException {
          out.flush();
          tee.flush();
        }
      
        @Override
        public void close() throws IOException {
          try {
            out.close();
          } finally {
            tee.close();
          }
        }
      }
}