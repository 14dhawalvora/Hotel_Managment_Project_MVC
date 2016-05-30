<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="false" %>
<html>

<head>

  <meta charset="UTF-8">

  <title>Login Page</title>

    <link rel="stylesheet" href="resources/CSS/log-in.css">


</head>

<body>

  <head>

    <meta charset="utf-8">

    <title>Login</title>

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,700">

    <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
 <![endif]-->

  </head>

  <body>

  	<div class="banner">
        <a href="homePage.html" target="_blank">Login Page</a>
    </div> 


    <div class="container">

      <div id="login">

        <form:form method="POST" action="BrowseHotelSearch" commandName="user">

          <fieldset class="clearfix">

            <p><span class="fontawesome-user"></span>
            <form:input path="username" type="text" value="Username" />

            <form:errors path="username" cssStyle="color:#ff0000"/></p> 
            <!-- JS because of IE support; better: placeholder="Username" -->

            <p><span class="fontawesome-lock"></span>
            <form:input path="password" type="password" value="Password" />

            <form:errors path="password" cssStyle="color:#ff0000"/></p> 
            <!-- JS because of IE support; better: placeholder="Password" -->
            <p><input type="submit" value="Sign In"></p>

          </fieldset>

        </form:form>

        <p>Not a member? <a href="RegisterUserPage">Sign up now</a><span class="fontawesome-arrow-right"></span></p>

      </div> <!-- end login -->

    </div>

  </body>
</html>

