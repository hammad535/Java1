import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanner {
    public void performPortScan(String ipAddress, int startPort, int endPort) {
        System.out.println("Performing port scan on " + ipAddress + " from port " + startPort + " to port " + endPort + "...");

        for (int port = startPort; port <= endPort; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ipAddress, port), 1000);
                socket.close();
                System.out.println("Port " + port + " is open");
            } catch (IOException e) {
                // Port is closed or filtered
            }
        }
    }
}
