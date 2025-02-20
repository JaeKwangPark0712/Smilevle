package com.smilevle.review.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smilevle.review.comment.model.CommentVO;
import com.smilevle.review.comment.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public List<CommentVO> getCommentList(Integer reviewNo) {
		return commentRepository.getCommentList(reviewNo);
	}
	
	public void writeComment(CommentVO commentVO) {
		commentRepository.writeComment(commentVO);
	}
	
	public int getCommentNo() {
		return commentRepository.getCommentNo();
	}
	
	public void deleteComment(Integer commentNo) {
		commentRepository.deleteComment(commentNo);
	}
}
