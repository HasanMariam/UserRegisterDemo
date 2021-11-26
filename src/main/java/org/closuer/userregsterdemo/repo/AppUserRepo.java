package org.closuer.userregsterdemo.repo;

import org.closuer.userregsterdemo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository <AppUser,Integer>, JpaSpecificationExecutor<AppUser> {

    public Optional<AppUser> findByUserNameAndPassword (String userName, String password);
    public Optional<AppUser> findByEmail(String Email);
}
