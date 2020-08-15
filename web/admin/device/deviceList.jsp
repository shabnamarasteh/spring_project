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
    <title>صفحه اصلی</title>
</head>
<body class="nav-md">

<jsp:include page="../section/nav.jsp"/>

<div class="right_col" role="main">
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_content">
                <a href="{{route('category_create')}}"
                   class="btn btn-round btn-primary">{{ __('lang.btn.new')}}</a>

                <div class="table-responsive">

                    <table class="table table-striped jambo_table bulk_action">
                        <thead>
                        <tr class="headings">
                            <th class="column-title category-title">نام دستگاه</th>
                            <th class="column-title category-title">آدرس IP</th>
                            <th class="column-title category-title">مدل دستگاه</th>
                            <th class="column-title category-title">رک</th>
                            <th class="column-title category-title">یونیت شروع</th>
                            <th class="column-title category-title">مالک دستگاه</th>
                            <th class="column-title"></th>
                            <th class="column-title"></th>
                            <th class="column-title"></th>
                            <th class="column-title"></th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${devices}" var="food">
                        <tr>
                            <td>
                                    ${food.key}-- ${food.value}
                            </td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>

                        </c:forEach>
                        <%--                        @foreach($devices as device)--%>
                        <%--                        <tr>--%>
                        <%--                            <td>{{$category['title']}}</td>--%>
                        <%--                            <td><a href="{{route('category.edit', $category['id'])}}"--%>
                        <%--                                   class="btn btn-round btn-info">{{ __('lang.btn.edit')}}</a></td>--%>
                        <%--                            <td><form action="{{ URL::route('category.delete', $category['id']) }}" method="POST">--%>
                        <%--                                <input type="hidden" name="_method" value="DELETE">--%>
                        <%--                                <input type="hidden" name="_token" value="{{ csrf_token() }}">--%>
                        <%--                                <button  class="btn btn-round btn-danger">{{ __('lang.btn.delete')}}</button>--%>
                        <%--                            </form></td>--%>
                        <%--                            <td><a class="btn btn-round btn-primary main_menu"--%>
                        <%--                                   data-toggle="collapse"--%>
                        <%--                                   data-target="#multiCollapseExample{{$category['id']}}"--%>
                        <%--                                   aria-expanded="false"--%>
                        <%--                                   aria-controls="multiCollapseExample{{$category['id']}}"><i class='fa fa-angle-double-down'></i></a>--%>
                        <%--                            </td>--%>
                        <%--                            <td><a href="{{route('category.Sub', $category['id'])}}"--%>
                        <%--                                   class="btn btn-round btn-info"><i class='fa fa-plus'></i></a></td>--%>

                        <%--                        </tbody>--%>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../section/footer.jsp"/>
</body>
</html>