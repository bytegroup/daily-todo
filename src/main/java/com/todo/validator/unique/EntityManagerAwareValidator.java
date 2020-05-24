package com.todo.validator.unique;

import javax.persistence.EntityManager;

public interface EntityManagerAwareValidator {
    void setEntityManager(EntityManager entityManager);
}
