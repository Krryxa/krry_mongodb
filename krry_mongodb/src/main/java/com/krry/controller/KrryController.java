package com.krry.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.krry.dao.IUserDao;
import com.krry.entity.User;
import com.krry.util.TmStringUtils;

/**
 * Controller层，作为请求转发
 * 页面所有路径的访问方法:控制层的命名空间+@RequestMapping的value
 * */
@Controller
@RequestMapping("/index")
public class KrryController {

	@Autowired
	private IUserDao userDao;
	
	/**
	 * 进入首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){

		return "index/index";   //默认是转发，不会显示转发路径
	}
	
	/**
	 * 进入登录界面
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){

		return "index/login";   //默认是转发，不会显示转发路径
	}
	
	
	
	/**
	 * 点击登录
	 * com.krry.controller.login 
	 * 方法名：login
	 * @author krry 
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method=RequestMethod.POST,value="/logined")
	public String login(HttpServletRequest request){
		//获取用户和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//如果邮箱和密码为null,那么就返回已null标识
		if(TmStringUtils.isEmpty(username)) return "index/allError";
		if(TmStringUtils.isEmpty(password)) return "index/allError";
		
		//根据邮箱或昵称查询，用户是否存在
		User user = userDao.findByUsername(username);
		
		//如果存在
		if(user!=null){
			
			if(password.equals(user.getPassword())){
				//如果密码正确
				//将用户信息放入到会话中...
				request.getSession().setAttribute("user", user);
				
				//这里使用重定向 ,重定向到当前命名空间下@RequestMapping是index的方法
				return "redirect:index";
			}else{
				//如果密码错误
				System.out.println("密码错误");
				return "index/error";
			}
		}else{
			//如果不存在，代码邮箱和密码输入有误
			System.out.println("用户不存在");
			return "index/error";
		}
	}
	
	/**
	 * 退出登录控制层
	 * com.krry.controller.login 
	 * 方法名：logout
	 * @author krry 
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method=RequestMethod.GET,value="/logout")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate(); //清空session值
		return "index/index";
	}
	
	/**
	 * 打开注册界面层
	 * @return
	 */
	@RequestMapping("/rege")
	public String rege(){

		return "index/resgi";
	}
	
	/**
	 * 注册控制层
	 * com.krry.controller.login 
	 * 方法名：resig
	 * @author krry 
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method=RequestMethod.POST,value="/resig")
	public String resig(HttpServletRequest request){
		//获取用户和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//如果邮箱和密码为null,那么就返回已null标识
		if(TmStringUtils.isEmpty(username) )return "index/allError";
		if(TmStringUtils.isEmail(password))return "index/allError";
		
		//根据昵称查询，用户是否存在
		User user = userDao.findByUsername(username);
		
		//若存在
		if(user != null){ //昵称重复
			return "index/allError";
		}

		//格式化时间类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = sdf.format(new Date());
		
		//执行到这里，说明可以注册
		User newUser = new User(username, password, nowTime);
		//调用注册方法
		userDao.saveOrUpdateUser(newUser);
		
		//将信息设置session作用域
		request.getSession().setAttribute("user", newUser);

		return "redirect:index";
	}
	
}



