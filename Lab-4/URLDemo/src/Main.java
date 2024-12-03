import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

class URLDemo {
    public static void main(String[] args) {
        try {
            // a) Different ways of creating URL objects and URL parsing
            System.out.println("\n--- Different Ways of Creating URL Objects and URL Parsing ---");
            URL url1 = new URL("https://www.example.com");
            URL url2 = new URL("https", "www.example.com", 80, "/index.html");
            URL url3 = new URL(new URL("https://www.example.com"), "/path/resource");

            System.out.println("URL 1: " + url1);
            System.out.println("URL 2: " + url2);
            System.out.println("URL 3: " + url3);

            System.out.println("\nParsing URL 1:");
            System.out.println("Protocol: " + url1.getProtocol());
            System.out.println("Host: " + url1.getHost());
            System.out.println("Port: " + url1.getPort());
            System.out.println("Path: " + url1.getPath());

            // b) Reading Directly from URL
            System.out.println("\n--- Reading Directly from URL ---");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url1.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            // c) Reading from a URLConnection
            System.out.println("\n--- Reading from a URLConnection ---");
            URLConnection connection = url1.openConnection();
            BufferedReader connectionReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = connectionReader.readLine()) != null) {
                System.out.println(line);
            }
            connectionReader.close();

            // d) InetAddress Class
            System.out.println("\n--- InetAddress Class ---");
            InetAddress inetAddress = InetAddress.getByName("www.example.com");
            System.out.println("Host Name: " + inetAddress.getHostName());
            System.out.println("Host Address: " + inetAddress.getHostAddress());

            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local Host Name: " + localAddress.getHostName());
            System.out.println("Local Host Address: " + localAddress.getHostAddress());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
