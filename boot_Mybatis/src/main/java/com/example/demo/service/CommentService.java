package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.CommentVO;
import com.example.demo.domain.PagingVO;

public interface CommentService {

	List<CommentVO> getList(long bno, PagingVO pgvo);

	int getTotal(long bno);

	int modify(CommentVO cvo);

	int delete(long cno);

	int post(CommentVO cvo);

}
