/**
 * 
 */
package ru.transpult.juniortest.services;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.transpult.juniortest.domain.dao.TestDao;

/**
 * @author kirill@krushnyakov.ru
 *
 */

@Service
@Transactional
public class FooService {

    @Autowired
    private TestDao testDao;
    
    public boolean bar() throws SystemException {
	return testDao.findOneTestEntity() != null;
    }

}
