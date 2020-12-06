import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="product", urlPatterns = "/product")
public class Product extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    // http://localhost:8080/firstapp/product?num=10
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        int num = Integer.parseInt(req.getParameter("num"));


        for (int i = 0; i < num; i++) {
            out.println("<html><body><h1>" + String.format("id: %s - title: cucumber %s - price: %s USD", i, i, (i + 100)) + "</h1></body></html>");
        }
    }
}
