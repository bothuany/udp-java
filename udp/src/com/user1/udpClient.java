package com.user1;

// Java program to illustrate Client side
// Implementation using DatagramSocket
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class udpClient extends Thread
{
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);

		// Step 1:Create the UDP socket object for carrying the message
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		byte buf[] = null;

		// loop while user not enters "exit"
		while (true)
		{
			String inp = sc.nextLine();

			// convert the String input into the byte array.
			buf = inp.getBytes();

			// Step 2 : Create the datagramPacket for sending
			// the message.
			DatagramPacket DpSend =
				new DatagramPacket(buf, buf.length, ip, 1234);

			// Step 3 : invoke the send call to actually send
			// the data.
			try {
				ds.send(DpSend);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// break the loop if user enters "exit"
			if (inp.equals("exit"))
				break;
		}
	}
}
