import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Run2 {

	public static void main(String[] args) throws IOException {
		File dir = new File("C:/Users/Angelo/Desktop/positives/pos");

		if (dir.isDirectory()) {
			int i = 1;
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(new File("C:/Users/Angelo/Desktop/positives/pos.txt")));
			Vector<Integer> widthVec = new Vector<Integer>();
			Vector<Integer> heightVec = new Vector<Integer>();
			for (File f : dir.listFiles()) {
				try {
					File newfile = new File("C:/Users/Angelo/Desktop/positives/pos/pos" + i++ + ".jpg");
					BufferedImage img = null;
					if (f.renameTo(newfile)) {
						img = ImageIO.read(newfile);
						bw.append("pos/" + newfile.getName() + " 1 0 0 " + img.getWidth() + " " + img.getHeight());
						bw.newLine();
						System.out.println("Rename succesful");
					} else {
						img = ImageIO.read(f);
						bw.append("pos/" + f.getName() + " 1 0 0 " + img.getWidth() + " " + img.getHeight());
						bw.newLine();
						System.out.println("Rename failed");
					}
					widthVec.add(img.getWidth());
					heightVec.add(img.getHeight());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			int sumWidth = 0, sumHeight = 0;
			for (int j = 0; j < widthVec.size(); j++) {
				sumWidth += widthVec.elementAt(j);
				sumHeight += heightVec.elementAt(j);
			}
			System.out.println("Le width e height medie sono: " + sumWidth / (i - 1) + " " + sumHeight / (i - 1));
			System.out.println("La ratio width/height è: " + (double) sumWidth / sumHeight);
			bw.close();
		}
	}

}
