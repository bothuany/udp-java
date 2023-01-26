package com.user2;

// Java program to illustrate Server side
// Implementation using DatagramSocket
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class udpServer extends Thread
{
	@Override
	public void run() {
		// Step 1 : Create a socket to listen at port 1234
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(1234);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		byte[] receive = new byte[65535];

		while (true)
		{
			// Step 2 : create a DatagramPacket to receive the data.
			DatagramPacket DpReceive = new DatagramPacket(receive, receive.length);

			// Step 3 : receive the data in byte buffer.
			try {
				ds.receive(DpReceive);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("User 1:-" + data(receive));

			// Exit the server if the client sends "bye"
			if (data(receive).toString().equals("exit"))
			{
				System.out.println("User 1 sent exit.....EXITING");
				break;
			}

			// Clear the buffer after every message.
			receive = new byte[65535];
		}
	}

	// A utility method to convert the byte array
	// data into a string representation.
	public static StringBuilder data(byte[] a)
	{
		if (a == null)
			return null;
		StringBuilder ret = new StringBuilder();
		int i = 0;
		while (a[i] != 0)
		{
			ret.append((char) a[i]);
			i++;
		}
		return ret;
	}
}
