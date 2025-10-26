import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class App {
    public static void createFileInSrc() {
        String name = "XxX"; 
        String filename = name + "_first_file.txt"; 
        Path file = Paths.get("src", filename);
        try {
            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }
            String line = name + " added his first file";
            Files.write(file, line.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Created file: " + file.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to create file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
