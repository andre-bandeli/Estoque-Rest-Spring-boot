package com.br.Maintenance.maintenance.controller.maquina;

import com.br.Maintenance.maintenance.model.Maquina;
import com.br.Maintenance.maintenance.service.MaquinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/maquinas")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MaquinaController {

    @Autowired
    private MaquinaService maquinaService;


    @PostMapping("/add")
    public Maquina saveMaquina(@RequestBody Maquina maquina) {
        return maquinaService.addMaquina(maquina);
    }
    @GetMapping("/list")
    public List<Maquina> getListMaquina() {
        return maquinaService.maquinasList();
    }

    @GetMapping("/getmaquina/{id}")
    public Optional<Maquina> getMaquina(Long id) {
        return Optional.ofNullable(maquinaService.getMaquinaById(id));
    }


    @DeleteMapping("/delete/{id}")
    public void deleteMaquina(@PathVariable Long id) {
        maquinaService.deleteMaquinaById(id);
    }
}
