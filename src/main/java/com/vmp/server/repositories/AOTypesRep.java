package com.vmp.server.repositories;

        import com.vmp.server.entities.MiTypesEntity;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;

@Repository
public interface AOTypesRep extends JpaRepository<MiTypesEntity, Integer> {

    List<MiTypesEntity> findAllByOrderByType();

    Optional<MiTypesEntity> findById(Integer id);
}