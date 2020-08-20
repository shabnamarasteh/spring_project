<%--
  Created by IntelliJ IDEA.
  User: hedi
  Date: 8/20/2020
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <jsp:include page="../section/header.jsp"/>
    <title>تنطیمات</title>
</head>
<body class="nav-md">

<jsp:include page="../section/nav.jsp"/>

<div class="right_col" role="main">
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_content">
                <a href="/admin/config/create.do"
                   class="btn btn-round btn-primary"> جدید</a>

                <div class="table-responsive">
                    <table class="table table-striped jambo_table bulk_action">
                        <thead>
                        <tr class="headings">
                            <th class="column-title category-title">شناسه </th>
                            <th class="column-title category-title">نام تنظیمات </th>
                            <th class="column-title category-title"> مقدار تنطیمات</th>
                            <th class="column-title"></th>
                            <th class="column-title"></th>
                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach items="${items}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.value}</td>
                            <td><a class="btn btn-info" href="/admin/config/${item.id}/edit.do">ویرایش</a></td>
                            <td>
                                <form:form method="DELETE" action="/admin/config/delete.do">
                                    <input type="hidden" name="id" value="${item.id}">
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
    <jsp:include page="../section/singleFooter.jsp"/>

</div>

<jsp:include page="../section/footer.jsp"/>
</body>
</html>