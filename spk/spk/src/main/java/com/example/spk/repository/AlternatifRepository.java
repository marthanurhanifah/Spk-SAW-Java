package com.example.spk.repository;

import com.example.spk.model.Alternatif;
import com.example.spk.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlternatifRepository extends JpaRepository<Alternatif, Long> {
    @Query(value = "select case when count(*) >=1 then 1 " +
            "else 0 " +
            "    end as cek_alternatif " +
            "from alternatif " +
            "where nik = :nik", nativeQuery = true)
    Integer cariAlternatifByNik(@Param("nik") String nik);

    @Query(value = "select * from alternatif " +
            "where nik = :nik", nativeQuery = true)
    Alternatif selectByNik(@Param("nik") String nik);

    @Query(value = "select * from alternatif " +
            "where id = :id", nativeQuery = true)
    Alternatif selectById(@Param("id") Long id);

    @Query(value = "select * from alternatif", nativeQuery = true)
    List<Alternatif> selectAll();

}
