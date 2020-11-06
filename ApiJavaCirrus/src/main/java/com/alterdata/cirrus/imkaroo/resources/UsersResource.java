package com.alterdata.cirrus.imkaroo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alterdata.cirrus.imkaroo.models.User;
import com.alterdata.cirrus.imkaroo.repository.UsersRepository;

import io.swagger.annotations.*;

@RestController
@RequestMapping(value="/api")
@Api(value="Api REST Alterdata Cirrus")
@CrossOrigin(origins="*")
public class UsersResource {
	
	@Autowired
	UsersRepository usersRepository;
	
	@GetMapping("/users")
	@ApiOperation(value="Retorna uma lista de usuarios")
	public ResponseEntity<List<User>> listUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(usersRepository.findAll());
	}
	
	@GetMapping("/users/{id}")
	@ApiOperation(value="Retorna um usuario pelo id passado na rota")
	public ResponseEntity<Optional<User>> getById(@PathVariable(value="id") long id) {
		return ResponseEntity.status(HttpStatus.OK).body(usersRepository.findById(id));
	}
	
	@PostMapping("/users")
	@ApiOperation(value="Adiciona um usuario a lista")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.OK).body(usersRepository.save(user)); 
	}
	
	@DeleteMapping("/users/{id}")
	@ApiOperation(value="Deleta um usuario da lista")
	public void deleteUser(@PathVariable(value="id") long id) {
		usersRepository.deleteById(id);
	}
	
	@PutMapping("/users")
	@ApiOperation(value="Atualiza um usuario")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.ok(usersRepository.save(user));
	}

}
