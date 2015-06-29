package br.com.caelum.tarefas.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController 
{
	private final JdbcTarefaDao dao;
	
	@Autowired
	public TarefasController(JdbcTarefaDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) throws IOException 
	{
		dao.finaliza(id);
	
		//Date dataDeFinalizacao = dao.buscaPorId(id).getDataFinalizacao().getTime();
		//String data = new SimpleDateFormat("dd/MM/yyyy").format(dataDeFinalizacao);
		//response.getWriter().write(data);
		//response.setStatus(200);
	
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/finalizada";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) 
	{
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) 
	{
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) 
	{
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model)
	{
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}

	@RequestMapping("novaTarefa")
	public String form() {
		System.out.println("form tarefa");
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) 
	{
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}

}
