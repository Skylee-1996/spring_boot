package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.repository.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	private final BoardMapper mapper;

	@Override
	public int register(BoardVO bvo) {
		return mapper.insert(bvo);
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		return mapper.selectList(pgvo);
	}

	@Override
	public BoardVO getDetail(long bno) {
		return mapper.getDetail(bno);
	}

	@Override
	public int update(BoardVO bvo) {
		return mapper.update(bvo);
	}

	@Override
	public int delete(long bno) {
		return mapper.delete(bno);
	}

	@Override
	public int getTotal(PagingVO pgvo) {
		return mapper.getTotal(pgvo);
	}
}
