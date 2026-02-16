package com.bank;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DepositServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int amount = Integer.parseInt(request.getParameter("amount"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET balance = balance + ? WHERE id=1"
            );
            ps.setInt(1, amount);
            ps.executeUpdate();

            response.getWriter().println("Amount Deposited Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
