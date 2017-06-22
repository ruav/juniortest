package ru.transpult.juniortest.utils.orika;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.transpult.juniortest.domain.entities.DepartmentEntity;
import ru.transpult.juniortest.domain.entities.EmployeeEntity;
import ru.transpult.juniortest.pojo.Department;
import ru.transpult.juniortest.pojo.Employee;

/**
 * Created by RuAV on 21.06.2017.
 */
@Component
@Qualifier("departmentMapper")
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DepartmentMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {

        factory.classMap(Department.class, DepartmentEntity.class)
                .field("id","id")
                .field("name","name")
//                .field("departments","departments")
//                .field("employees","employees")
                .byDefault()
                .register();
        }
}
