package org.closuer.userregsterdemo.repo;

import org.closuer.userregsterdemo.entity.AppItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppItemRepo extends JpaRepository<AppItem,Integer> {
}
