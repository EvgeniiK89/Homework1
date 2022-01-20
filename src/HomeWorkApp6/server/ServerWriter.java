package HomeWorkApp6.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerWriter extends Thread {
    private Scanner consoleReader;
    private PrintWriter write;

    public ServerWriter (ServerSocket serverSocket) throws IOException {
        this.consoleReader = new Scanner(System.in);
        this.write = new PrintWriter(serverSocket.accept().getOutputStream());
    }

    @Override
    public void run() {
        while (true) {
            String outputLine = consoleReader.nextLine();
            write.println(outputLine);
            write.flush();
        }
    }
}
