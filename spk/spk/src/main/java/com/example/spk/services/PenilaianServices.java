//package com.example.spk.services;
//
//import com.example.spk.enumeration.HttpStatusCustom;
//import com.example.spk.model.Alternatif;
//import com.example.spk.model.Kriteria;
//import com.example.spk.model.Penilaian;
//import com.example.spk.payload.request.AlternatifRequest;
//import com.example.spk.payload.request.PenilaianRequest;
//import com.example.spk.payload.response.AlternatifResponse;
//import com.example.spk.payload.response.PenilaianReaponse;
//import com.example.spk.repository.AlternatifRepository;
//import com.example.spk.repository.PenilaianRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//import static org.hibernate.query.sqm.tree.SqmNode.log;
//
//@Service
//public class PenilaianServices {
//
//    @Autowired
//    private PenilaianRepository penilaianRepository;
//
//    public ResponseEntity<PenilaianReaponse> create(PenilaianRequest penilaianRequest){
//        Integer penilaian = penilaianRepository.cariAlternatifByNik(alternatifRequest.getNik());
//        if (alternatif == 1){
//            log.info("Error code : " + HttpStatusCustom.NIK_SUDAH_ADA.getValue() + ", Error message : " + HttpStatusCustom.NIK_SUDAH_ADA.getReasonPhrase());
//            return ResponseEntity.status(HttpStatusCustom.NIK_SUDAH_ADA.getValue()).body(new AlternatifResponse());
//        }
//
//        Alternatif alternatif1 = new Alternatif();
//        alternatif1.setNik(alternatifRequest.getNik());
//        alternatif1.setNamaPasien(alternatifRequest.getNama());
//        alternatif1.setCreatedDate(new Date());
//        alternatif1.setCreatedBy("System");
//        alternatif1.setUpdatedDate(new Date());
//        alternatif1.setUpdatedBy("System");
//        Alternatif alternatifResult = alternatifRepository.save(alternatif1);
//
//        AlternatifResponse alternatifResponse = new AlternatifResponse();
//        alternatifResponse.setId(alternatifResult.getId());
//        alternatifResponse.setNik(alternatifResult.getNik());
//        alternatifResponse.setNamaPasien(alternatifResult.getNamaPasien());
//        return ResponseEntity.status(HttpStatus.OK).body(alternatifResponse);
//    }
//    public ResponseEntity<PenilaianReaponse> update(PenilaianRequest penilaianRequest){
//        Penilaian penilaian = penilaianRepository.selectById(penilaianRequest.getId());
//        if (penilaian == null) {
//            log.info("Error code : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue() + ", Error message : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
//            return ResponseEntity.status(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue()).body(new PenilaianReaponse());
//        }
//
//        Penilaian cekNik = alternatifRepository.selectByNik(alternatifRequest.getNik());
//        if (cekNik != null){
//            log.info("Error code : " + HttpStatusCustom.NIK_SUDAH_ADA.getValue() + ", Error message : " + HttpStatusCustom.NIK_SUDAH_ADA.getReasonPhrase());
//            return ResponseEntity.status(HttpStatusCustom.NIK_SUDAH_ADA.getValue()).body(new AlternatifResponse());
//        }
//
//        alternatif.setNamaPasien(alternatifRequest.getNama());
//        alternatif.setNik(alternatifRequest.getNik());
//        alternatif.setUpdatedDate(new Date());
//        alternatif.setUpdatedBy("System");
//        Alternatif alternatifResult = alternatifRepository.save(alternatif);
//
//        AlternatifResponse alternatifResponse =  new AlternatifResponse();
//        alternatifResponse.setId(alternatifResult.getId());
//        alternatifResponse.setNik(alternatifResult.getNik());
//        alternatifResponse.setNamaPasien(alternatifResult.getNamaPasien());
//        return ResponseEntity.status(HttpStatus.OK).body(alternatifResponse);
//
//    }
//
//    public ResponseEntity<String> delete(Long id){
//        Alternatif alternatif = alternatifRepository.selectById(id);
//        if (alternatif == null) {
//            log.info("Error code : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue() + ", Error message : " + HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
//            return ResponseEntity.status(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getValue()).body(HttpStatusCustom.ID_TIDAK_DITEMUKAN.getReasonPhrase());
//        }
//
//        alternatifRepository.delete(alternatif);
//        return ResponseEntity.status(HttpStatus.OK).body("Delete Sukses untuk id : " + id);
//
//    }
//}
