package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.BoardDTO;
import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;

public interface BoardService {

	int register(BoardDTO boardDTO);

	List<BoardVO> getList(PagingVO pgvo);

	BoardDTO getDetail(long bno);

	int update(BoardDTO boardDTO);

	int delete(long bno);

	int getTotal(PagingVO pgvo);

}
