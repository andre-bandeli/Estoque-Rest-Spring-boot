package com.br.Maintenance.maintenance.controller.ordens;

import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.service.OrdemService;
import com.br.Maintenance.maintenance.model.Solicitacao;
import com.br.Maintenance.maintenance.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/solicitacao")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @Autowired
    private OrdemService ordemService;

    @GetMapping
    public String solicitacoesHome(Model model) {

        Solicitacao solicitacao = new Solicitacao();
        List<Solicitacao> list = solicitacaoService.ListSolicitacao();
        model.addAttribute("solicitacao", list);

        int tamanho = list.size();
        model.addAttribute("tamanho", tamanho);

        Ordem ordem = new Ordem();
        List<Ordem> listOrdem = ordemService.ListOrdem();
        model.addAttribute("ordem", listOrdem);

        int tamanhoOrdem = listOrdem.size();
        model.addAttribute("tamanhoOrdem", tamanhoOrdem);

        return "template/pages/solicitacao/solicitacao";
    }

    @GetMapping("/list")
    public String solicitacoesList(Model model) {

        Solicitacao solicitacao = new Solicitacao();
        List<Solicitacao> list = solicitacaoService.ListSolicitacao();
        model.addAttribute("solicitacao", list);

        return "template/pages/solicitacao/solicitacaoList";
    }

    @GetMapping("/addSolicitacao")
    public String addSolicitacao(Model model) {
        // create model attribute to bind form data
        Solicitacao solicitacao = new Solicitacao();
        model.addAttribute("solicitacao", solicitacao);

        return "template/pages/solicitacao/solicitacaoAddForm";
    }
    @PostMapping("/saveSolicitacao")
    public String saveSolicitacao(@ModelAttribute Solicitacao solicitacao, Model model) {
        solicitacaoService.salvarSolicitacao(solicitacao);
        model.addAttribute("solicitacao", solicitacao);
        return "redirect:/api/solicitacao";
    }

    @GetMapping("/view/{id}")
    public String getSolicitacaoById(@PathVariable("id") Long id, Model model) {

        Solicitacao solicitacao = solicitacaoService.ListSolicitacaoPorId(id);
        model.addAttribute("solicitacao", solicitacao);
        return "template/pages/solicitacao/solicitacaoDescricao";
    }

//    @PutMapping("/update/{id}")
//    public String Put(@PathVariable(value = "id") long id, Model model) {
//
//        Solicitacao solicitacao = new Solicitacao();
//        solicitacaoService.updateSolicitacao(id);
//
//        model.addAttribute("solicitacao", solicitacao);
//        return  "template/pages/solicitacao/solicitacaoUpdateForm";
//
//    }

    @GetMapping("/remove/{id}")
    public String  removeSolicitacao(@PathVariable Long id) {

        solicitacaoService.deleteSolicitacaoById(id);
        return "/template/index";
    }


//    @PostMapping("/addList")
//    public List<Solicitacao> addListSolicitacoes(List<Solicitacao> solicitacaoServicos) {
//        return solicitacaoService.salvarSolicitacoes(solicitacaoServicos);
//    }



}
