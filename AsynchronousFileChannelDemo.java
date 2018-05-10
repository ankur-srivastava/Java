/**
 * 
 */
package com.ankur;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author ankursrivastava
 * Program to demonstrate AsynchronousFileChannel for I/O using Future
 *
 */
public class AsynchronousFileChannelDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Path file = Paths.get("/Users/ankursrivastava/Desktop/Tools/test.txt");
			AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);
			ByteBuffer buffer = ByteBuffer.allocate(100_000);
			Future<Integer> result = channel.read(buffer, 0);

			//Perform another task
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 1000; i++) {
				sb.append(i + " ");
			}
			System.out.println("Parallel task completed and sb is " + sb.toString());

			//Wait for File Read to complete
			int wait = 0;
			System.out.println("Wait for File Read to complete");
			while (!result.isDone()) {
				wait++;
			}
			System.out.println("Wait lasted "+wait+" counts");	

			Integer bytesRead = result.get();
			System.out.println("Bytes read [" + bytesRead + "]");

		} catch (IOException | ExecutionException | InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}