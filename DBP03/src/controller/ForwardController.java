package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller {
    private String forwardUrl;

    public ForwardController(String forwardUrl) {
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. �̵��� URL�� �Է��ϼ���.");
        }
        this.forwardUrl = forwardUrl;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return forwardUrl;
    }

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
}
