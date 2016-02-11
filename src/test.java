import dao.MemberDAO;
import dto.MemberDTO;

public class test {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO();
		
		member.setMno(1);
		member.setMid("dd");
		member.setMpasswd("1112");
		member.setMname("fff");

		int count = dao.setMember(member);
		System.out.println(count);
	}
}
