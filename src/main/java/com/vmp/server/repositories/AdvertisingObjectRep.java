package com.vmp.server.repositories;

import com.vmp.server.entities.AdvertisingObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisingObjectRep extends JpaRepository<AdvertisingObjectEntity, Integer>, JpaSpecificationExecutor<AdvertisingObjectEntity>,
        PagingAndSortingRepository<AdvertisingObjectEntity, Integer>, QueryByExampleExecutor<AdvertisingObjectEntity>,
        CrudRepository<AdvertisingObjectEntity, Integer> {


}
