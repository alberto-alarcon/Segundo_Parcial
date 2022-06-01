/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador2;

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
public class MainController2 extends HttpServlet {

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
            ArrayList<seminarios> lista = new ArrayList<seminarios>();
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;

            if (op.equals("list")) {

                String sql = "select * from seminarios";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    seminarios c = new seminarios();
                    c.setId(rs.getInt("id"));
                    c.setTitulo(rs.getString("Titulo"));
                    c.setFecha(rs.getString("fecha"));
                    c.setCupo(rs.getInt("cupo"));
                    lista.add(c);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index_1.jsp").forward(request, response);
            }

            if (op.equals("nuevo")) {

                seminarios li = new seminarios();
                System.out.println(li.toString());

                request.setAttribute("lib", li);

                request.getRequestDispatcher("editar_1.jsp").forward(request, response);
            }

            if (op.equals("eliminar")) {
                int id = Integer.parseInt(request.getParameter("id"));

                HttpSession ses = request.getSession();

                String sql = "delete from seminarios where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("MainController2");
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
            String titulo = request.getParameter("titulo");
            String fecha = request.getParameter("fecha");
            int cupo = Integer.parseInt(request.getParameter("cupo"));
            // ACA APARECE MI ERROR POR PARTE DE SUPERTIPOS 

            seminarios lib = new seminarios();
            lib.setId(id);
            lib.setTitulo(titulo);
            lib.setFecha(fecha);
            lib.setCupo(cupo);

            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;

            if (id == 0) {

                String sql = "insert into seminarios (titulo,fecha,cupo) values (?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, titulo);
                ps.setString(2, fecha);
                ps.setInt(3, cupo);
                ps.executeQuery();
            } else {
                // edicion de registro
            }
            response.sendRedirect("MainController2");
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





