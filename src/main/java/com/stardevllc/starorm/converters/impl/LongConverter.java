package com.stardevllc.starorm.converters.impl;

import com.stardevllc.starorm.model.Column;
import com.stardevllc.starorm.converters.SQLConverter;

public class LongConverter extends SQLConverter<Long> {
    public LongConverter() {
        super(Long.class, "bigint");
        addAdditionalClass(long.class);
    }
    
    private static Long parse(Column column, Object object) {
        if (object instanceof Number number) {
            return number.longValue();
        } else if (object instanceof String str) {
            return Long.parseLong(str);
        }
        return 0L;
    }

    @Override
    public Object serializeToSQL(Column column, Object input) {
        return parse(column, input);
    }

    @Override
    public Long deserializeFromSQL(Column column, Object input) {
        return parse(column, input);
    }
}
