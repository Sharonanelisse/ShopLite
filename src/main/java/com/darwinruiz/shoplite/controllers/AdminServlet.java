package com.darwinruiz.shoplite.controllers;

import com.darwinruiz.shoplite.repositories.ProductRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Requisito (POST): validar y crear un nuevo producto en memoria y redirigir a /home.
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private final ProductRepository repo = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Requisito:
        //  - Leer name y price del formulario.
        //  - Validar: nombre no vacío, precio > 0.
        //  - Generar id con repo.nextId(), crear y guardar en repo.
        //  - Redirigir a /home si es válido; si no, regresar a /admin?err=1.
        resp.sendRedirect(req.getContextPath() + "/admin?err=1"); // temporal para compilar
    }
}