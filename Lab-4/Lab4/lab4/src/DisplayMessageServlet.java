import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisplayMessageServlet")
public class DisplayMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {
            // Display "Java is one of the powerful programming languages!" 10 times
            out.println("<h3>Repeated Message:</h3>");
            for (int i = 1; i <= 10; i++) {
                out.println("<p>" + i + ". Java is one of the powerful programming languages!</p>");
            }

            // Display current date and time
            Date currentDate = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
            String formattedDate = formatter.format(currentDate);

            out.println("<h3>Current Date and Time:</h3>");
            out.println("<p>" + formattedDate + "</p>");

            // Display Name, Roll No., and Section
            out.println("<h3>Your Details:</h3>");
            out.println("<p>Name: Your Name</p>");
            out.println("<p>Roll No.: Your Roll No</p>");
            out.println("<p>Section: Your Section</p>");
        } finally {
            out.close();
        }
    }
}
