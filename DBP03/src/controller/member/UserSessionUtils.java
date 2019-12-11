package controller.member;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
	public static final String USER_SESSION_KEY = "userId";
	public static final String USER_M_ID = "m_id";

    /* ���� �α����� ������� ID�� ���� */
    public static String getLoginUserId(HttpSession session) {
        String userId = (String)session.getAttribute(USER_SESSION_KEY);
        return userId;
    }
    
    public static String getLoginM_Id(HttpSession session) {
        String m_id = (String)session.getAttribute(USER_M_ID);
        return m_id;
    }

    /* �α����� ���������� �˻� */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginUserId(session) != null) {
            return true;
        }
        return false;
    }

    /* ���� �α����� ������� ID�� userId���� �˻� */
    public static boolean isLoginUser(String userId, HttpSession session) {
        String loginUser = getLoginUserId(session);
        if (loginUser == null) {
            return false;
        }
        return loginUser.equals(userId);
    }

}
