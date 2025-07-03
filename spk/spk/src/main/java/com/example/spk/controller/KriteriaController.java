package com.example.spk.controller;

import com.example.spk.model.Kriteria;
import com.example.spk.payload.request.AlternatifRequest;
import com.example.spk.payload.request.KriteriaRequest;
import com.example.spk.payload.response.AlternatifResponse;
import com.example.spk.payload.response.KriteriaResponse;
import com.example.spk.repository.KriteriaRepository;
import com.example.spk.services.AlternatifServices;
import com.example.spk.services.KriteriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kriteria")
public class KriteriaController {

    @Autowired
    private KriteriaServices kriteriaServices;

    @PostMapping("/create")
    public ResponseEntity<KriteriaResponse> create(@RequestBody KriteriaRequest kriteriaRequest){
        ResponseEntity<KriteriaResponse> create = kriteriaServices.create(kriteriaRequest);
        return create;
    }

    @PutMapping("/update")
    public ResponseEntity<KriteriaResponse> update(@RequestBody KriteriaRequest kriteriaRequest) {
        ResponseEntity<KriteriaResponse> update = kriteriaServices.update(kriteriaRequest);
        return update;
    }

   @DeleteMapping("/deleteWithReqParam")
    public ResponseEntity<String> deleteWithReqParam(@RequestParam("id") Long id) {
       return kriteriaServices.delete(id);
    }

   @DeleteMapping("/deletePathVar/{id}")
   public ResponseEntity<String> deletePathVar(@PathVariable("id") Long id) {
     return kriteriaServices.delete(id);
   }
}
