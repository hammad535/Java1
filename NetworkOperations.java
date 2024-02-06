// NetworkOperations.java
import java.io.IOException;
import java.net.InetAddress;

public class NetworkOperations {
    public void performAction() {
        System.out.println("Performing network ping...");

        // Example: Pinging Google's public DNS server (8.8.8.8)
        String ipAddressToPing = "8.8.8.8";

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddressToPing);

            // Timeout is set to 5000 milliseconds (5 seconds)
            if (inetAddress.isReachable(5000)) {
                System.out.println(ipAddressToPing + " is reachable.");
            } else {
                System.out.println(ipAddressToPing + " is not reachable.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
