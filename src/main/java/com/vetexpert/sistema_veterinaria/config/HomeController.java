package com.vetexpert.sistema_veterinaria.config;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para la página principal y el dashboard.
 */
@Controller
public class HomeController {

    /**
     * Redirige la raíz al login.
     */
    @GetMapping("/")
    public String index() {
        return "redirect:/auth/login";
    }

    /**
     * Muestra el dashboard principal del sistema.
     */
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("activePage", "dashboard");
        return "dashboard";
    }

    @GetMapping("/configuracion")
    public String configuracion(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("activePage", "configuracion");
        return "configuracion";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("activePage", "usuarios");
        return "usuarios";
    }

    @GetMapping("/reportes")
    public String reportes(HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/auth/login";
        }
        return "redirect:/caja/reportes";
    }
}
