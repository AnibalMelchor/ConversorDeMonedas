import java.io.Console;
import java.io.IOException;
import java.lang.classfile.constantpool.DoubleEntry;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConversorApp conversor = new ConversorApp();
        conversor.mostrarMenu();
    }
}
