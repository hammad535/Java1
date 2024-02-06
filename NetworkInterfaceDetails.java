// NetworkInterfaceDetails.java
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkInterfaceDetails {
    public void displayDetails() {
        System.out.println("Showing NIC (Network Interface Card) details...");

        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nic = networkInterfaces.nextElement();

                System.out.println("Name: " + nic.getName());
                System.out.println("Display Name: " + nic.getDisplayName());
                System.out.println("MTU (Maximum Transmission Unit): " + nic.getMTU());
                System.out.println("Hardware Address (MAC): " + formatMACAddress(nic.getHardwareAddress()));

                System.out.println("----------------------");
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private String formatMACAddress(byte[] mac) {
        if (mac == null) {
            return "N/A";
        }

        StringBuilder macAddress = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));
        }

        return macAddress.toString();
    }
}
