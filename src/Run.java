import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {
		File dir = new File("C:/Users/Angelo/Desktop/negatives/neg");

		if (dir.isDirectory()) {
			int i = 1;
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:/Users/Angelo/Desktop/negatives/neg.txt")));
			for (File f : dir.listFiles()) {
				try {
					File newfile = new File("C:/Users/Angelo/Desktop/negatives/neg/neg" + i++ + ".jpg");
				
					if (f.renameTo(newfile)) {
						bw.append("/home/angelo/Scrivania/negatives/neg/" + newfile.getName());
						bw.newLine();
						System.out.println("Rename succesful");
					} else {
						bw.append("/home/angelo/Scrivania/negatives/neg/" + f.getName());
						bw.newLine();
						System.out.println("Rename failed");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			bw.close();
		}
	}

}
