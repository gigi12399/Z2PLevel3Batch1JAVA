package Day16.fileio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Reading_small_file_with_filechannel {

	public static void main(String[] args) {
		try(RandomAccessFile inputFile = new RandomAccessFile("src/Day16/fileio/Employee.txt", "r")) {
			
			// create file channel
			FileChannel channel = inputFile.getChannel();
			long fileSize = channel.size();
			
			// create buffer
			ByteBuffer buffer = ByteBuffer.allocate((int)fileSize);
			
			// read from channel to buffer
			channel.read(buffer);
			
			// flip to read buffer
			buffer.flip();
			
			String data = new String(buffer.array(),0,buffer.limit());
			
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
