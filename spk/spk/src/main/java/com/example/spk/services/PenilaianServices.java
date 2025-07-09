package com.example.spk.services;

import com.example.spk.enumeration.HttpStatusCustom;
import com.example.spk.model.Alternatif;
import com.example.spk.model.Penilaian;
import com.example.spk.payload.request.AlternatifRequest;
import com.example.spk.payload.request.PenilaianRequest;
import com.example.spk.payload.response.AlternatifResponse;
import com.example.spk.payload.response.PenilaianResponse;
import com.example.spk.repository.PenilaianRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class PenilaianServices {
    private static final Logger log = LoggerFactory.getLogger(PenilaianServices.class);

    @Autowired
    private PenilaianRepository penilaianRepository;

    public ResponseEntity<PenilaianResponse> create(PenilaianRequest penilaianRequest){
        Integer penilaian = penilaianRepository.cariAlternatifById(penilaianRequest.getAlternatifId());
        if (penilaian == 1){
            log.info("Error code : " + HttpStatusCustom.ID_ALTERNATIF_SUDAH_ADA.getValue() + ", Error message : " + HttpStatusCustom.ID_ALTERNATIF_SUDAH_ADA.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.ID_ALTERNATIF_SUDAH_ADA.getValue()).body(new PenilaianResponse());
        }

        Penilaian penilaian1 = new Penilaian();
        penilaian1.setAlternatifId(penilaianRequest.getAlternatifId());
        penilaian1.setId(penilaianRequest.getId());
        penilaian1.setK1(penilaianRequest.getK1());
        penilaian1.setK1Hasil(Double.valueOf(penilaianRequest.getK1())/5);
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
        penilaianResponse.setAlternatifId(penilaianResult.getAlternatifId());
        penilaianResponse.setK1(penilaianResult.getK1());
        penilaianResponse.setK1Hasil(penilaianResult.getK1Hasil());
        penilaianResponse.setK2(penilaianResult.getK2());
        penilaianResponse.setK3(penilaianResult.getK3());
        penilaianResponse.setK4(penilaianResult.getK4());
        penilaianResponse.setK5(penilaianResult.getK5());
        return ResponseEntity.status(HttpStatus.OK).body(penilaianResponse);
    }

    public ResponseEntity<PenilaianResponse> update(PenilaianRequest penilaianRequest){
        Penilaian penilaian = penilaianRepository.selectByAlternatifId(penilaianRequest.getId());
        if (penilaian == null) {
            log.info("Error code : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue() + ", Error message : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue()).body(new PenilaianResponse());
        }

        if(penilaianRequest.getAlternatifId() == null){
            log.info("Alternatif id untuk id : " + penilaianRequest.getId() + " kosong");
            return ResponseEntity.status(HttpStatusCustom.ALTERNATIF_ID_TIDAK_BOLEH_KOSONG.getValue()).body(null);
        }

        Penilaian cekAlternatifId = penilaianRepository.selectByAlternatifId(penilaianRequest.getAlternatifId());
        if (cekAlternatifId != null && cekAlternatifId.getId() != penilaian.getId()){
            log.info("Error code : " + HttpStatusCustom.ID_ALTERNATIF_SUDAH_ADA.getValue() + ", Error message : " + HttpStatusCustom.NIK_SUDAH_ADA.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.ID_ALTERNATIF_SUDAH_ADA.getValue()).body(new PenilaianResponse());
        }

        penilaian.setAlternatifId(penilaianRequest.getAlternatifId());
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
        penilaianResponse.setAlternatifId(penilaianResult.getAlternatifId());
        penilaianResponse.setK1(penilaianResult.getK1());
        penilaianResponse.setK2(penilaianResult.getK2());
        penilaianResponse.setK3(penilaianResult.getK3());
        penilaianResponse.setK4(penilaianResult.getK4());
        penilaianResponse.setK5(penilaianResult.getK5());
        return ResponseEntity.status(HttpStatus.OK).body(penilaianResponse);

    }

    public ResponseEntity<String> delete(Long id){
        Penilaian penilaian = penilaianRepository.selectByAlternatifId(id);
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
            penilaianResponse.setAlternatifId(penilaian.getAlternatifId());
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
        Penilaian penilaian= penilaianRepository.selectByAlternatifId(id);

        if(penilaian == null){
            log.info("Metod Select By Id untuk Id : "+ id +" tidak ditemukan");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PenilaianResponse());
        }

        PenilaianResponse penilaianResponse = new PenilaianResponse();
        penilaianResponse.setAlternatifId(penilaian.getAlternatifId());
        penilaianResponse.setId(penilaian.getId());
        penilaianResponse.setK1(penilaian.getK1());
        penilaianResponse.setK2(penilaian.getK2());
        penilaianResponse.setK3(penilaian.getK3());
        penilaianResponse.setK4(penilaian.getK4());
        penilaianResponse.setK5(penilaian.getK5());
        return ResponseEntity.status(HttpStatus.OK).body(penilaianResponse);
    }
}

