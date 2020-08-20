<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
                <div class="" role="tabpanel" data-example-id="togglable-tabs">
                    <ul id="myTab1" class="nav nav-tabs bar_tabs" role="tablist">
                        <li role="presentation" class="active">
                            <a href="#tab_content11" id="home-tabb"  role="tab" data-toggle="tab" aria-controls="home"
                               aria-expanded="true">جدید</a>
                        </li>
                    </ul>
                    <div id="myTabContent2" class="tab-content">
                        <div role="tabpanel" class="tab-pane fade active in" id="tab_content11" aria-labelledby="home-tab">
                             <div class="x_content">
                                <br/>
                                 <form:form method="post" action="/admin/admin/save.do"
                                               modelAttribute="admin">
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" class="form-control has-feedback-left" name="firstName"
                                               id="firstName" placeholder="نام" value="${admin.firstName}">
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" class="form-control" id="lastName" name="lastName"
                                               value="${admin.lastName}" placeholder="نام خانوادگی">
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" class="form-control has-feedback-left"
                                               id="email" name="email" value="${admin.email}" placeholder="ایمیل">
                                        <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="password" class="form-control" id="password" name="password"
                                               value="${admin.password}" placeholder="رمزعبور">
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="password" class="form-control" id="confirmPassword"
                                               value="${admin.password}" name="confirmPassword" placeholder="تکرار رمزعبور">
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                                    </div>
<%--                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">--%>
<%--                                        <div class="checkbox">--%>
<%--                                            <label class=""> نقش ها--%>
<%--                                                <select name="roleId">--%>
<%--                                                    <c:forEach items="${roles}" var="role">--%>
<%--                                                        <option value="${role.id}">${role.name}</option>--%>
<%--                                                    </c:forEach>--%>
<%--                                                </select>--%>
<%--                                            </label>--%>
<%--                                        </div>--%>
                                        <div class="form-group">
                                            <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                                <button type="submit" class="btn btn-primary">انصراف</button>
                                                <button type="submit" class="btn btn-success">ارسال</button>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                             </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../section/footer.jsp"/>
</body>
</html>