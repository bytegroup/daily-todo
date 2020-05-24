package com.todo.validator.unique;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManagerFactory;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

public class ConstraintValidatorFactoryImpl implements ConstraintValidatorFactory {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    /*@PersistenceContext
    private EntityManager entityManager;*/

    public ConstraintValidatorFactoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
        T instance = null;

        try {
            instance = key.newInstance();
        } catch (Exception e) {
            // could not instantiate class
            e.printStackTrace();
        }

        if(EntityManagerAwareValidator.class.isAssignableFrom(key)) {
            EntityManagerAwareValidator validator = (EntityManagerAwareValidator) instance;
            validator.setEntityManager(entityManagerFactory.createEntityManager());
        }

        return instance;
    }

    @Override
    public void releaseInstance(ConstraintValidator<?, ?> var1){

    }
}
