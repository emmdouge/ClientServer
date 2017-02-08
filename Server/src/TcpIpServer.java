import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
	public static void main(String[] args) throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(7777);
		System.out.println(getTime() + " Server is ready.");

		System.out.println(getTime() + " Waiting for connection request.");

		//Setting request wait time
		serverSocket.setSoTimeout(5*1000);

		//Server Socket stops execution and waits for connection request from client
		//When client connection request arrives, server creates new socket for communication
		Socket socket = serverSocket.accept();
		System.out.println(getTime() + " " + " From " + socket.getInetAddress() + ", connection request is coming.");

		//From socket, corresponding port and local (server) port are obtained
		System.out.println("getPort(): " + socket.getPort());
		System.out.println("getLocalPort(): " + socket.getLocalPort());

		//Outstream of socket
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);

		//Send data to remote socket.
		dos.writeUTF("[NOTICE] Test Message1 from Server.");
		System.out.println(getTime() + " Data has been sent");

		dos.close();
		socket.close();

	}

	public static String getTime()
	{
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss");
		return f.format(new Date());
	}
}
