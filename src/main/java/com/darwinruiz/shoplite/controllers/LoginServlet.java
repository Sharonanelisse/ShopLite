package com.darwinruiz.shoplite.controllers;

import com.darwinruiz.shoplite.models.User;
import com.darwinruiz.shoplite.repositories.UserRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

/**
 * Requisito: autenticar, regenerar sesión y guardar auth, userEmail, role, TTL.
 */
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
    private final UserRepository users = new UserRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        Optional<User> u = users.findByEmail(email);

        // Requisito:
        //  - Si credenciales inválidas → redirect a login.jsp?err=1
        //  - Si válidas → invalidar sesión previa, crear nueva y setear:
        //      auth=true, userEmail, role, maxInactiveInterval (p.ej. 30 min)
        //  - Redirigir a /home

        resp.sendRedirect(req.getContextPath() + "/home"); // temporal para compilar
    }
}
