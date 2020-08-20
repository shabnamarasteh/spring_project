<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>

    <jsp:include page="../section/header.jsp"/>
    <title>صفحه اصلی</title>
</head>
<body class="nav-md">

<jsp:include page="../section/nav.jsp"/>

<div class="right_col" role="main">
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_content">
                <div class="table-responsive">
                    <a href="/admin/admin/create.do" class="btn btn-primary">ایجاد</a>
                    <table class="table table-striped jambo_table bulk_action">
                        <thead>
                        <tr class="headings">
                            <th class="column-title">شناسه</th>
                            <th class="column-title">نام</th>
                            <th class="column-title">نام خانوادگی</th>
                            <th class="column-title">پست الکترونیک</th>
<%--                            <th class="column-title">نام نقش</th>--%>
                            <th class="column-title"></th>
                            <th class="column-title"></th>

                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach items="${items}" var="item">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.firstName}</td>
                                <td>${item.lastName}</td>
                                <td>${item.email}</td>
<%--                                <td>${item.roleId.name}</td>--%>
                                <td>
                                    <a href="/admin/${item.id}/edit.do" class="btn btn-success">ویرایش</a>
                                </td>
                                <td>
                                    <form:form method="delete" action="/admin/delete.do">
                                        <input type="hidden" name="adminId" value="${item.id}">
                                        <input type="submit" value="حذف" class="btn btn-danger">
                                    </form:form>
                                </td>

                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../section/footer.jsp"/>
</body>
</html>