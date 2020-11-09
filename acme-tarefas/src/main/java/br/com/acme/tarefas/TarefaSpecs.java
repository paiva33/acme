package br.com.acme.tarefas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TarefaSpecs {
	
	/**
     * Retorna {@code Specification} com os filtros de pesquisa.
     * 
     */
    public static Specification<Tarefa> withFilter(TarefaFilter filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotBlank(filter.getTitulo())) {
                predicates.add(builder.like(builder.lower(root.get("titulo")), filter.getTitulo().toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
