<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hedi
  Date: 8/10/2020
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <jsp:include page="../section/header.jsp"/>
    <title>دیتاسنتر</title>
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
                            <a href="#tab_content11" id="home-tabb"  role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">ایجاد دیتاسنتر جدید</a>
                        </li>
                    </ul>
                    <div id="myTabContent2" class="tab-content">
                        <div role="tabpanel" class="tab-pane fade active in" id="tab_content11" aria-labelledby="home-tab">
                            <div class="x_content">
                                <br/>
                                <form class="form-horizontal form-label-left input_mask"  method="POST"
                                      action="/admin/datacenter/${id}/edit.do" modelAttribute="datacenter">
                                    <input type="hidden" value="PUT" name="_method">
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" class="form-control" id="name" name="name" value="${datacenter.name}" placeholder="نام دیتاسنتر">
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>

                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" class="form-control" id="address" name="address" value="${datacenter.address}" placeholder="آدرس">
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" class="form-control has-feedback-left" id="location" name="location" value="${datacenter.location}" placeholder="مختصات">
                                        <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <textarea type="text" class="form-control" id="description" name="description" value="${datacenter.description}" placeholder="توضیحات">
                                        </textarea>
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <div class="checkbox">
                                            <label class="">شهر
                                                <select name="cityId" class="form-control">
                                                    <c:forEach items="${cities}" var="city">
                                                        <option value="${city.id}">${city.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </label>
                                        </div>
                                        <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12 col-md-offset-3">
                                            <div class="form-group">
                                                <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                                    <button type="submit" class="btn btn-primary">انصراف</button>
                                                    <button type="submit" class="btn btn-success">ارسال</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../section/singleFooter.jsp"/>

</div>

<jsp:include page="../section/footer.jsp"/>
</body>
</html>