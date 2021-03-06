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
                    <a href="/admin/deviceModel/create.do" class="btn btn-primary">ایجاد</a>
                    <table class="table table-striped jambo_table bulk_action">
                        <thead>
                        <tr class="headings">
                            <th class="column-title">شناسه</th>
                            <th class="column-title">نام</th>
                            <th class="column-title">مدل</th>
                            <th class="column-title">توضیحات</th>
                            <th class="column-title">حداکثر واحد</th>
                            <th class="column-title">کاور</th>
                            <th class="column-title"></th>
                            <th class="column-title"></th>

                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach items="${items}" var="item">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.name}</td>
                                <td>${item.model}</td>
                                <td>${item.description}</td>
                                <td>${item.max_unit} </td>
                                <td>${item.cover} </td>
                                <td>
                                    <a href="/admin/deviceModel/${item.id}/edit.do" class="btn btn-success">ویرایش</a>
                                </td>

                                <td>
                                    <form:form action="/admin/deviceModel/delete.do" method="delete">
                                        <input type="hidden" name="deviceModelId" value="${item.id}">
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
    <jsp:include page="../section/singleFooter.jsp"/>

</div>

<jsp:include page="../section/footer.jsp"/>
</body>
</html>