package br.com.digix.estagix.mappers;

import org.springframework.stereotype.Component;

import br.com.digix.estagix.dto.LocalRequestDTO;
import br.com.digix.estagix.dto.LocalResponseDTO;
import br.com.digix.estagix.model.Local;

@Component
public class LocalMapperImpl implements LocalMapper {

	@Override
	public Local localRequestParaLocal(LocalRequestDTO localRequestDTO) {
		return new Local(localRequestDTO.getNome());
	}

	@Override
	public LocalResponseDTO localParaLocalResponse(Local local) {
		return new LocalResponseDTO(local.getId(), local.getNome());
	}
}
