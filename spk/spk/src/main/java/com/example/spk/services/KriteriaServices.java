package com.example.spk.services;

import com.example.spk.enumeration.HttpStatusCustom;
import com.example.spk.model.Alternatif;
import com.example.spk.model.Kriteria;
import com.example.spk.payload.request.AlternatifRequest;
import com.example.spk.payload.request.KriteriaRequest;
import com.example.spk.payload.response.AlternatifResponse;
import com.example.spk.payload.response.KriteriaResponse;
import com.example.spk.repository.AlternatifRepository;
import com.example.spk.repository.KriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
public class KriteriaServices {

    @Autowired
    private KriteriaRepository kriteriaRepository;

    public ResponseEntity<KriteriaResponse> create(KriteriaRequest kriteriaRequest){
        Integer kriteria = kriteriaRepository.cariKriteriaByNama(kriteriaRequest.getNamaKriteria());
        if (kriteria == 1){
            log.info("Error code : " + HttpStatusCustom.NAMA_SUDAH_ADA.getValue() + ", Error message : " + HttpStatusCustom.NAMA_SUDAH_ADA.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.NAMA_SUDAH_ADA.getValue()).body(new KriteriaResponse());
        }

        Kriteria kriteria1 = new Kriteria();
        kriteria1.setNamaKriteria(kriteriaRequest.getNamaKriteria());
        kriteria1.setBobotKriteria(kriteriaRequest.getBobotKriteria());
        kriteria1.setCreatedDate(new Date());
        kriteria1.setCreatedBy("System");
        kriteria1.setUpdatedDate(new Date());
        kriteria1.setUpdatedBy("System");
        Kriteria kriteriaResult = kriteriaRepository.save(kriteria1);

        KriteriaResponse kriteriaResponse = new KriteriaResponse();
        kriteriaResponse.setId(kriteriaResult.getId());
        kriteriaResponse.setNamaKriteria(kriteriaResult.getNamaKriteria());
        kriteriaResponse.setBobotKriteria(kriteriaResult.getBobotKriteria());
        return ResponseEntity.status(HttpStatus.OK).body(kriteriaResponse);
    }

    public ResponseEntity<KriteriaResponse> update(KriteriaRequest kriteriaRequest){
        Kriteria kriteria = kriteriaRepository.cariKriteriaById(kriteriaRequest.getId());
        if (kriteria == null) {
            log.info("Error code : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue() + ", Error message : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue()).body(new KriteriaResponse());
        }

        Kriteria cekNamaKriteria = kriteriaRepository.selectByNamaKriteria(kriteriaRequest.getNamaKriteria());
        if (cekNamaKriteria != null){
            log.info("Error code : " + HttpStatusCustom.NAMA_SUDAH_ADA.getValue() + ", Error message : " + HttpStatusCustom.NAMA_SUDAH_ADA.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.NAMA_SUDAH_ADA.getValue()).body(new KriteriaResponse());
        }

        kriteria.setNamaKriteria(kriteriaRequest.getNamaKriteria());
        kriteria.setBobotKriteria(kriteriaRequest.getBobotKriteria());
        kriteria.setUpdatedDate(new Date());
        kriteria.setUpdatedBy("System");
        Kriteria kriteriaResult = kriteriaRepository.save(kriteria);

        KriteriaResponse kriteriaResponse =  new KriteriaResponse();
        kriteriaResponse.setId(kriteriaResult.getId());
        kriteriaResponse.setNamaKriteria(kriteriaResult.getNamaKriteria());
        kriteriaResponse.setBobotKriteria(kriteriaResult.getBobotKriteria());
        return ResponseEntity.status(HttpStatus.OK).body(kriteriaResponse);

    }

    public ResponseEntity<String> delete(Long id){
        Kriteria kriteria = kriteriaRepository.cariKriteriaById(id);
        if (kriteria == null) {
            log.info("Error code : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue() + ", Error message : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue()).body(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
        }

        kriteriaRepository.delete(kriteria);
        return ResponseEntity.status(HttpStatus.OK).body("Delete Sukses untuk id : " + id);

    }

    public ResponseEntity<List<KriteriaResponse>> selectAll(){
        List<Kriteria> kriteriaList = kriteriaRepository.selectAll();

        List<KriteriaResponse> kriteriaResponseList = new ArrayList<>();

        for(Kriteria kriteria : kriteriaList){
            KriteriaResponse kriteriaResponse = new KriteriaResponse();
            kriteriaResponse.setId(kriteria.getId());
            kriteriaResponse.setNamaKriteria(kriteria.getNamaKriteria());
            kriteriaResponse.setBobotKriteria(kriteria.getBobotKriteria());

            kriteriaResponseList.add(kriteriaResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(kriteriaResponseList);
    }

    public ResponseEntity<KriteriaResponse> cariKriteriaById(Long id){
        Kriteria kriteria = kriteriaRepository.cariKriteriaById(id);

        if(kriteria == null){
            log.info("Metod Select By Id untuk Id : "+ id +" tidak ditemukan");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new KriteriaResponse());
        }

        KriteriaResponse kriteriaResponse = new KriteriaResponse();
        kriteriaResponse.setNamaKriteria(kriteria.getNamaKriteria());
        kriteriaResponse.setId(kriteria.getId());
        kriteriaResponse.setBobotKriteria(kriteria.getBobotKriteria());
        return ResponseEntity.status(HttpStatus.OK).body(kriteriaResponse);
    }

}
