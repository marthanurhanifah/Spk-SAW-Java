package com.example.spk.repository;

import com.example.spk.model.Hasil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HasilRepository extends JpaRepository<Hasil, Long> {
}
