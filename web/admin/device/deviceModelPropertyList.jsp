<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <a href="/admin/deviceModelProperty/create.do" class="btn btn-primary">ایجاد</a>
                    <table class="table table-striped jambo_table bulk_action">
                        <thead>
                        <tr class="headings">
                            <th class="column-title">شناسه</th>
                            <th class="column-title">نام</th>
                            <th class="column-title">مدل دستگاه</th>
                            <th class="column-title">نوع</th>
                            <th class="column-title">آدرس</th>
                            <th class="column-title">thershold</th>
                            <th class="column-title"></th>
                            <th class="column-title"></th>

                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach items="${items}" var="item">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.name}</td>
                                <td>${item.deviceModel.name}</td>
                                <td>${item.type}</td>
                                <td>${item.url} </td>
                                <td>${item.threshold} </td>

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