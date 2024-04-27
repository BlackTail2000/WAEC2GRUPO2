package pe.edu.cibertec.WAEC2GRUPO2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Usuario;
import pe.edu.cibertec.WAEC2GRUPO2.model.dto.security.UsuarioSecurity;
import pe.edu.cibertec.WAEC2GRUPO2.service.UsuarioService;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {

    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        return "backoffice/auth/frmLogin";
    }

    @GetMapping("/registrar")
    public String registrar(Model model){
        model.addAttribute("nuevoUsuario", new Usuario());
        return "backoffice/auth/frmRegistroUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario){
        usuarioService.guardarNuevoUsuario(nuevoUsuario);
        return "redirect:/auth/login";
    }

    @GetMapping("/login-success")
    public String loginSucces(){
        return "redirect:/auth/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UsuarioSecurity usuario = (UsuarioSecurity) userDetails;
        String nomusuario = usuario.getNombre();
        String email = usuario.getEmail();
        session.setAttribute("nomusuario", nomusuario);
        session.setAttribute("usuario", email);
        return "backoffice/auth/home"; // Return the dashboard page
    }

}
