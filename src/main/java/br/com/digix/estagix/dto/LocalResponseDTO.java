package br.com.digix.estagix.dto;

import br.com.digix.estagix.utils.EntidadeBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalResponseDTO {
	private Long id;
	private String nome; 
}
