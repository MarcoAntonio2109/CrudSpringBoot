package br.com.tinnova.crudsb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.tinnova.crudsb.entities.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {

	List<Veiculo> findByAno(Integer ano);

}
