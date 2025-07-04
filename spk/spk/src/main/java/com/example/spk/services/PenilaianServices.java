package com.example.spk.services;

import com.example.spk.enumeration.HttpStatusCustom;
import com.example.spk.model.Alternatif;
import com.example.spk.model.Penilaian;
import com.example.spk.payload.request.PenilaianRequest;
import com.example.spk.payload.response.AlternatifResponse;
import com.example.spk.payload.response.PenilaianResponse;
import com.example.spk.repository.PenilaianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
public class PenilaianServices {

    @Autowired
    private PenilaianRepository penilaianRepository;

    public ResponseEntity<PenilaianResponse> create(PenilaianRequest penilaianRequest){
        Penilaian penilaian = penilaianRepository.selectByAlternatifId(penilaianRequest.getAlternatif_id());
        if (penilaian == null){
            log.info("Error code : " + HttpStatusCustom.ID_ALTERNATIF_SUDAH_ADA.getValue() + ", Error message : " + HttpStatusCustom.NIK_SUDAH_ADA.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.ID_ALTERNATIF_SUDAH_ADA.getValue()).body(new PenilaianResponse());
        }

        Penilaian penilaian1 = new Penilaian();
        penilaian1.setAlternatif_id(penilaianRequest.getAlternatif_id());
        penilaian1.setId(penilaianRequest.getId());
        penilaian1.setK1(penilaianRequest.getK1());
        penilaian1.setK2(penilaianRequest.getK2());
        penilaian1.setK3(penilaianRequest.getK3());
        penilaian1.setK4(penilaianRequest.getK4());
        penilaian1.setK5(penilaianRequest.getK5());
        penilaian1.setCreatedDate(new Date());
        penilaian1.setCreatedBy("System");
        penilaian1.setUpdatedDate(new Date());
        penilaian1.setUpdatedBy("System");
        Penilaian penilaianResult = penilaianRepository.save(penilaian1);

        PenilaianResponse penilaianResponse = new PenilaianResponse();
        penilaianResponse.setId(penilaianResult.getId());
        penilaianResponse.setAlternatif_id(penilaianResult.getAlternatif_id());
        penilaianResponse.setK1(penilaianResult.getK1());
        penilaianResponse.setK2(penilaianResult.getK2());
        penilaianResponse.setK3(penilaianResult.getK3());
        penilaianResponse.setK4(penilaianResult.getK4());
        penilaianResponse.setK5(penilaianResult.getK5());
        return ResponseEntity.status(HttpStatus.OK).body(penilaianResponse);
    }

    public ResponseEntity<PenilaianResponse> update(PenilaianRequest penilaianRequest){
        Penilaian penilaian = penilaianRepository.selectById(penilaianRequest.getId());
        if (penilaian == null) {
            log.info("Error code : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue() + ", Error message : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue()).body(new PenilaianResponse());
        }

        Penilaian cekAlternatifId = penilaianRepository.selectByAlternatifId(penilaianRequest.getAlternatif_id());
        if (cekAlternatifId != null){
            log.info("Error code : " + HttpStatusCustom.NIK_SUDAH_ADA.getValue() + ", Error message : " + HttpStatusCustom.NIK_SUDAH_ADA.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.NIK_SUDAH_ADA.getValue()).body(new PenilaianResponse());
        }

        penilaian.setAlternatif_id(penilaianRequest.getAlternatif_id());
        penilaian.setK1(penilaianRequest.getK1());
        penilaian.setK2(penilaianRequest.getK2());
        penilaian.setK3(penilaianRequest.getK3());
        penilaian.setK4(penilaianRequest.getK4());
        penilaian.setK5(penilaianRequest.getK5());
        penilaian.setUpdatedDate(new Date());
        penilaian.setUpdatedBy("System");
        Penilaian penilaianResult = penilaianRepository.save(penilaian);

        PenilaianResponse penilaianResponse =  new PenilaianResponse();
        penilaianResponse.setId(penilaianResult.getId());
        penilaianResponse.setAlternatif_id(penilaianResult.getAlternatif_id());
        penilaianResponse.setK1(penilaianResult.getK1());
        penilaianResponse.setK2(penilaianResult.getK2());
        penilaianResponse.setK3(penilaianResult.getK3());
        penilaianResponse.setK4(penilaianResult.getK4());
        penilaianResponse.setK5(penilaianResult.getK5());
        return ResponseEntity.status(HttpStatus.OK).body(penilaianResponse);

    }

    public ResponseEntity<String> delete(Long id){
        Penilaian penilaian = penilaianRepository.selectById(id);
        if (penilaian == null) {
            log.info("Error code : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue() + ", Error message : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue()).body(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
        }

        penilaianRepository.delete(penilaian);
        return ResponseEntity.status(HttpStatus.OK).body("Delete Sukses untuk id : " + id);

    }

    public ResponseEntity<List<PenilaianResponse>> selectAll(){
        List<Penilaian> penilaianList = penilaianRepository.selectAll();

        List<PenilaianResponse> penilaianResponseList = new ArrayList<>();

        for(Penilaian penilaian : penilaianList){
            PenilaianResponse penilaianResponse = new PenilaianResponse();
            penilaianResponse.setId(penilaian.getId());
            penilaianResponse.setAlternatif_id(penilaian.getAlternatif_id());
            penilaianResponse.setK1(penilaian.getK1());
            penilaianResponse.setK2(penilaian.getK2());
            penilaianResponse.setK3(penilaian.getK3());
            penilaianResponse.setK4(penilaian.getK4());
            penilaianResponse.setK5(penilaian.getK5());

            penilaianResponseList.add(penilaianResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(penilaianResponseList);
    }

    public ResponseEntity<PenilaianResponse> selectById(Long id){
        Penilaian penilaian= penilaianRepository.selectById(id);

        if(penilaian == null){
            log.info("Metod Select By Id untuk Id : "+ id +" tidak ditemukan");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PenilaianResponse());
        }

        PenilaianResponse penilaianResponse = new PenilaianResponse();
        penilaianResponse.setAlternatif_id(penilaian.getAlternatif_id());
        penilaianResponse.setId(penilaian.getId());
        penilaianResponse.setK1(penilaian.getK1());
        penilaianResponse.setK2(penilaian.getK2());
        penilaianResponse.setK3(penilaian.getK3());
        penilaianResponse.setK4(penilaian.getK4());
        penilaianResponse.setK5(penilaian.getK5());
        return ResponseEntity.status(HttpStatus.OK).body(penilaianResponse);
    }
}

