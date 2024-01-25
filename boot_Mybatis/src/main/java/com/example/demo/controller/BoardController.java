package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Handler.PagingHandler;
import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RequestMapping("/board/*")
@Slf4j
@Controller
public class BoardController {
	private final BoardService bsv;
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardVO bvo) {
		int isOk = bsv.register(bvo);
		log.info(">>isOk {}", isOk>0 ? "success" : "fail");
		return "index";
		
	}
	@GetMapping("/list")
	public void list(PagingVO pgvo, Model m) {
		//totalCount
		int totalCount = bsv.getTotal(pgvo);
		//pagingHandler 객체 생성
		PagingHandler ph = new PagingHandler(pgvo, totalCount);
		List<BoardVO> list = bsv.getList(pgvo);
		m.addAttribute("list", list);
		//PagingHandler 객체 보내기
		m.addAttribute("ph",ph);
		
	}
	
	@GetMapping({"/detail","/modify"})
	public void detail(@RequestParam("bno") long bno, Model m) {
		BoardVO bvo = bsv.getDetail(bno);
		m.addAttribute("bvo",bvo);
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO bvo, RedirectAttributes re) {
		log.info(">>>modifycheck bvo{}", bvo);
		int isOk = bsv.update(bvo);
		log.info(">>isOk {}", isOk>0 ? "success" : "fail");
		return "redirect:/board/detail?bno="+bvo.getBno();
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("bno") long bno, RedirectAttributes re) {
		int isOk = bsv.delete(bno);
		re.addFlashAttribute("isDel", isOk);
		return "redirect:/board/list"; 
	}
	
}
