package fr.gamedev.question.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.data.Tags;

//TODO grp6 by DJE : CheckStyle : Par defaut Eclipse laisse la première ligne (description) de la JavaDoc vide. CheckStyle indique les espace "inutile" en fin de ligne. Ce message doit vous faire comprendre qu'il MANQUE la Description de la classe.  
/**
 * 
 * @author nicolas
 *
 */
@RepositoryRestResource(collectionResourceRel = "tag", path = "tag")
public interface TagsRepository extends PagingAndSortingRepository<Tags, Long> {

}
