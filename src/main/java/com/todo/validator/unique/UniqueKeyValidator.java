package com.todo.validator.unique;

import com.todo.user.repo.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class UniqueKeyValidator implements ConstraintValidator<UniqueKey, Serializable>, EntityManagerAwareValidator {
    private static final Logger logger= LogManager.getLogger(UniqueKeyValidator.class);

    @Autowired
    private EntityManager entityManager;

    @PersistenceContext
    private EntityManager entityManager2;

    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void setEntityManager(EntityManager entityManager){
        if (entityManager==null){
            logger.debug("entityManage is null");

        }else {
            this.entityManager = entityManager;
        }
    }

    private String[] columnNames;

    @Override
    public void initialize(UniqueKey constraintAnnotation) {
        this.columnNames = constraintAnnotation.columnNames();

    }

    @Override
    public boolean isValid(Serializable target, ConstraintValidatorContext context) {
        Class<?> entityClass = target.getClass();

        //this.entityManager=entityManagerFactory.getCriteriaBuilder();

        logger.debug("entityManagerf: "+entityManagerFactory);
        logger.debug("entityManager: "+entityManager);
        logger.debug("entityManager2: "+entityManager2);

        CriteriaBuilder criteriaBuilder = entityManagerFactory.getCriteriaBuilder();

        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();

        Root<?> root = criteriaQuery.from(entityClass);

        List<Predicate> predicates = new ArrayList<Predicate>(columnNames.length);

        try {
            for(int i=0; i<columnNames.length; i++) {
                String propertyName = columnNames[i];
                PropertyDescriptor desc = new PropertyDescriptor(propertyName, entityClass);
                Method readMethod = desc.getReadMethod();
                Object propertyValue = readMethod.invoke(target);
                Predicate predicate = criteriaBuilder.equal(root.get(propertyName), propertyValue);
                predicates.add(predicate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<Object> typedQuery = entityManager.createQuery(criteriaQuery);

        List<Object> resultSet = typedQuery.getResultList();

        return resultSet.size() == 0;
    }

}
