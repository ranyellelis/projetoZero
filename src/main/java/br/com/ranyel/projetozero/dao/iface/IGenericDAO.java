package br.com.ranyel.projetozero.dao.iface;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import br.com.ranyel.projetozero.exception.DaoException;

/**
 * @author ranyel
 *
 * @param <T> Classe de domínio.
 * @param <ID> id da classe de domínio.
 */
public interface IGenericDAO<T, ID extends Serializable> {
	
	/**
	 * Salvar (Criar ou atualizar)
	 * @param obj objeto a ser criado ou atualizado.
	 * @throws DaoException daoException.
	 */
	void save(final T obj) throws DaoException;
	
	/**
	 * Deletar/excluir
	 * @param obj objeto a ser deletado.
	 * @throws DaoException daoException.
	 */
	void delete(final T obj) throws DaoException;
	
	/**
	 * Busca uma entidade pelo seu id.
	 * @param id
	 * @return objeto pesquisado.
	 * @throws DaoException daoException.
	 */
	T findById(ID id) throws DaoException;
	
	/**
	 * Busca todos os registros de uma entidade.
	 * @return lista de objetos da entidade pesquisada.
	 * @throws DaoException daoException.
	 */
	List<T> findAll() throws DaoException;
	
	/**
	 * Busca entidades baseado nas propriedades de um exemplo passado como parâmetro.
	 * @param example exemplo.
	 * @return lista de objetos da entidade pesquisada.
	 * @throws DaoException daoException.
	 */
	List<T> findByExample(T example) throws DaoException;
	
	
	/**
	 * Buscar entidades através de Criterions, adicionados à uma Criteria.
	 * @param criterions lista de Criterion.
	 * @return lista de entidades pesquisadas.
	 * @throws DaoException daoException.
	 */
	List<T> findByCriterions(List<Criterion> criterions) throws DaoException;
}
