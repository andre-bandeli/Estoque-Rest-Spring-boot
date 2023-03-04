package com.br.Maintenance.maintenance.controller.ordens;

import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.service.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/os")
public class OrdemServicoController {

    @Autowired
    private OrdemService ordemService;

    @GetMapping
    public String homeOrdem(Model model) {

        Ordem ordem = new Ordem();
        List<Ordem> list = ordemService.ListOrdem();
        model.addAttribute("ordem", list);

        return "template/pages/solicitacao/ordem";
    }

    @GetMapping("/add")
    public String addOrdem(Model model) {

        Ordem ordem = new Ordem();
        model.addAttribute("ordem", ordem);

        return "template/pages/solicitacao/ordemAddForm";
    }

    @PostMapping("/saveOrdem")
    public String saveOrdem(@ModelAttribute Ordem ordem, Model model) {

        ordemService.salvarOrdem(ordem);
        model.addAttribute("ordem", ordem);

        return "redirect:/api/ordem";
    }

    @GetMapping("/view/{id}")
    public String getOrdemById(@PathVariable("id") Long id, Model model) {

        Ordem ordem = ordemService.ListOrdemPorId(id);
        model.addAttribute("ordem", ordem);

        return "template/pages/solicitacao/ordemDescricao";
    }

//    @PutMapping("/update/{id}")
//    public String updateOrdem(@PathVariable("id") Long id, Model model) {
//
//        Ordem ordem = new Ordem();
//        ordemService.updateOrdem(id);
//
//        model.addAttribute("ordem", ordem);
//        return  "template/pages/solicitacao/ordemUpdateForm";
//    }

    @GetMapping("/remove/{id}")
    public String  removeOrdem(@PathVariable Long id) {
        ordemService.deleteOrdemById(id);
        return "redirect:/solicitacao";
    }


}
