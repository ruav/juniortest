package ru.transpult.juniortest.utils.orika;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.transpult.juniortest.domain.entities.EmployeeEntity;
import ru.transpult.juniortest.pojo.Employee;

/**
 * Created by RuAV on 21.06.2017.
 */
@Component
@Qualifier("employeeMapper")
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {

        factory.classMap(Employee.class, EmployeeEntity.class)
                .field("id","id")
                .field("name","name")
                .field("surName","surName")
//                .field("department_id","department_id")
//                .field("department","department")
                .byDefault()
                .register();
        }
}
