/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.modelo.participantes;
import com.emergentes.modelo.seminarios;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ALBERTO
 */
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op;

            op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
            ArrayList<participantes> lista = new ArrayList<participantes>();
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;

            if (op.equals("list")) {

                String sql = "select * from participantes";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    participantes c = new participantes();
                    c.setId(rs.getInt("id"));
                    c.setApellidos(rs.getString("apellidos"));
                    c.setNombres(rs.getString("nombres"));
                    c.setId_seminario(rs.getInt("id_seminario"));
                    c.setConfirmado(rs.getInt("confirmado"));
                    lista.add(c);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            if (op.equals("nuevo")) {

                participantes li = new participantes();
                System.out.println(li.toString());

                request.setAttribute("lib", li);

                request.getRequestDispatcher("editar.jsp").forward(request, response);
            }

            if (op.equals("eliminar")) {
                int id = Integer.parseInt(request.getParameter("id"));

                HttpSession ses = request.getSession();

                String sql = "delete from participantes where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("MainController");
            }
        } catch (SQLException ex) {
            System.out.print("Error al conectar" + ex.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("calor de id" + id);
            String apellidos = request.getParameter("apellidos");
            String nombres = request.getParameter("nombres");
            int id_seminario = Integer.parseInt(request.getParameter("id_seminario"));
            int confirmado = Integer.parseInt(request.getParameter("confirmado"));
            // ACA APARECE MI ERROR POR PARTE DE SUPERTIPOS 

            participantes lib = new participantes();
            lib.setId(id);
            lib.setApellidos(apellidos);
            lib.setNombres(nombres);
            lib.setId_seminario(id_seminario);
            lib.setConfirmado(confirmado);

            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;

            if (id == 0) {

                String sql = "insert into participantes (apellidos,nombres,id_seminario,confirmado) values (?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, apellidos);
                ps.setString(2, nombres);
                ps.setInt(3, id_seminario);
                ps.setInt(4, confirmado);
                ps.executeQuery();
            } else {
                // edicion de registro
            }
            response.sendRedirect("MainController");
        } catch (SQLException ex) {
            System.out.print("Error en sql" + ex.getMessage());
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
