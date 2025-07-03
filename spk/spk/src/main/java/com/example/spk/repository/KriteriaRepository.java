package com.example.spk.repository;

import com.example.spk.model.Alternatif;
import com.example.spk.model.Kriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KriteriaRepository extends JpaRepository<Kriteria, Long> {

    @Query(value = "select case when count(*) >=1 then 1 " +
            "else 0 " +
            "    end as cek_kriteria " +
            "from kriteria " +
            "where nama_kriteria = :nama_kriteria", nativeQuery = true)
    Integer cariKriteriaByNama(@Param("nama_kriteria") String namaKriteria);

    @Query(value = "select * from kriteria " +
            "where id = :id", nativeQuery = true)
    Kriteria cariKriteriaById(@Param("id") Long id);

    @Query(value = "select * from kriteria " +
            "where nama_kriteria = :nama_kriteria", nativeQuery = true)
    Kriteria selectByNamaKriteria(@Param("nama_kriteria") String namaKriteria);
}
