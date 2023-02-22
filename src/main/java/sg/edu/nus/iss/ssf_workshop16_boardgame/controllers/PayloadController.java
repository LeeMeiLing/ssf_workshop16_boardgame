package sg.edu.nus.iss.ssf_workshop16_boardgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.ssf_workshop16_boardgame.models.Payload;
import sg.edu.nus.iss.ssf_workshop16_boardgame.repositories.PayloadRepo;

@RestController
@RequestMapping(path = "/api/payloads")
public class PayloadController {
 
    @Autowired
    private PayloadRepo payloadRepo;

    @PostMapping
    public ResponseEntity<Payload> save(@RequestBody Payload payload){

        Payload pLoad = payloadRepo.save(payload);

        return new ResponseEntity<Payload>(pLoad , HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Payload>> findAll(){

        List<Payload> payloads = payloadRepo.findAll();
        return new ResponseEntity<List<Payload>>(payloads , HttpStatus.OK);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payload> findPayloadById(@PathVariable Integer id){

        Payload pLoad = payloadRepo.findPayloadById(id);

        return new ResponseEntity<Payload>(pLoad, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayloadById(@PathVariable Integer id){

        String result = payloadRepo.deletePayloadById(id);

        return new ResponseEntity<String>(result , HttpStatus.OK);
    }

}
