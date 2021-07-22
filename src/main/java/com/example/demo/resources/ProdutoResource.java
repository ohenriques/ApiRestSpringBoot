package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

//	RECUPERANDO TODOS OS PRODUTOS 
	@GetMapping("/produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

//	RECUPERANDO UM ÚNICO PRODUTO VIA ID
	@GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

//	INSERINDO UM ÚNICO PRODUTO VIA ID
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

//	DELETANDO UM PRODUTO
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

//	ATUALIZANDO UM PRODUTO
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
