
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <jsp:include page="section/header.jsp"/>
    <title>فرم ورود</title>
</head>
<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>
    <a class="hiddenanchor" id="reset"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="post" method="/login/authenticate.do">
                    <h1>فرم ورود</h1>
                    <div>
                        <input type="text" class="form-control" placeholder="پست الکترونیک" required="" name="username" />
                    </div>
                    <div>
                        <input type="password" class="form-control" placeholder="رمز ورود" required="" name="password" />
                    </div>
                    <div>
                        <input type="submit" class="btn btn-default submit" value="ورود"/>
<%--                        <a class="reset_pass" href="#reset">رمز ورود را از دست دادید؟</a>--%>
                    </div>

                    <div class="clearfix"></div>

<%--                    <div class="separator">--%>
<%--                        <p class="change_link">جدید در سایت؟--%>
<%--                            <a href="#signup" class="to_register"> ایجاد حساب </a>--%>
<%--                        </p>--%>

<%--                        <div class="clearfix"></div>--%>
<%--                        <br />--%>


<%--                    </div>--%>
                </form>
            </section>
        </div>
        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form>
                    <h1>ایجاد حساب</h1>
                    <div>
                        <input type="text" class="form-control" placeholder="نام کاربری" required="" />
                    </div>
                    <div>
                        <input type="email" class="form-control" placeholder="ایمیل" required="" />
                    </div>
                    <div>
                        <input type="password" class="form-control" placeholder="رمز ورود" required="" />
                    </div>
                    <div>
                        <a class="btn btn-default submit" href="index.html">ارسال</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">در حال حاضر عضو هستید؟
                            <a href="#signin" class="to_register"> ورود </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                    </div>
                </form>
            </section>
        </div>
        <div id="rest_pass" class="animate form rest_pass_form">
            <section class="login_content">
                <!-- /password recovery -->
                <form action="index.html">
                    <h1>بازیابی رمز عبور</h1>
                    <div class="form-group has-feedback">
                        <input type="email" class="form-control" name="email" placeholder="ایمیل" />
                        <div class="form-control-feedback">
                            <i class="fa fa-envelope-o text-muted"></i>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-default btn-block">بازیابی رمز عبور </button>
                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">جدید در سایت؟
                            <a href="#signup" class="to_register"> ایجاد حساب </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                    </div>
                </form>
                <!-- Password recovery -->
            </section>
        </div>
    </div>
</div>
</body>
</html>