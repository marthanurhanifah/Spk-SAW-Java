package com.example.spk.controller;

import com.example.spk.payload.request.PenilaianRequest;
import com.example.spk.payload.response.KriteriaResponse;
import com.example.spk.payload.response.PenilaianResponse;
import com.example.spk.services.PenilaianServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/penilaian")
public class PenilaianController {

    @Autowired
    private PenilaianServices penilaianServices;

    @PostMapping("/create")
    public ResponseEntity<PenilaianResponse> create(@RequestBody PenilaianRequest penilaianRequest){
        ResponseEntity<PenilaianResponse> create = penilaianServices.create(penilaianRequest);
        return create;
    }

    @PutMapping("/update")
    public ResponseEntity<PenilaianResponse> update(@RequestBody PenilaianRequest penilaianRequest) {
        ResponseEntity<PenilaianResponse> update = penilaianServices.update(penilaianRequest);
        return update;
    }

    @DeleteMapping("/deleteWithReqParam")
    public ResponseEntity<String> deleteWithReqParam(@RequestParam("id") Long id) {
        return penilaianServices.delete(id);
    }

    @DeleteMapping("/deletePathVar/{id}")
    public ResponseEntity<String> deletePathVar(@PathVariable("id") Long id) {
        return penilaianServices.delete(id);
    }

    @GetMapping("/selectAll")
    public ResponseEntity<List<PenilaianResponse>> selectAll(){
        return penilaianServices.selectAll();
    }

    @GetMapping("/selectWithReqParam")
    public ResponseEntity<PenilaianResponse> selectWithReqParam(@RequestParam("id") Long id) {
        return penilaianServices.selectById(id);
    }

    @GetMapping("/selectPathVar/{id}")
    public ResponseEntity<PenilaianResponse> selectPathVar(@PathVariable("id") Long id) {
        return penilaianServices.selectById(id);
    }
}
