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
 * ������֤��
 * @author God_86
 *
 */
@WebServlet("/verification-code-servlet")
public class VerificationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//����������֤��Ļ������
	int w = 80;
	//������֤��ĳ���
	int fontNum = 4;
	
	//��֤�������С
	int fontSize = (w - 10) / fontNum;
	
    //���������С���û����ĸ߶�
	int h = (int) (fontSize * 1.5);
	
	//��ʼ���ַ�Դ
	String charSource = "abcdefghijklmnopqrstuvwxyxABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	/**
	 * ���������֤��
	 * @param num ������֤��ĳ���
	 * @return ��֤��
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
	 * �������һ��ֱ��
	 * @return ��������(x1,y1)(x2,y2)
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
		//��ʼ������
		BufferedImage canvas = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
		//��ʼ�����ʶ���
		Graphics pen = canvas.getGraphics();
		
		//���û�����ɫ
		pen.setColor(Color.WHITE);
		
		//��һ��������
		pen.fillRect(0, 0, w, h);
		
		//���û�����ɫ
		pen.setColor(Color.black);
		
		//�����߿�
		pen.drawRect(0, 0, w-1, h-1);
		
		//���û���������ʽ
		pen.setFont(new Font("΢���ź�", Font.BOLD, fontSize));
		
		
		//������֤���ַ���
		String verCode = randString(fontNum);
		
		//�����ɵ���֤�����Ự
		request.getSession().setAttribute("verCode", verCode);
		
		//���������֤��
		for(int i = 0;i<verCode.length();i++) {
			pen.setColor(randColor());
			pen.drawString(String.valueOf(verCode.charAt(i)), 10 + i * 15, (h + fontSize) /2);
		}
		
		//����һ�����ֱ��
		int[] line = randLine();  
		for(int i = 0;i<line.length;i++) {
			System.out.println(line[i]);
		}
		
		
		//���û���������ʽ
		pen.setColor(Color.BLACK);
		
		//�������ֱ��
		pen.drawLine(line[0],line[1],line[2],line[3]);
		
		//��ȡ���������
		ServletOutputStream out = response.getOutputStream();
		
		//�ѻ��õ���֤��д�������
		ImageIO.write(canvas, "png", out);
		
		//�ͷ������
		out.flush();
		out.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
