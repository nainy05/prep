<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<FORM action="" method="post">
Course Name: <INPUT type="text" name="title" size="35"><BR>
Course Time: 
Sun<INPUT type="checkbox" name="day" value="sun"> 
Mon<INPUT type="checkbox" name="day" value="mon"> 
Tue<INPUT type="checkbox" name="day" value="tue"> 
Wed<INPUT type="checkbox" name="day" value="wed"> 
Thu<INPUT type="checkbox" name="day" value="thu"> 
Fri<INPUT type="checkbox" name="day" value="fri"> 
Sat<INPUT type="checkbox" name="day" value="sat"> 
<SELECT name="starttime">
<OPTION value="8">8:00am</OPTION>
<OPTION value="9">9:00am</OPTION>
<OPTION value="10">10:00am</OPTION>
<OPTION value="11">11:00am</OPTION>
<OPTION value="12">12:00pm</OPTION>
<OPTION value="13">1:00pm</OPTION>
<OPTION value="14">2:00pm</OPTION>
<OPTION value="15">3:00pm</OPTION>
<OPTION value="16">4:00pm</OPTION>
<OPTION value="17">5:00pm</OPTION>
<OPTION value="18">6:00pm</OPTION>
<OPTION value="19">7:00pm</OPTION>
<OPTION value="20">8:00pm</OPTION>
<OPTION value="21">9:00pm</OPTION>
</SELECT> 
to 
<SELECT name="endtime">
<OPTION value="9">9:00am</OPTION>
<OPTION value="10">10:00am</OPTION>
<OPTION value="11">11:00am</OPTION>
<OPTION value="12">12:00pm</OPTION>
<OPTION value="13">1:00pm</OPTION>
<OPTION value="14">2:00pm</OPTION>
<OPTION value="15">3:00pm</OPTION>
<OPTION value="16">4:00pm</OPTION>
<OPTION value="17">5:00pm</OPTION>
<OPTION value="18">6:00pm</OPTION>
<OPTION value="19">7:00pm</OPTION>
<OPTION value="20">8:00pm</OPTION>
<OPTION value="21">9:00pm</OPTION>
<OPTION value="22">10:00pm</OPTION>
</SELECT>
<BR>
<BR>
<INPUT type="submit" name="Submit" value="Add Course">
</FORM>

<c:forEach begin="8" end="21" step="1" var="time">
<TR>
<TD align="center" valign="middle" width="80">
<c:choose>
<c:when test="${time == 12}">
<c:out value="${time}" />:00pm
</c:when>
<c:when test="${time > 12}">
<c:out value="${time - 12}" />:00pm
</c:when>
<c:otherwise>
<c:out value="${time}" />:00am
</c:otherwise>
</c:choose></TD>
<c:forEach begin="0" end="6" step="1" var="day">
<TD align="center" valign="middle" width="100">
<c:forEach items="${schoolSchedule.classes}" var="clazz">
<c:if test="${clazz.startTime <= time 
&& clazz.endTime > time 
&& clazz.day == day}">
<c:out value="${clazz.title}" />
</c:if>
</c:forEach>
</TD>
</c:forEach>
</TR>
</c:forEach>
</TBODY>
</TABLE>

</body>
</html>