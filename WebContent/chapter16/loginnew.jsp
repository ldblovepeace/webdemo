<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    * {
      margin: 0;
      padding: 0;
    }
    body {
      text-align: center;
      font-family: "Microsoft YaHei", sans-serif;
    }
    .main {
      display: inline-block;
      width: 300px;
      color: #555;
    }
    .main .logo {
      margin: 0 auto;
      width: 160px;
      height: 74px;
      background: url(http://cdn.attach.w3cfuns.com/notes/pics/201606/11/143905zj6ld3zm2yryw9jf.png) no-repeat;
    }
    .main .title {
      margin: 30px 0 20px;
      font-weight: normal;
      font-size: 18px;
      line-height: 1;
    }
    .main .nav-tab {
      margin-bottom: 10px;
      font-size: 18px;
    }
    .main .nav-tab .nav-slider {
      display: inline-block;
      position: relative;
    }
    .main .nav-tab .nav-slider a.active {
      opacity: 1;
      color: #0f88eb;
    }
    .main .nav-tab .nav-slider a {
      display: inline-block;
      width: 4em;
      line-height: 35px;
      transition: .15s;
      text-decoration: none;
      opacity: .7;
      color: #555;
    }
    .main .nav-tab .nav-slider a:hover {
      opacity: 1;
    }
    .nav-slider-bar {
      position: absolute;
      width: 2.4em;
      height: 2px;
      background-color: #0f88eb;
      margin: 0 .8em;
      transition: .15s ease-in;
      left: 0;
      bottom: 0;
    }
    .signup, .signin {
      font-size: 14px;
      text-align: left;
    }
    .group-inputs {
      padding: 1px 0;
      border: 1px solid #d5d5d5;
      border-radius: 3px;
    }
    .group-inputs input {
      font-family: inherit;
      border: 0;
      border-top: 1px solid #e8e8e8;
      width: 100%;
      height: 48px;
      box-sizing: border-box;
      padding: 14px 11.2px;
      outline: none;
      font-size: 14px;
    }
    .group-inputs input:first-child {
      border-top: none;
      height: 47px;
    }
    .signup button, .signin button {
      margin-top: 18px;
      background-color: #0f88eb;
      border: none;
      border-radius: 3px;
      line-height: 41px;
      color: #fff;
      width: 100%;
      font-size: 15px;
      font-family: inherit;
      cursor: pointer;
    }
    button:hover {
      opacity: .6;
    }
    .signin-other {
      margin-top: 18px;
    }
    .unable-login {
      float: right;
      color: inherit;
      text-decoration: none;
    }
  </style>
</head>


<body>
  <div class="main">
    <div class="header">
      <h1 class="logo"></h1>
      <h2 class="title">XXXXXXXXXXXXX</h2>
    </div>
    <div class="body">
      <div class="nav-tab">
        <div class="nav-slider">
          <a href="#signup" class="active">注册</a><!--
          --><a href="#signin">登录</a>
          <span class="nav-slider-bar"></span>
        </div>
      </div>
      <div class="signup">
        <form action="login"  namespace="/chapter16">
          <div class="group-inputs">
            <input class="username" type="text" placeholder="用户名">
            <input type="password" placeholder="密码">
           <!--  <input type="repassword" placeholder="请重新输入密码"> -->
            <input type="email" placeholder="邮箱（仅支持公司邮箱）">
           <!-- <input type="validationCode" placeholder="验证码">
             <img id="img_validation_code" src="validation_code.action" onClick="this.src = 'validation_code.action?' + Math.random()"/> -->
          </div>
          <button type="button">注册</button>
        </form>
      </div>
      <div class="signin" style="display: none;">
        <form action="register" namespace="/chapter16">
          <div class="group-inputs">
            <input type="text" placeholder="手机号或邮箱">
            <input type="password" placeholder="密码">
          </div>
          <button type="button">登录</button>
          <div class="signin-other">
            <input type="checkbox" id="remember-me">
            <label for="remember-me">记住我</label>
            <a class="unable-login" href="#">无法登录?</a>
          </div>
        </form>
      </div>
    </div>
  </div>

  <script>
    var navSlider = document.getElementsByClassName("nav-slider")[0];
    var navSliderA = navSlider.getElementsByTagName("a");
    var navSliderBar = navSlider.getElementsByClassName("nav-slider-bar")[0];
    var signup = document.getElementsByClassName("signup")[0];
    var signin = document.getElementsByClassName("signin")[0];
    
    navSliderA[0].onclick = function () {
      navSliderBar.style.left = "0";
      this.className = "active";
      navSliderA[1].className = "";
      signup.style.display = "block";
      signin.style.display = "none";
    }
    navSliderA[1].onclick = function () {
      navSliderBar.style.left = "4em";
      this.className = "active";
      navSliderA[0].className = "";
      signup.style.display = "none";
      signin.style.display = "block";
    }
  </script>
</body>
</html>