<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: shabnamPC
  Date: 8/10/2020
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <jsp:include page="../section/header.jsp"/>
    <title>رک ها</title>
</head>
<body class="nav-md">

<jsp:include page="../section/nav.jsp"/>

<div class="right_col" role="main">
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_content">
                <a href="/admin/rack/create.do"
                   class="btn btn-round btn-primary">دستگاه جدید</a>

                <div class="table-responsive">
                    <table class="table table-striped jambo_table bulk_action">
                        <thead>
                        <tr class="headings">
                            <th class="column-title category-title">نام رک</th>
                            <th class="column-title category-title">دیتاسنتر</th>
                            <th class="column-title category-title">تعداد یونیت</th>
                            <th class="column-title"></th>
                            <th class="column-title"></th>
                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach items="${racks}" var="rack">
                        <tr>
                            <td>${rack.name}</td>
                            <td>${rack.datacenterId.name}</td>
                            <td>${rack.maxUnit}</td>
                            <td><a class="btn btn-info" href="/admin/rack/edit.do/${rack.id}">ویرایش</a></td>
                            <td>
                                <form:form method="DELETE" action="/admin/rack/delete.do">
                                    <input type="hidden" name="id" value="${rack.id}">
                                    <input type="submit" class="btn btn-danger" name="submit" value="حذف">
                                </form:form>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../section/footer.jsp"/>
</body>
</html>