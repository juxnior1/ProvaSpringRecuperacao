package br.edu.ifal.prova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListaComprasControlador {
    @Autowired
    ListaComprasRepositorio repo;

    @RequestMapping("/listacompras")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("listacompras");
        mv.addObject("listacompras", new ListaCompras());
        mv.addObject("listacompras", repo.findAll());
        return mv;
    }

    @RequestMapping("/listacompras/salvar")
    public ModelAndView salvar(ListaCompras listacompras) {
        repo.save(listacompras);
        return new ModelAndView("redirect:/listacompras");
    }

    @RequestMapping("/listacompras/excluir/{id}")
    public ModelAndView excluir(@PathVariable(name = "id") int id) {
        repo.deleteById(id);
        return new ModelAndView("redirect:/listacompras");
    }
}