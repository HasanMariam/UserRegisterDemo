package org.closuer.userregsterdemo.repo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.management.relation.Role;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    //added custom common functionality for all the GenericRepository implementations
    public List<T> findByAttributeContainsText(String attributeName, Object text);
}

class GenericRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements GenericRepository<T, ID> {

    private final EntityManager entityManager;

    public GenericRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Transactional
    public List<T> findByAttributeContainsText(String attributeName, Object Obj) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());
        cQuery.select(root).where(builder.like(root.<String>get(attributeName), "%" + Obj + "%"));
        TypedQuery<T> query = entityManager.createQuery(cQuery);
        return query.getResultList();
    }
}

@Configuration
@EnableJpaRepositories(basePackages="org.closuer.userregsterdemo", repositoryBaseClass =
        GenericRepositoryImpl.class)
class JpaConfig {

}
//interface MyOtherRepository extends GenericRepository<Role, Long> {
//
//}