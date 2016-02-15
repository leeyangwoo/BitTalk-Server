import dao.ChatroomDAO;

public class test {
	public static void main(String[] args) {
		ChatroomDAO dao = new ChatroomDAO();
		int result = dao.checkTalk(10, 12);
		System.out.println(result);
	}
}
