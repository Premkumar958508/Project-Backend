package com.example.UserInput.Controller;

import com.example.UserInput.Entity.Inputs;
import com.example.UserInput.Service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inputs")
public class InputController {

    @Autowired
    private InputService inputService;

    @GetMapping
    public ResponseEntity<List<Inputs>> getAllInputs(){
        return ResponseEntity.ok(inputService.getAllInputs());
    }

    @PostMapping
    public ResponseEntity<Inputs> createInputs(@RequestBody Inputs inputs){
        return ResponseEntity.status(200).body(inputService.createInputs(inputs));
    }

    @GetMapping("getid/{id}")
    public ResponseEntity<Inputs> getInputById(@PathVariable Long id){
        Optional<Inputs> inputOptional=inputService.getInputsById(id);
        return inputOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/setConstructionId/{constructionId}")
    public ResponseEntity<Inputs> setConstructionId(@PathVariable Long id,@PathVariable Long constructionId){
       Inputs inputs= inputService.updateConstructionId(id,constructionId);
        return ResponseEntity.ok().body(inputs);
    }

    @PostMapping("{id}/assignConstructor")
    public ResponseEntity<Inputs> assignConstructor(@PathVariable Long id,@RequestParam String specialization){
        return ResponseEntity.ok(inputService.assignConstructor(id,specialization));
    }

    @GetMapping("/constructor/{constructorId}")
    public ResponseEntity<List<Inputs>> getInputsByConstructorId(@PathVariable Long constructorId) {
        List<Inputs> inputs = inputService.getInputsByConstructorId(constructorId);
        return ResponseEntity.ok(inputs);
    }
}
