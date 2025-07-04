package com.example.spk.services;

import com.example.spk.enumeration.HttpStatusCustom;
import com.example.spk.model.Alternatif;
import com.example.spk.payload.request.AlternatifRequest;
import com.example.spk.payload.response.AlternatifResponse;
import com.example.spk.repository.AlternatifRepository;
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
public class AlternatifServices {
    private static final Logger log = LoggerFactory.getLogger(AlternatifServices.class);

    @Autowired
    private AlternatifRepository alternatifRepository;

     public ResponseEntity<AlternatifResponse> create(AlternatifRequest alternatifRequest){
         Integer alternatif = alternatifRepository.cariAlternatifByNik(alternatifRequest.getNik());
         if (alternatif == 1){
             log.info("Error code : " + HttpStatusCustom.NIK_SUDAH_ADA.getValue() + ", Error message : " + HttpStatusCustom.NIK_SUDAH_ADA.getReasonPhrase());
             return ResponseEntity.status(HttpStatusCustom.NIK_SUDAH_ADA.getValue()).body(new AlternatifResponse());
         }

         Alternatif alternatif1 = new Alternatif();
         alternatif1.setNik(alternatifRequest.getNik());
         alternatif1.setNamaPasien(alternatifRequest.getNama());
         alternatif1.setCreatedDate(new Date());
         alternatif1.setCreatedBy("System");
         alternatif1.setUpdatedDate(new Date());
         alternatif1.setUpdatedBy("System");
         Alternatif alternatifResult = alternatifRepository.save(alternatif1);

         AlternatifResponse alternatifResponse = new AlternatifResponse();
         alternatifResponse.setId(alternatifResult.getId());
         alternatifResponse.setNik(alternatifResult.getNik());
         alternatifResponse.setNamaPasien(alternatifResult.getNamaPasien());
         return ResponseEntity.status(HttpStatus.OK).body(alternatifResponse);
     }

     public ResponseEntity<AlternatifResponse> update(AlternatifRequest alternatifRequest){
         Alternatif alternatif = alternatifRepository.selectById(alternatifRequest.getId());
         if (alternatif == null) {
             log.info("Error code : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue() + ", Error message : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
             return ResponseEntity.status(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue()).body(new AlternatifResponse());
         }

         Alternatif cekNik = alternatifRepository.selectByNik(alternatifRequest.getNik());
         if (cekNik != null && ){
             log.info("Error code : " + HttpStatusCustom.NIK_SUDAH_ADA.getValue() + ", Error message : " + HttpStatusCustom.NIK_SUDAH_ADA.getReasonPhrase());
             return ResponseEntity.status(HttpStatusCustom.NIK_SUDAH_ADA.getValue()).body(new AlternatifResponse());
         }

         alternatif.setNamaPasien(alternatifRequest.getNama());
         alternatif.setNik(alternatifRequest.getNik());
         alternatif.setUpdatedDate(new Date());
         alternatif.setUpdatedBy("System");
         Alternatif alternatifResult = alternatifRepository.save(alternatif);

         AlternatifResponse alternatifResponse =  new AlternatifResponse();
         alternatifResponse.setId(alternatifResult.getId());
         alternatifResponse.setNik(alternatifResult.getNik());
         alternatifResponse.setNamaPasien(alternatifResult.getNamaPasien());
         return ResponseEntity.status(HttpStatus.OK).body(alternatifResponse);

     }

    public ResponseEntity<String> delete(Long id){
        Alternatif alternatif = alternatifRepository.selectById(id);
        if (alternatif == null) {
            log.info("Error code : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue() + ", Error message : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
            return ResponseEntity.status(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue()).body(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
        }

        alternatifRepository.delete(alternatif);
        return ResponseEntity.status(HttpStatus.OK).body("Delete Sukses untuk id : " + id);

    }

    public ResponseEntity<List<AlternatifResponse>> selectAll(){
        List<Alternatif> alternatifList = alternatifRepository.selectAll();

        List<AlternatifResponse> alternatifResponseList = new ArrayList<>();

        for(Alternatif alternatif : alternatifList){
            AlternatifResponse alternatifResponse = new AlternatifResponse();
            alternatifResponse.setId(alternatif.getId());
            alternatifResponse.setNik(alternatif.getNik());
            alternatifResponse.setNamaPasien(alternatif.getNamaPasien());

            alternatifResponseList.add(alternatifResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(alternatifResponseList);
    }

    public ResponseEntity<AlternatifResponse> selectById(Long id){
         Alternatif alternatif = alternatifRepository.selectById(id);

         if(alternatif == null){
             log.info("Metod Select By Id untuk Id : "+ id +" tidak ditemukan");
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AlternatifResponse());
         }

         AlternatifResponse alternatifResponse = new AlternatifResponse();
         alternatifResponse.setNik(alternatif.getNik());
         alternatifResponse.setId(alternatif.getId());
         alternatifResponse.setNamaPasien(alternatif.getNamaPasien());
         return ResponseEntity.status(HttpStatus.OK).body(alternatifResponse);
    }
}
