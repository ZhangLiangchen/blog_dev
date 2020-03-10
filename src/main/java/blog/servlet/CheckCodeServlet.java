package blog.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Random random=new Random();
    private Color getRandomColor(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r,g,b);
    }
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //内存图片对象(TYPE_INT_BGR 选择图片模式RGB模式)
        BufferedImage image = new BufferedImage(70,30,BufferedImage.TYPE_INT_RGB);
        //得到画笔
        Graphics graphics = image.getGraphics();
        //画之前要设置颜色，设置画笔颜色
        graphics.setColor(new Color(255, 255, 255, 255));
        //填充矩形区域（指定要画的区域设置区）
        graphics.fillRect(0,0,70,30);
        //在验证码图片上加干扰线：给两个点连一条线drawLine();
         for (int i=0;i<4;i++){
             //颜色也要随机（设置每条线随机颜色
             graphics.setColor(getRandomColor());
             int x1=random.nextInt(90);
             int y1=random.nextInt(30);
             int x2=random.nextInt(90);
             int y2=random.nextInt(30);
             graphics.drawLine(x1,y1,x2,y2);
         }
         //拼接4个验证码，画到图片上
         char [] arrays={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q', 'R','S','T','U','V','W','X','Y','Z'};
         StringBuilder builder = new StringBuilder();
         for(int i=0;i<4;i++){
             //设置字符的颜色
             int index=random.nextInt(arrays.length);
             builder.append(arrays[index]);
         }
         //将生成的验证码字符串保存在session
         request.getSession().setAttribute("trueCode",builder.toString());
         //4个字符画到图片上graphics.drawString(str ,x,y);一个字符一个字符画
         for (int i=0;i<builder.toString().length();i++){
             graphics.setColor(getRandomColor());
             char item=builder.toString().charAt(i);
             graphics.drawString(item+"",10+(i*15),20);
         }
         //输出内存图片到输出流
         ImageIO.write(image,"png",response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
