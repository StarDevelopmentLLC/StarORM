package com.stardevllc.starorm.sql.database;

import com.stardevllc.converter.Converter;
import com.stardevllc.starorm.api.database.Database;
import com.stardevllc.starorm.api.exception.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class SQLDatabase implements Database {
    @Override
    public void init() throws InitializationException {
        
    }
    
    @Override
    public void deinit() throws InitializationException {
        
    }
    
    @Override
    public void addConverter(Converter<?, ?> converter, Converter<?, ?>... additionalConverters) {
        
    }
    
    @Override
    public List<Converter<?, ?>> getConverters() {
        return List.of();
    }
    
    @Override
    public void registerClass(Class<?> clazz) throws RegisterException {
        
    }
    
    @Override
    public void registerClassSilent(Class<?> clazz) {
        
    }
    
    @Override
    public <T> List<T> get(Class<T> clazz, Predicate<T>... filters) throws RetrieveException {
        return List.of();
    }
    
    @Override
    public void save(Object object) throws SaveException {
        
    }
    
    @Override
    public void bulkSave(Collection<Object> objects) throws SaveException {
        
    }
    
    @Override
    public void delete(Object object) throws DeleteException {
        
    }
    
    @Override
    public void bulkDelete(Collection<Object> objects) throws DeleteException {
        
    }
}
