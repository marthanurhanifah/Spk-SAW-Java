package com.example.spk.repository;

import com.example.spk.model.Alternatif;
import com.example.spk.model.Penilaian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PenilaianRepository extends JpaRepository<Penilaian, Long> {

    @Query(value = "select case when count(*) >=1 then 1 " +
            "else 0 " +
            "    end as cek_penilaian " +
            "from penilaian " +
            "where alternatif_id = :alternatifId", nativeQuery = true)
    Integer cariAlternatifById(@Param("alternatifId") String alternatifId);

    @Query(value = "select * from penilaian " +
            "where id = :id", nativeQuery = true)
    Penilaian selectById(@Param("id") Long id);

    @Query(value = "select * from penilaian", nativeQuery = true)
    List<Penilaian> selectAll();

    @Query(value = "select * from penilaian " +
            "where id = :id", nativeQuery = true)
    Penilaian selectByAlternatifId(@Param("id") Long id);
}
