import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.InputStream;

public class TcpIpClient {
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		String serverIp = "127.0.0.1";

		//Create socket and request connection
		System.out.println("Connecting server. Server IP: " + serverIp);
		Socket socket = new Socket(serverIp, 7777);

		//Obtained inputstream of socket
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);

		//Print out data from socket
		System.out.println("Message from server: " + dis.readUTF());
		System.out.println("Close connection");

		dis.close();
		socket.close();
		System.out.println("Connection has been closed.");
	}
}
