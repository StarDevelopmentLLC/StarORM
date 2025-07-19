package com.stardevllc.starorm.api.database;

import com.stardevllc.converter.Converter;
import com.stardevllc.starorm.api.exception.*;

import java.util.*;
import java.util.function.Predicate;

/**
 * An interface for the contract of what a base database to be able to do
 */
@SuppressWarnings("unchecked")
public interface IDatabase {
    /**
     * Initializes the database
     * @throws InitializationException Any checked exceptions are wrapped in this unchecked exception
     */
    void init() throws InitializationException;
    
    /**
     * Deinitalizes the database
     * @throws InitializationException Any checked exceptions are wrapped in this unchecked exception
     */
    void deinit() throws InitializationException;
    
    /**
     * Adds a converter to this database. Converters are used to convert from and to types recognized by the database itself
     * @param converter The converter to add
     * @param additionalConverters Any additional converters to add
     */
    void addConverter(Converter<?, ?> converter, Converter<?, ?>... additionalConverters);
    
    /**
     * Gets a copy of the list of converters for this database
     * @return A copy of the list of converters that are registered in this database
     */
    List<Converter<?, ?>> getConverters();
    
    /**
     * Registers a class type with this database. These define the structure of the database, useful for organization and caching of things
     * @param clazz The class to register
     * @throws RegisterException Any checked exceptions are wrapped in this unchecked exception
     */
    void registerClass(Class<?> clazz) throws RegisterException;
    
    /**
     * Registers a class type like {@code registerClass} but it silences the exceptions
     * @param clazz The class to register
     */
    void registerClassSilent(Class<?> clazz);
    
    /**
     * Retrieves objects from the database
     * @param clazz The class type to get
     * @param filters Any filters to use for the class type
     * @return A non-null list of matches. This can be empty
     * @param <T> The generic type
     * @throws RetrieveException Any checked exceptions are wrapped in this unchecked exception
     */
    <T> List<T> get(Class<T> clazz, Predicate<T>... filters) throws RetrieveException;
    
    /**
     * Retrieves objects from the database while silencing the exceptions entirely
     * @param clazz The class type to get
     * @param filters Any filters to use for the class type
     * @return A non-null list of matches. This can be emtpy
     * @param <T> The generic type
     */
    default <T> List<T> getSilent(Class<T> clazz, Predicate<T>... filters) {
        try {
            return get(clazz, filters);
        } catch (Exception e) {
            return List.of();
        }
    }
    
    /**
     * Saves an object to the database
     * @param object The object to save
     * @throws SaveException Any checked exceptions are wrapped in this unchecked exception
     */
    void save(Object object) throws SaveException;
    
    /**
     * Saves an object o the database while silencing exceptions
     * @param object The object to save
     */
    default void saveSilent(Object object) {
        try {
            save(object);
        } catch (Exception e) {}
    }
    
    /**
     * Saves several objects in bulk 
     * @param objects The objects to save
     * @throws SaveException Any checked exceptions are wrapped in this unchecked exception
     */
    void bulkSave(Collection<Object> objects) throws SaveException;
    
    /**
     * Saves several objects in bulk while silencing exceptions
     * @param objects The objects to save
     */
    default void bulkSaveSilent(Collection<Object> objects) {
        try {
            bulkSave(objects);
        } catch (Exception e) {}
    }
    
    /**
     * Deletes an object from the database
     * @param object The object to delete
     * @throws DeleteException Any checked exceptions are wrapped in this unchecked exception
     */
    void delete(Object object) throws DeleteException;
    
    /**
     * Deletes an object from the database while silencing exceptions
     * @param object The object to delete
     */
    default void deleteSilent(Object object) {
        try {
            delete(object);
        } catch (Exception e) {}
    }
    
    /**
     * Deletes several objects in bulk from the database
     * @param objects The objects to delete
     * @throws DeleteException Any checked exceptions are wrapped in this unchecked exception
     */
    void bulkDelete(Collection<Object> objects) throws DeleteException;
    
    /**
     * Deletes several objects in bulk from the database while silencing exceptions
     * @param objects The objects to delete
     */
    default void bulkDeleteSilent(Collection<Object> objects) {
        try {
            bulkDelete(objects);
        } catch (Exception e) {}
    }
}