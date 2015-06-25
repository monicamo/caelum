package br.com.caelum.tarefas.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController 
{
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id, HttpServletResponse response) throws IOException {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.finaliza(id);
		Date dataDeFinalizacao = dao.buscaPorId(id).getDataFinalizacao().getTime();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataDeFinalizacao);
		response.getWriter().write(data);
		response.setStatus(200);
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) 
	{
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) 
	{
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model)
	{
		JdbcTarefaDao dao = new JdbcTarefaDao();
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
		
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}

}
