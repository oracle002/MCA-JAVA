import java.io.*;
import java.net.URL;

public class FileDownloader {
    public static void main(String[] args) {
        String fileUrl = args[0]; // URL of the file to download
        String savePath = "downloadedFile.pdf"; // Path to save the downloaded file

        try {
            URL url = new URL(fileUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(savePath));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
            System.out.println("File downloaded successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while downloading the file: " + e.getMessage());
        }
    }
}
