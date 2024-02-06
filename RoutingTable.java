// RoutingTable.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RoutingTable {
    public void displayRoutingTable() {
        System.out.println("Showing routing table...");

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("netstat", "-r");
            Process process = processBuilder.start();

            // Read the output of the command
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Routing table displayed successfully.");
            } else {
                System.out.println("Failed to display routing table. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
