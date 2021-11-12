package br.org.serratec.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.dto.AlterarPedidoItemDTO;
import br.org.serratec.backend.dto.InserirPedidoItemDTO;
import br.org.serratec.backend.dto.PedidoItemDTO;
import br.org.serratec.backend.exception.CategoriaException;
import br.org.serratec.backend.exception.PedidoItemException;
import br.org.serratec.backend.model.PedidoItem;
import br.org.serratec.backend.repository.PedidoItemRepository;

@Service
public class PedidoItemService {

	@Autowired
	PedidoItemRepository pedidoItemRepository;

	/*
	 * METODO PARA INSERIR UM PEDIDO
	 */
	public PedidoItemDTO inserir(InserirPedidoItemDTO inserirPedidoItemDTO) {

		if (pedidoItemRepository.findById(inserirPedidoItemDTO.getId()) != null) {

			PedidoItem pedidoItem = new PedidoItem();
			pedidoItem.setId(pedidoItem.getId());

			return new PedidoItemDTO(pedidoItem);
		} else {
			throw new CategoriaException();
		}
	}

	/**
	 * METODO PARA ALTERAR UM PEDIDO
	 * 
	 * @param alterarPedidoItemDTO
	 * @return UM PEDIDO COM REGISTRO ALTERADO
	 */
	public PedidoItemDTO alterar(AlterarPedidoItemDTO alterarPedidoItemDTO) {

		if (pedidoItemRepository.findById(alterarPedidoItemDTO.getId()) != null) {

			PedidoItem pedidoItem = new PedidoItem();
			pedidoItem.setId(alterarPedidoItemDTO.getId());

			return new PedidoItemDTO();
		} else {
			throw new PedidoItemException();
		}
	}

	/**
	 * METODO PARA BUSCAR PEDIDO ITEM POR ID
	 * 
	 * @param id
	 * @return UM PEDIDO ITEM POR ID
	 */
	public PedidoItemDTO buscar(Long id) {
		Optional<PedidoItem> pedidoItem = pedidoItemRepository.findById(id);
		return new PedidoItemDTO(pedidoItem.get());
	}

	/**
	 * METODO PARA LISTAR PEDIDO ITEM
	 * 
	 * @return UMA LISTA DE PEDIDO ITEM
	 */
	public List<PedidoItemDTO> listar() {
		List<PedidoItem> pedidoItems = pedidoItemRepository.findAll();
		return pedidoItems.stream().map(pedidoItem -> new PedidoItemDTO(pedidoItem)).collect(Collectors.toList());
	}

	/**
	 * METODO PARA DELETAR PEDIDO ITEM
	 * 
	 * @param id
	 */
	public void deletar(Long id) {
		if (pedidoItemRepository.existsById(id)) {
			pedidoItemRepository.deleteById(id);
		}
	}
}
