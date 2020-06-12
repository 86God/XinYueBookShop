package com.company.project.servlet.verCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.prism.Image;

/**
 * 生成验证码
 * @author God_86
 *
 */
@WebServlet("/verification-code-servlet")
public class VerificationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//设置生成验证码的画布宽度
	int w = 80;
	//生成验证码的长度
	int fontNum = 4;
	
	//验证码字体大小
	int fontSize = (w - 10) / fontNum;
	
    //根据字体大小设置画布的高度
	int h = (int) (fontSize * 1.5);
	
	//初始化字符源
	String charSource = "abcdefghijklmnopqrstuvwxyxABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	/**
	 * 随机生成验证码
	 * @param num 生成验证码的长度
	 * @return 验证码
	 */
	public String randString(int num) {
		String verCode = "";
		for(int i = 0;i<num;i++) {
			verCode += charSource.charAt((int)(Math.random()*charSource.length()));
		}
		System.out.println("verCode:"+verCode);
		return verCode;
	}
	
	public Color randColor() {
		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);
		
		Color color = new Color(r, g, b);
		
		System.out.println("color:"+color);
		return color;
	}
	
	/**
	 * 随机生成一条直线
	 * @return 两点坐标(x1,y1)(x2,y2)
	 */
	public int[] randLine() {
		int x1,x2,y1,y2;
		x1 = (int)(Math.random()*w);
		x2 = (int)(Math.random()*w);
		y1 = (int)(Math.random()*h);
		y2 = (int)(Math.random()*h);
		int[] result = {x1,y1,x2,y2};
		return result;
	}
	
	
	
    public VerificationCodeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//初始化画布
		BufferedImage canvas = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
		//初始化画笔对象
		Graphics pen = canvas.getGraphics();
		
		//设置画笔颜色
		pen.setColor(Color.WHITE);
		
		//画一个填充矩形
		pen.fillRect(0, 0, w, h);
		
		//设置画笔颜色
		pen.setColor(Color.black);
		
		//画出边框
		pen.drawRect(0, 0, w-1, h-1);
		
		//设置画笔字体样式
		pen.setFont(new Font("微软雅黑", Font.BOLD, fontSize));
		
		
		//生成验证码字符串
		String verCode = randString(fontNum);
		
		//将生成的验证码存入会话
		request.getSession().setAttribute("verCode", verCode);
		
		//绘制随机验证码
		for(int i = 0;i<verCode.length();i++) {
			pen.setColor(randColor());
			pen.drawString(String.valueOf(verCode.charAt(i)), 10 + i * 15, (h + fontSize) /2);
		}
		
		//绘制一条随机直线
		int[] line = randLine();  
		for(int i = 0;i<line.length;i++) {
			System.out.println(line[i]);
		}
		
		
		//设置画笔字体样式
		pen.setColor(Color.BLACK);
		
		//画出随机直线
		pen.drawLine(line[0],line[1],line[2],line[3]);
		
		//获取输出流对象
		ServletOutputStream out = response.getOutputStream();
		
		//把画好的验证码写入输出流
		ImageIO.write(canvas, "png", out);
		
		//释放输出流
		out.flush();
		out.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
