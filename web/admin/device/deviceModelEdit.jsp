
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                            <a href="#tab_content11" id="home-tabb"  role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">ایجاد مدیریت جدید</a>
                        </li>
                    </ul>
                    <div id="myTabContent2" class="tab-content">
                        <div role="tabpanel" class="tab-pane fade active in" id="tab_content11" aria-labelledby="home-tab">
                            <div class="x_content">
                                <br/>
                                <form:form class="form-horizontal form-label-left input_mask"
                                           method="put" action="/admin/deviceModel/update.do" modelAttribute="deviceModel">
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="hidden" name="id" value="${deviceModel.id}" />
                                        <input type="text" class="form-control" id="name" name="name" placeholder="نام"
                                               value="${deviceModel.name}">
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>

                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" class="form-control" id="model" name="model" placeholder="مدل"
                                               value="${deviceModel.model}">
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <textarea type="text" class="form-control" id="description" placeholder="توضیحات" name="description" >
                                            ${deviceModel.id}
                                        </textarea>
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" class="form-control" id="max_unit" name="max_unit" placeholder="حداکثر واحد"
                                               value="${deviceModel.max_unit}">
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" class="form-control" id="cover" name="cover" placeholder="کاور" value="${deviceModel.cover}">
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                                    </div>


                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
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
    <jsp:include page="../section/singleFooter.jsp"/>

</div>

<jsp:include page="../section/footer.jsp"/>
</body>
</html>