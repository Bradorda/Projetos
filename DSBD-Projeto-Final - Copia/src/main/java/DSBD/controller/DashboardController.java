package DSBD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import DSBD.model.Venda;
import DSBD.model.VendaDAO;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	private VendaDAO vendaDAO;
	
	@GetMapping
	public ResponseEntity<List> buscarTodasVendas(){
		List <Venda> vendas = vendaDAO.buscarAllVendas();
		if(!vendas.isEmpty() && vendas != null) {
			return new ResponseEntity<>(vendas, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
