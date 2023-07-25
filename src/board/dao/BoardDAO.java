package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;

public class BoardDAO {

	private SqlSession session;

	public BoardDAO() {
		session = new MyConfig().getInstance();
		
	}
	
	public void insert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("VO�� ����");
		board.setWriter("hong");
		
		
		
				
		int cnt = session.insert("board.dao.BoardDAO.insert", board);
		session.commit();
		System.out.println("�� "+cnt+"�� �� ����..");
	
	}
	
	
	public void select() {
//		��ü�Խñ� ��ȸ
//		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectAll");
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectAll2");
		for(BoardVO board : list) {
			System.out.println(board);
		}
		
	}
	
	public void selectOne(){
		int boardNo=21;
		BoardVO result = session.selectOne("board.dao.BoardDAO.selectByNo", boardNo);
		System.out.println(result);
		
		
		BoardVO board = new BoardVO();
		board.setNo(22);
		result = session.selectOne("board.dao.BoardDAO.selectByNo2", board);
		System.out.println(result);
		
	}
	
	public void selectWhere() {
	
		/*
		// 1. ����, �۾��̷� �˻�
		BoardVO board = new BoardVO();
		board.setTitle("�����Ӥ�");
		board.setWriter("ȫ�浿");
		*/
		
		/*
		//2. �۾��̰� ȫ�� �Խñ� ��ȸ
		BoardVO board = new BoardVO();
		board.setWriter("hong");
		
		*/
		
		//3. ������  �˻�
//		board.setTitle("�����Ӥ�");
//		BoardVO board = new BoardVO();
		

		//4. ��ü�˻�
		BoardVO board = new BoardVO();
		
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectWhere", board);
		for(BoardVO b: list) {
			System.out.println(b);
		}
	}
	
	
	public void selectWhere2() {
		//������ �����Ӥ� �۾��̰� ȫ�浿�� �� �˻�
		Map<String, String> board= new HashMap<>();
		board.put("title", "�����Ӥ�");
		board.put("writer", "ȫ�浿");
		//put ���� key�� ���� title, writer �� �־���
		
		
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectWhere2", board);
		for(BoardVO b: list) {
			System.out.println(b);
		}
	}
	
	
	public void selectWhere3() {
		//������ �����Ӥ� �۾��̰� ȫ�浿�� �� �˻�
		Map<String, String> board= new HashMap<>();
		board.put("no", "2");
		//put ���� key�� ���� title, writer �� �־���
		Map<String, Object> result = session.selectOne("board.dao.BoardDAO.selectWhere3",board);
		
		Set<String> keys = result.keySet();
		for(String key : keys) {
			System.out.println("key:"+key + ", value: "+result.get(key));
		}
		}
	
	public void selectNos() {
		int[] nos= {1,2,4,11,21,22,23};
		
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectNos",nos);
		for(BoardVO b:list) {
			System.out.println(b);
		}
		
	}
	
	
	
	public void work() {
		selectNos();
//		selectWhere3();
//		selectWhere2();
//		selectWhere();
//		selectOne();
//		insert();
//		select();
		
	}
	
}
