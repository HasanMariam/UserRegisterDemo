package org.closuer.userregsterdemo.repo;

import org.closuer.userregsterdemo.entity.UserCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCodeRepo extends JpaRepository<UserCode,Integer> {
}
