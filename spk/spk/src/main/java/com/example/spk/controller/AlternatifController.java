package com.example.spk.controller;

import com.example.spk.payload.request.AlternatifRequest;
import com.example.spk.payload.response.AlternatifResponse;
import com.example.spk.services.AlternatifServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alternatif")
public class AlternatifController {

    @Autowired
    private AlternatifServices alternatifServices;

    @PostMapping("/create")
    public ResponseEntity<AlternatifResponse> create(@RequestBody AlternatifRequest alternatifRequest){
        ResponseEntity<AlternatifResponse> create = alternatifServices.create(alternatifRequest);
        return create;
    }

    @PutMapping("/update")
    public ResponseEntity<AlternatifResponse> update(@RequestBody AlternatifRequest alternatifRequest) {
        ResponseEntity<AlternatifResponse> update = alternatifServices.update(alternatifRequest);
        return update;
    }

    @DeleteMapping("/deleteWithReqParam")
    public ResponseEntity<String> deleteWithReqParam(@RequestParam("id") Long id) {
        return alternatifServices.delete(id);
    }

    @DeleteMapping("/deletePathVar/{id}")
    public ResponseEntity<String> deletePathVar(@PathVariable("id") Long id) {
        return alternatifServices.delete(id);
    }

    @GetMapping("/selectAll")
    public ResponseEntity<List<AlternatifResponse>> selectAll(){
        return alternatifServices.selectAll();
    }

    @GetMapping("/selectWithReqParam")
    public ResponseEntity<AlternatifResponse> selectWithReqParam(@RequestParam("id") Long id) {
        return alternatifServices.selectById(id);
    }

    @GetMapping("/selectPathVar/{id}")
    public ResponseEntity<AlternatifResponse> selectPathVar(@PathVariable("id") Long id) {
        return alternatifServices.selectById(id);
    }
}
