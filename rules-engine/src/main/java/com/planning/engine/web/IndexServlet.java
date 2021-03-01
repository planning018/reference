package com.planning.engine.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.planning.engine.web.SuspiciousRequestRule.SUSPICIOUS;

/**
 * @author yxc
 * @date 2021/3/1 16:58
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        if(isSuspicious(req)){
            out.print("Access denied\n");
        }else {
            out.print("Welcome!\n");
        }

    }

    private boolean isSuspicious(HttpServletRequest request){
        return request.getAttribute(SUSPICIOUS) != null;
    }
}
