package br.com.cliente.resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cliente.doiman.Cliente;
import br.com.cliente.repository.ClienteRepository;

@RestController
public class ClienteApi {
	
	@Autowired
	ClienteRepository clienteRepository;
	@RequestMapping(value = "/health", method = RequestMethod.GET)
public String test () {

		return "Sistema Car ativo - " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		// classes: SimpleDateFormat e Date
	}
	/**
	 * Retorna todos o clientes cadastrados
	 * @return
	 */
	@RequestMapping(value="/clientes",method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>>obterCliente(){
		List<Clientes>clientes; //Classe List-> define um array de objeto da classe Cliente
		
		clientes=clienteRepository.findAll();
		
		if(clientes.isEmpty())
			return new
					ResponseEntity<List<Cliente>>(clientes,HttpStatus.NO_CONTENT);
		
		return new ResponseEntity <List<Cliente>>(clientes,HttpStatus.OK);
		
	}

/**Obter Cliente pelo id (chave primaria-PK)
 * 
 * @param id
 * @return
 */
	@RequestMapping(value="/clientes/{id}", method=RequestMethod.GET)
	public ResponseEntity<?>obterClienteId(@PathVariable Integer id){
		
		Optional<Cliente>  cliente; //Optional: container objeto
		
		cliente=clienteRepository.findById(id);
				
				if (cliente.isPresent())
					return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.OK);
				else
					return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.NO_CONTENT);
		
	}
	/**
	 * Inserir um novo cliente
	 * @param cliente
	 * @return
	 */
	@RequestMapping(value="/clientes", method=RequestMethod.POST)
	public ResponseEntity<Cliente> inserirClienteId(@RequestBody Cliente cliente){
		
		clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
		
	}
	
	/**
	 * Alterar um cliente existente
	 * @param client
	 * @return
	 */
	@RequestMapping(value="/clientes/{i}", method=RequestMethod.PUT)
	public ResponseEntity<Cliente> updateClienteId (@RequestBody Cliente clientePost, @PathVariable Integer id){
		
		Optional<Cliente> clienteRepo;
		
		clienteRepo= clienteRepository.findById(id);
		
		if (!clientePost.isPresent())
			return new ResponseEntity<Cliente>(clientePost,HttpStatus.NO_CONTENT);
		
		if(clientePost.getNome() !=null)
			clienteRepo.get().setNome(cliente.getNome);
	
		if(clientePost.getCidade() !=null)
			clienteRepo.get().setCidade(cliente.getCidade);
		
		if(clientePost.getEstado() !=null)
			clienteRepo.get().setEstado(cliente.getEstado);

		if(clientePost.getRg() !=null)
			clienteRepo.get().setRg(cliente.getRg);

		if(clientePost.getCpf() !=null)
			clienteRepo.get().setCpf(cliente.getCpf);

		if(clientePost.getUf() !=null)
			clienteRepo.get().setUf(cliente.getUf);

		if(clientePost.getEmail() !=null)
			clienteRepo.get().setEmail(cliente.getEmail);
		
		clienteRepository.save(clienteRepo.get());
		
		return new ResponseEntity<Cliente>(clienteRepo.get(),HttpStatus.OK);
	}
	@RequestMapping(value="/clientes/{i}", method=RequestMethod.DELETE)
	public ResponseEntity<Cliente>deleteClienteId(@RequestBody Cliente clientePost, @PathVariable Integer id){
		
		Optional<Cliente>clienteRepo;
 	
		clienteRepo=clienteRepository.findById(id);
		
		if (!clientRepo.isPresent())
		return new ResponseEntity<Cliente>(clientePost,HttpStatus.NO_CONTENT);
		
		clienteRepo.deleteById(id);
		return new ResposneEntity<cliente>(clienteRepo.get(), HttpStatus.OK);
		
	}
	
}