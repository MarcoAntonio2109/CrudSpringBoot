package br.com.tinnova.crudsb.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tinnova.crudsb.dto.VeiculoDto;
import br.com.tinnova.crudsb.entities.Veiculo;
import br.com.tinnova.crudsb.exception.VeiculoException;
import br.com.tinnova.crudsb.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	final Logger logger =  LogManager.getLogger(VeiculoService.class.getName());
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	/**
	 * Busca todos os veiculos cadastrados.
	 * @return
	 * @throws VeiculoException
	 */
	public Iterable<Veiculo> findAll() throws VeiculoException{
		try {
			return veiculoRepository.findAll();	
		}catch (Exception e) {
			logger.error(e.getMessage());
			throw new VeiculoException(e.getMessage());		
		}
	}
	
	/**
	 * Busca todos os veiculos do Ano informado.
	 * @param ano
	 * @return
	 * @throws VeiculoException
	 */
	public List<Veiculo> findByAno(Integer ano) throws VeiculoException{
		try {
			return veiculoRepository.findByAno(ano);	
		}catch (Exception e) {
			logger.error(e.getMessage());
			throw new VeiculoException(e.getMessage());		
		}
	}

	/**
	 * Busca veiculo pelo Id informado.
	 * @param id
	 * @return
	 * @throws VeiculoException
	 */
	public Optional<Veiculo> findById(Integer id) throws VeiculoException{
		try {
			return veiculoRepository.findById(id);	
		}catch (Exception e) {
			logger.error(e.getMessage());
			throw new VeiculoException(e.getMessage());		
		}
	}

	/**
	 * Adiciona um novo veiculo.
	 * @param veiculo
	 * @return
	 * @throws VeiculoException
	 */
	public Veiculo addVeiculo (Veiculo veiculo) throws VeiculoException {
		
		try {
			veiculo.setCreated(new Date());
			return veiculoRepository.save(veiculo);
		}catch (Throwable e) {
			logger.error(e.getMessage());
			throw new VeiculoException(e.getMessage());			
		}
		
	}
	
	/**
	 * Exclui um veiculo pelo Id informado.
	 * @param id
	 * @throws VeiculoException
	 */
	public void deleteVeiculoById (Integer id) throws VeiculoException {
		try {
			veiculoRepository.deleteById(id);
		}catch (Throwable e) {
			logger.error(e.getMessage());
			throw new VeiculoException(e.getMessage());			
		}
	}
	
	/**
	 * Exclui uma lista de veiculos pelo Ano informado.
	 * @param ano
	 * @throws VeiculoException
	 */
	public void deleteVeiculoByAno (Integer ano) throws VeiculoException {
		try {
			Iterable<Veiculo> lista = veiculoRepository.findByAno(ano);
			veiculoRepository.deleteAll(lista);
		}catch (Throwable e) {
			logger.error(e.getMessage());
			throw new VeiculoException(e.getMessage());			
		}
	}
	
	/**
	 * Exclui todos os veiculos.
	 * @throws VeiculoException
	 */
	public void deleteAll () throws VeiculoException {
		try {
			veiculoRepository.deleteAll();
		}catch (Throwable e) {
			logger.error(e.getMessage());
			throw new VeiculoException(e.getMessage());			
		}
	}
	
	/**
	 * Atualiza veiculo com as informações informadas.
	 * @param veiculo
	 * @return
	 * @throws VeiculoException
	 */
	public Veiculo updateVeiculo(VeiculoDto veiculo) throws VeiculoException {
		
		try {
			if(veiculo.getId() != null) {
				
				Optional<Veiculo> obj = veiculoRepository.findById(veiculo.getId());								
				
				if(veiculo.getAno() != null) {
					obj.get().setAno(veiculo.getAno());
				}
				if(veiculo.getDescricao() != null && !veiculo.getDescricao().trim().isEmpty() ) {
					obj.get().setDescricao(veiculo.getDescricao());
				}
				if(veiculo.getDisponivel() != null ) {
					obj.get().setDisponivel(veiculo.getDisponivel());
				}
				if(veiculo.getMarca() != null && !veiculo.getMarca().trim().isEmpty()) {
					obj.get().setMarca(veiculo.getMarca());
				}
				if(veiculo.getModelo() != null && !veiculo.getModelo().trim().isEmpty()) {
					obj.get().setModelo(veiculo.getModelo());
				}
				if(veiculo.getValor() != null && veiculo.getValor() > 0 ) {
					obj.get().setValor(veiculo.getValor());;
				}
				
				obj.get().setUpdated(new Date());	
				return veiculoRepository.save(obj.get());
			}else {
				logger.error("Id Não informado", veiculo);					
				throw new VeiculoException("Id nulo");		
			}

		}catch (Throwable e) {
			logger.error(e.getMessage());
			throw new VeiculoException(e.getMessage());			
		}
		
	}
	
}
