package Day16.fileio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class Writing_large_file_with_filechannel {

	public static void main(String[] args) {
		try(RandomAccessFile inputFile = new RandomAccessFile("data.txt","rw")) {
			FileChannel channel = inputFile.getChannel();
			
			String largeData = "Many data....";
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 4096 * 8);
			
			buffer.put(largeData.getBytes());
			System.out.println("Success with channel");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
