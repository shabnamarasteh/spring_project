package org.j2os.monitor.modules.utils.Interfaces.validate;

import org.j2os.monitor.modules.utils.ValidateObject;

public interface ValidateInterface<T> {
    ValidateObject addValidate(T t);
    ValidateObject updateValidate(T t);
    ValidateObject findAllValidate();
    ValidateObject deleteValidate(T t);
    ValidateObject findOneValidate(T t);
    ValidateObject findByIdValidate(long id);
}
