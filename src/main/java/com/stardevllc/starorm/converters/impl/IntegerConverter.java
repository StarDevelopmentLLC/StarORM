package com.stardevllc.starorm.converters.impl;

import com.stardevllc.starorm.model.Column;
import com.stardevllc.starorm.converters.SQLConverter;

public class IntegerConverter extends SQLConverter<Integer> {
    public IntegerConverter() {
        super(Integer.class, "int");
        addAdditionalClass(int.class);
    }
    
    private static Integer parse(Column column, Object object) {
        if (object instanceof Number number) {
            return number.intValue();
        } else if (object instanceof String str) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    @Override
    public Object serializeToSQL(Column column, Object input) {
        return parse(column, input);
    }

    @Override
    public Integer deserializeFromSQL(Column column, Object input) {
        return parse(column, input);
    }
}
