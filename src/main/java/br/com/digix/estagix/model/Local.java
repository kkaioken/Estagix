package br.com.digix.estagix.model;

import javax.persistence.Entity;

import br.com.digix.estagix.utils.EntidadeBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Local extends EntidadeBase {
	private String nome;
}
