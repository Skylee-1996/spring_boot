package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.CommentVO;
import com.example.demo.domain.PagingVO;

@Mapper
public interface CommentMapper {

	List<CommentVO> selectList(@Param("bno")long bno, @Param("pgvo")PagingVO pgvo);

	int countTotal(long bno);

	int updateCvo(CommentVO cvo);

	int delete(long cno);

	int insert(CommentVO cvo);

}
