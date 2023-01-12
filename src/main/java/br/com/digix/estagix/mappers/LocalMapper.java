package br.com.digix.estagix.mappers;

import org.mapstruct.Mapper;

import br.com.digix.estagix.dto.LocalRequestDTO;
import br.com.digix.estagix.dto.LocalResponseDTO;
import br.com.digix.estagix.model.Local;

@Mapper(componentModel = "spring")
public interface LocalMapper {
	public LocalResponseDTO  localParaLocalResponse(Local local);
	public Local localRequestParaLocal(LocalRequestDTO localRequestDTO);
}
