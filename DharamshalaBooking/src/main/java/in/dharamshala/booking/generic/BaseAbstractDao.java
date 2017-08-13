package in.dharamshala.booking.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author anshujai
 *
 * @param <PK>
 * @param <T>
 */

public abstract class BaseAbstractDao <PK extends Serializable, T>  {

		private final Class<T> persistentClass;
		
		@SuppressWarnings("unchecked")
		public BaseAbstractDao(){
			this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		}
		
		@PersistenceContext
		EntityManager entityManager;
		
		protected EntityManager getEntityManager(){
			return this.entityManager;
		}

		protected T getByKey(PK key) {
			return (T) entityManager.find(persistentClass, key);
		}

		protected T persist(T entity) {
			return entityManager.merge(entity);
		}

		protected void delete(T entity) {
			entityManager.remove(entity);
		}


}
