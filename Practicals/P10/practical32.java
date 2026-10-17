import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class practical32 {
  public static void main(String[] args) {
    int port = 8080;

    try (ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("Main server Thread started on port " + port);
      System.out.println("Waiting for client connections...");

      while (true) {
        Socket clientSocket = serverSocket.accept();
        System.out.println("\n[Main Thread] Accepted new connection from: " + clientSocket.getRemoteSocketAddress());


        ClientHandler handler = new ClientHandler(clientSocket);
        Thread workerThread = new Thread(handler);
        workerThread.start();
      }
    }
    catch (IOException e) {
      System.out.println("Server exception encountered: " + e.getMessage());
    }
  }
}

class ClientHandler implements Runnable {
  private Socket socket;

  public ClientHandler(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    String threadName = Thread.currentThread().getName();
    System.out.println("[" + threadName + "] Processing request for client...");

    try (
      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)
      ) {
      String clientMessage = reader.readLine();
      System.out.println("[" + threadName + "] Recived text: " + clientMessage);

      Thread.sleep(2000);

      String response = "Server Echo: " + clientMessage;
      writer.println(response);

      System.out.println("[" + threadName + "] Request successfully processed.");
    }
    catch (IOException | InterruptedException e) {
      System.out.println("[" + threadName + "] Error handling client: " + e.getMessage());
    }
    finally {
      try {
        socket.close();
        System.out.println("[" + threadName + "] Socket connection closed safely.");
      }
      catch (IOException e) {
        System.out.println("[" + threadName + "] Failed to cloase socket: " + e.getMessage());
      }
    }
  }
}
