package com.vmp.server.repositories;

        import com.vmp.server.entities.VMPUserEntity;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;

@Repository
public interface VMPUserRep extends JpaRepository<VMPUserEntity, Integer>, CrudRepository<VMPUserEntity, Integer>{

    List<VMPUserEntity> findByOrderByLastnameAscFirstnameAscLoginAsc();

    Optional<VMPUserEntity> findByLogin(String login);

    Boolean existsByLogin(String login);
}