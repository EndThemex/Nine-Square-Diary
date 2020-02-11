package com.endtheme.ninesquarediary.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.codehaus.jackson.JsonEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.endtheme.ninesquarediary.AppContext;
import com.endtheme.ninesquarediary.model.Diary;
import com.endtheme.ninesquarediary.model.Pagination;
import com.endtheme.ninesquarediary.model.User;
import com.endtheme.ninesquarediary.service.DiaryService;

import jdk.nashorn.internal.runtime.JSONFunctions;

@Controller
@RequestMapping("page/diary")
public class DiaryController extends BaseController {

	@Autowired
	private DiaryService diaryService;

	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
	}

	/**
	 * 返回编写日记页面
	 * 
	 * @return
	 */
	@RequestMapping("/write")
	public ModelAndView indexPage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write");

		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryalldiary", produces="application/json;charset=UTF-8")
	public String queryPublishDiary(@RequestParam(value = "curentPage") Integer curentPage) {
		AppContext appContext = AppContext.getAppContext();
		Pagination pagination = new Pagination();
		User user = (User) appContext.getObject("user");
		try {
			pagination = diaryService.queryDiary(curentPage, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果日记列表为空 则返回空值
		if (pagination == null || pagination.getTotalPage() == 0) {
			return "";
		}
		return JSON.toJSONString(pagination);
		
	}

	/**
	 * 生成图片
	 */
	@ResponseBody
	@RequestMapping("/createimg")
	public String createImg(@RequestParam(value = "contents[]") String[] contents, 
			                @RequestParam(value = "template") String template, 
			                @RequestParam(value = "weather") String weather,
    					    @RequestParam(value = "title") String title) {

		AppContext appContext = AppContext.getAppContext();
		User user = (User) appContext.getObject("user");
		try {
			String path = (String) appContext.getObject("path");// 获得项目真实路径

			// 禁止缓存
			int width = 600; // 图片的宽度
			int height = 600; // 图片的高度
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics(); // 获取Graphics类的对象

			// 获取图片的完整路径
			weather = path + "static\\images\\weather\\" + weather + ".png";// 获取图片的完整路径

			File bgImgFile;
			bgImgFile = new File(path + "static\\images\\diarybg\\bg_0" + template + ".jpg");
			Image bgsrc = ImageIO.read(bgImgFile); // 构造Image对象
			g.drawImage(bgsrc, 0, 0, width, height, null); // 绘制背景图片
			outWord(g, contents, weather, 0, 0);
			// 将生成的日记图片保存到本地
			ImageIO.write(image, "PNG", new File(path + "static\\images\\diary\\test" + user.getUserName() + ".png"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "test" + user.getUserName();

	}
	
	/**
	 * 保存图片
	 */
	@RequestMapping(value = "/savediary", method = RequestMethod.POST)
	public ModelAndView saveImg(@RequestParam(value = "saveTitle") String title) {
		AppContext appContext = AppContext.getAppContext();
		User user = (User) appContext.getObject("user");
		String path = (String) appContext.getObject("path"); // 获取真实路径
		
		ModelAndView modelAndView = new ModelAndView();
		Diary diary = new Diary();
		
		long date = new Date().getTime();// 获取当前时间
		// 将要保存的图片以 phone + 时间戳来保存
		System.out.println("时间：" + date);
		File testfile = new File(path + "static/images/diary/test" + user.getUserName() + ".png");
		String imgUrl = user.getUserName() + date / 100 + ".png";
		// TODO delete syso
		System.out.println(path + "static/images/diary/test" + user.getUserName() + ".png");
		File newFile = new File(path + "static/images/diary/" + imgUrl);
		if (testfile.renameTo(newFile)) {
			diary.setUserId(user.getId());
			diary.setImgUrl(imgUrl);
			diary.setTitle(title);
			diaryService.saveDiary(diary);
			modelAndView.setView(this.getRedirectView("user/myspace"));
		} 
		/*********************************/
		return modelAndView;
	}

	/**
	 * 功能：将九宫格日记的内容写到图片上
	 * 
	 * @param g
	 * @param content
	 * @param offsetX
	 * @param offsetY
	 */
	public void outWord(Graphics2D g, String[] content, String weather, int offsetX, int offsetY) {
		Font mFont = new Font("微软雅黑", Font.PLAIN, 26); // 通过Font构造字体
		g.setFont(mFont); // 设置字体
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(255,255,255)); // 设置颜色为白色
		int contentLen = 0;
		int x = 0; // 文字的横坐标
		int y = 0; // 文字的纵坐标
		g.drawLine(21, 21, 21, 579); // 画外框线
		g.drawLine(21, 21, 579, 21);
		g.drawLine(579, 21, 579, 579);
		g.drawLine(21, 579, 579, 579);
		g.drawLine(207, 21, 207, 579); // 画内框线
		g.drawLine(393, 21, 393, 579);
		g.drawLine(21, 207, 579, 207);
		g.drawLine(21, 393, 579, 393);
		// 画九宫格标题
		mFont = new Font("微软雅黑", Font.PLAIN, 18); // 通过Font构造字体
		g.setFont(mFont); // 设置字体
		g.drawString("开心的事", 28, 45);
		g.drawString("为他人做的事", 215, 45);
		g.drawString("工作/计划/安排", 405, 45);
		g.drawString("比起昨天的进步", 28, 235);
		g.drawString("心情/感情/灵感", 405, 235);
		g.drawString("关注/新闻/八卦", 28, 425);
		g.drawString("健康/体重/饮食", 215, 425);
		g.drawString("梦想/目标", 405, 425);
		
		for (int i = 0; i < content.length; i++) {
			contentLen = content[i].length(); // 获取内容的长度
			x = 40 + (i % 3) * 190 + offsetX;
			y = 120 + (i / 3) * 185 + offsetY;
			if (content[i].equals("weathervalue")) {
				File bgImgFile = new File(weather);
				mFont = new Font("微软雅黑", Font.PLAIN, 16); // 通过Font构造字体
				g.setFont(mFont); // 设置字体
				Date date = new Date();
				String newTime = new SimpleDateFormat("yyyy年M月d日 E").format(date);
				g.drawString(newTime, x - 14, y - 50);
				Image src;
				try {
					src = ImageIO.read(bgImgFile);
					g.drawImage(src, x + 12, y - 30, 80, 80, null); // 绘制天气图片
				} catch (IOException e) {
					e.printStackTrace();
				} // 构造Image对象
				continue;
			}
			if (contentLen < 5) {
				switch (contentLen % 5) {
				case 1:
					mFont = new Font("微软雅黑", Font.PLAIN, 40); // 通过Font构造字体
					g.setFont(mFont); // 设置字体
					g.drawString(content[i], x + 40, y);
					break;
				case 2:
					mFont = new Font("微软雅黑", Font.PLAIN, 36); // 通过Font构造字体
					g.setFont(mFont); // 设置字体
					g.drawString(content[i], x + 25, y);
					break;
				case 3:
					mFont = new Font("微软雅黑", Font.PLAIN, 30); // 通过Font构造字体
					g.setFont(mFont); // 设置字体
					g.drawString(content[i], x + 20, y);
					break;
				case 4:
					mFont = new Font("微软雅黑", Font.PLAIN, 28); // 通过Font构造字体
					g.setFont(mFont); // 设置字体
					g.drawString(content[i], x + 10, y);
				}
			} else {
				mFont = new Font("微软雅黑", Font.PLAIN, 22); // 通过Font构造字体
				g.setFont(mFont); // 设置字体
				if (Math.ceil(contentLen / 5.0) == 1) {
					g.drawString(content[i], x, y);
				} else if (Math.ceil(contentLen / 5.0) == 2) {
					// 分两行写
					g.drawString(content[i].substring(0, 5), x, y - 20);
					g.drawString(content[i].substring(5), x, y + 10);
				} else if (Math.ceil(contentLen / 5.0) == 3) {
					// 分三行写
					g.drawString(content[i].substring(0, 5), x, y - 30);
					g.drawString(content[i].substring(5, 10), x, y);
					g.drawString(content[i].substring(10), x, y + 30);
				}
			}
		}
		g.dispose();
	}
}
