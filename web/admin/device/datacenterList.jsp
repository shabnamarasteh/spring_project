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
    <title>دیتاسنترها</title>
</head>
<body class="nav-md">

<jsp:include page="../section/nav.jsp"/>

<div class="right_col" role="main">
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_content">
                <a href="/admin/datacenter/create.do"
                   class="btn btn-round btn-primary">دیتاسنتر جدید</a>

                <div class="table-responsive">
                    <table class="table table-striped jambo_table bulk_action">
                        <thead>
                        <tr class="headings">
                            <th class="column-title category-title">نام دیتاسنتر</th>
                            <th class="column-title category-title">آدرس</th>
                            <th class="column-title category-title">مختصات</th>
                            <th class="column-title category-title">شهر</th>
                            <th class="column-title"></th>
                            <th class="column-title"></th>
                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach items="${datacenters}" var="datacenter">
                        <tr>
                            <td>${datacenter.name}</td>
                            <td>${datacenter.address}</td>
                            <td>${datacenter.location}</td>
                            <td>${datacenter.cityId.name}</td>
                            <td><a class="btn btn-info" href="/admin/datacenter/edit.do/${datacenter.id}">ویرایش</a></td>
                            <td>
                                <form:form method="DELETE" action="/admin/datacenter/delete.do">
                                    <input type="hidden" name="id" value="${datacenter.id}">
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