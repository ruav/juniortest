/**
 * 
 */
package ru.transpult.juniortest.domain.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ru.transpult.juniortest.domain.entities.Test;

/**
 * @author kirill@krushnyakov.ru
 *
 */

@Repository
public class TestDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    
    public Test findOneTestEntity() {
	TypedQuery<Test> query = entityManager.createQuery("SELECT e from Test e", Test.class);
	query.setFirstResult(0);
	query.setMaxResults(1);
	Test result = null;
	try {
		result = query.getSingleResult();
	}catch (NoResultException nre){
		System.out.println("No result ;(");
	}
	return result;
    }
}
