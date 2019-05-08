package br.com.cliente.controller;

import org.springframework.web.bind.annotation.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {
	@RequestMapping(value = "/clienteView", method = RequestMethod.GET)
	public String getClienteView() {
		     
		   return "clienteView";
	}
	
	@RequestMapping(value = "/clienteView2", method = RequestMethod.GET)
	public String getClienteView2() {
		     
		   return "clienteView2";
	}
	
	@RequestMapping(value = "/clienteView3", method = RequestMethod.GET)
	public String getClienteView3() {
		     
		   return "clienteView3";
	}
}