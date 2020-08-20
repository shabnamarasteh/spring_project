
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <jsp:include page="section/header.jsp"/>
    <title>صفحه اصلی</title>
</head>
<div class="nav-md">

<jsp:include page="section/nav.jsp"/>
<div class="right_col" role="main">
    <!-- top tiles -->
    <div class="row tile_count">
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-user"></i> تعداد کاربران</span>
            <div class="count">2500</div>
            <span class="count_bottom"><i class="green">4% </i> از هفته گذشته</span>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-clock-o"></i> میانگین زمان</span>
            <div class="count">123.50</div>
            <span class="count_bottom"><i class="green"><i
                    class="fa fa-sort-asc"></i>3% </i> از هفته گذشته</span>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-user"></i> مجموع مردان</span>
            <div class="count green">2,500</div>
            <span class="count_bottom"><i class="green"><i
                    class="fa fa-sort-asc"></i>34% </i> از هفته گذشته</span>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-user"></i> مجموع زنان</span>
            <div class="count">4,567</div>
            <span class="count_bottom"><i class="red"><i
                    class="fa fa-sort-desc"></i>12% </i> از هفته گذشته</span>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-user"></i> مجموعه کلی</span>
            <div class="count">2,315</div>
            <span class="count_bottom"><i class="green"><i
                    class="fa fa-sort-asc"></i>34% </i> از هفته گذشته</span>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-user"></i> مجموع اتصالات</span>
            <div class="count">7,325</div>
            <span class="count_bottom"><i class="green"><i
                    class="fa fa-sort-asc"></i>34% </i> از هفته گذشته</span>
        </div>
    </div>
    <!-- /top tiles -->

    <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>راهنمای سریع
                        <small>گردش کار</small>
                    </h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        </li>
                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <div class="dashboard-widget-content">
                        <ul class="list-unstyled timeline widget">
                            <li>
                                <div class="block">
                                    <div class="block_content">
                                        <h2 class="title">
                                            <a>مدیران سیستم: </a>
                                        </h2>
                                        <p class="excerpt">
                                 مدیران سیستم همان اپراتور های سیستم می باشند که با دسترسی خود وارد سیستم شده و داده ها را وارد می نمایند. همچنین آلارم های سرور ها به صندوق ایمیل ایشان ارسال می شود.                       </p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="block">
                                    <div class="block_content">
                                        <h2 class="title">
                                            <a>استان و شهر: </a>
                                        </h2>
                                        <p class="excerpt">
                                            ابتدا باید استان ها و شهر های زیر مجموعه آنها را ایجاد نمایید. شهر ها و استان ها برای ایجاد دیتاسنتر ها مورد استفاده قرار می گیرند.
                                        </p></div>
                                </div>
                            </li>
                            <li>
                                <div class="block">
                                    <div class="block_content">
                                        <h2 class="title">
                                            <a>صاحبان سرور: </a>
                                        </h2>
                                        <p class="excerpt">
                                            هر سرور دارای یک صاحب (owner) می باشد که سرور مربوط به ایشان است. صاحبان سرور همان رابط فنی مشتریان می باشند که در صورت اختلال می بایست ایشان را با خبر نمود.
                                        </p>
                                    </div>

                                </div>
                            </li>
                            <li>
                                <div class="block">
                                    <div class="block_content">
                                        <h2 class="title">
                                            <a>	مدل سرور:</a>
                                        </h2>
                                        <p class="excerpt">
                                            هر سرور دارای یک صاحب (owner) می باشد که سرور مربوط به ایشان است. صاحبان سرور همان رابط فنی مشتریان می باشند که در صورت اختلال می بایست ایشان را با خبر نمود.
                                        </p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="block">
                                    <div class="block_content">
                                        <h2 class="title">
                                            <a>دیتاسنتر: </a>
                                        </h2>
                                        <p class="excerpt">
                                            دیتاسنتر ها موقعیت های سازمان می باشند که سرور ها در آن ها قرار دارند.
                                        </p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="block">
                                    <div class="block_content">
                                        <h2 class="title">
                                            <a>رک: </a>
                                        </h2>
                                        <p class="excerpt">
                                            رک ها کابینت هایی هستند که در دیتاسنتر ها تعبیه می شوند و سرور ها درون آنها قرار داده می شوند. رک ها دارای چندی یونیت می باشند که طرفیت آنها را تشکیل می دهد.                                        </p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="block">
                                    <div class="block_content">
                                        <h2 class="title">
                                            <a>سرورها: </a>
                                        </h2>
                                        <p class="excerpt">
                                            سرور ها همان واحد هایی هستند که می بایست مانتور شده و در صورت ایجاد اختلال و عدم تناسب ویژگی اندازه گیری شده با آستانه تعریف شده، الارم ایجاد می شود.                                        </p>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div class="col-md-8 col-sm-8 col-xs-12">
            <div class="row">

                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>طراحی و توسعه سیستم مانیتورینگ سرور ها
                            </h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="dashboard-widget-content">
                                <div class="col-md-12 hidden-small">
                                    <p class="excerpt">
                                        مقدمه :در این پروژه با استفاده از فریموک  spring یک سیستم مانیتورینگ منابع سرور ها ط راحی و توسعه داده شده  است که شبیه سازی شده از سیستم مانیتورینگ کد باز  cactiمی باشد .در سیستم ابتدا دیتاسنتر تع ریف شده و س پس در دیتاسنتر ها رک تعریف م ی شوند. در هر  رک می توان سرور  های مختلفی از انوا ع  مختلف قرار داد که این مدل ها نیز در سیستم قابل تعریف می باشند.برای هر مدل  ویژگی های اندازه گیری با آس تانه آن تعریف میشوند که برای هر سرور  در بازه ها ی زمانی مشخص  (به طور مثال هر  5دقیق  )هاین  ویژگی ها  بررسی شده (با استفاده از پروتکل های شبکه ماننده  smtp و ...) و در  صورتی که مقدار اندازهگیری شده از آستانه تعریف شد ه  در سیستم بیشتر باشد برای ادمین های سیستم آلارم  ایجاد می گردد
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>


    <jsp:include page="section/singleFooter.jsp"/>
</div>
</div>

<jsp:include page="section/footer.jsp"/>
</body>
</html>