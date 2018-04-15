<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<p class='main-menu'>
<p>User : ${loggedInUser.name} </p>

<a href="${pageContext.request.contextPath}/user/login">Login</a>

<a href="${pageContext.request.contextPath}/user/register">Register</a>

</p>