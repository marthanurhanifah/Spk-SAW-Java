package com.example.spk.repository;

import com.example.spk.model.Alternatif;
import com.example.spk.model.Penilaian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PenilaianRepository extends JpaRepository<Penilaian, Long> {

    @Query(value = "select * from penilaian " +
            "where id = :id", nativeQuery = true)
    Penilaian selectById(@Param("id") Long id);
}
