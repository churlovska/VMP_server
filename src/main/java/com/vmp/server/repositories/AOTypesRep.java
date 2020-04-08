package com.vmp.server.repositories;

        import com.vmp.server.entities.AOTypesEntity;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;

@Repository
public interface AOTypesRep extends JpaRepository<AOTypesEntity, Integer> {

    @Override
    List<AOTypesEntity> findAll();

    Optional<AOTypesEntity> findById(Integer id);

}