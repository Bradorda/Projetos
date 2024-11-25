package DSBD.controller;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DSBD.model.Usuario;
import DSBD.model.UsuarioDAO;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@PostMapping
	public ResponseEntity<Usuario> efetuarLogin(@RequestBody Usuario usuario, HttpSession session,
			HttpServletResponse response) throws IOException {
		Usuario usuarioBCrypt = usuarioDAO.search(usuario.getUsername());

		if (usuarioBCrypt != null && BCrypt.checkpw(usuario.getPassword(), usuarioBCrypt.getPassword())) {
			session.setAttribute("usuario", usuario);
			session.setMaxInactiveInterval(3 * 86400);
			response.sendRedirect("/dashboard.html");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/check-session")
	public ResponseEntity<Void> checkSession(HttpSession session) {
		if (session.getAttribute("usuario") != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/logout")
	public ResponseEntity<Void> logout(HttpSession session, HttpServletResponse response) throws IOException {
		session.invalidate();
		response.sendRedirect("/login.html");
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
