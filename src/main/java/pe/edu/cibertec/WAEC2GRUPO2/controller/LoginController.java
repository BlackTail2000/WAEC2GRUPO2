package pe.edu.cibertec.WAEC2GRUPO2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        String username = usuario.getUsername();
        session.setAttribute("nomusuario", nomusuario);
        session.setAttribute("usuario", email);
        session.setAttribute("username", username);
        return "backoffice/auth/home"; // Return the dashboard page
    }

    @GetMapping("/cambiarPassword")
    public String cambiarPassword(){
        return "backoffice/auth/frmCambiarContraseña";
    }

    @PostMapping("/cambiarPassword")
    public String cambiarPassword(@RequestParam("password1") String password1,
                                  @RequestParam("password2") String password2,
                                  HttpServletRequest request){
        HttpSession session = request.getSession();
        if(!password1.equals(password2)){
            return "backoffice/auth/frmCambiarContraseña";
        } else {
            usuarioService.actualizarPassword(password1, session.getAttribute("username").toString());
            return "redirect:/auth/dashboard";
        }
    }
}
