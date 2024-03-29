package br.com.digix.estagix.mappers;

import java.util.ArrayList;
import java.util.Collection;

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

	@Override
	public Collection<LocalResponseDTO> locaisParaLocalResponse(Collection<Local> locais) {
		Collection<LocalResponseDTO> locaisDTO = new ArrayList<>();
		for (Local local : locais) {
			locaisDTO.add(this.localParaLocalResponse(local));
		}
		return locaisDTO;
	}
}
