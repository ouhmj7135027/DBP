package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// request�� ó���� �� �̵��� URL�� ��ȯ
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    		throws Exception;

	void onlyGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException;
    
}
