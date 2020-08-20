<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hedi
  Date: 8/10/2020
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                            <a href="#tab_content11" id="home-tabb"  role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">ایجاد مدیریت جدید</a>
                        </li>
                    </ul>
                    <div id="myTabContent2" class="tab-content">
                        <div role="tabpanel" class="tab-pane fade active in" id="tab_content11" aria-labelledby="home-tab">
                            <div class="x_content">
                                <br/>
                                <form method="POST"
                                      action="/admin/rack/${id}/edit.do" modelAttribute="rack" class="form-horizontal form-label-left input_mask">
                                    <input type="hidden" value="PUT" name="_method">
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <select name="datacenterId" class="form-control">
                                            <c:forEach items="${datacenters}" var="datacenter">
                                                <option value="${datacenter.id}"
<%--                                                        <c:if test="${rack.getDatacenterId().getId() == datacenter.id}">checked="checked"</c:if>--%>
                                                >${datacenter.name}</option>
                                            </c:forEach>
                                        </select>

                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" class="form-control" id="name" name="name" placeholder="نام" value="${rack.name}">
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>

                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" class="form-control" id="maxUnit" name="maxUnit" placeholder="حداکثر واحد " value="${rack.maxUnit}">
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                                    </div>


                                    <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12 form-group has-feedback">
                                        <div class="form-group">
                                            <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                                <button type="submit" class="btn btn-primary">انصراف</button>
                                                <button type="submit" class="btn btn-success">ارسال</button>
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