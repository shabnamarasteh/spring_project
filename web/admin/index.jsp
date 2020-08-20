
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
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="dashboard_graph">

                <div class="row x_title">
                    <div class="col-md-6">
                        <h3>فعالیت های شبکه
                            <small>عنوان نمودار زیر عنوان</small>
                        </h3>
                    </div>
                    <div class="col-md-6">
                        <div id="reportrange" class="pull-left"
                             style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                            <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                            <span>اسفند 29, 1394 - فروردین 28, 1395</span> <b class="caret"></b>
                        </div>
                    </div>
                </div>

                <div class="col-md-9 col-sm-9 col-xs-12">
                    <div id="placeholder33" style="height: 260px; display: none" class="demo-placeholder"></div>
                    <div style="width: 100%;">
                        <div id="chart_plot_01" class="demo-placeholder" style="width: 100%; height:270px;"></div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-12 bg-white">
                    <div class="x_title">
                        <h2>بالاترین عملکرد در کمپین</h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="col-md-12 col-sm-12 col-xs-6">
                        <div>
                            <p>کمپین فیسبوک</p>
                            <div class="">
                                <div class="progress progress_sm" style="width: 76%;">
                                    <div class="progress-bar bg-green" role="progressbar"
                                         data-transitiongoal="80"></div>
                                </div>
                            </div>
                        </div>
                        <div>
                            <p>کمپین تویتتر</p>
                            <div class="">
                                <div class="progress progress_sm" style="width: 76%;">
                                    <div class="progress-bar bg-green" role="progressbar"
                                         data-transitiongoal="60"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 col-sm-12 col-xs-6">
                        <div>
                            <p>رسانه های متعارف</p>
                            <div class="">
                                <div class="progress progress_sm" style="width: 76%;">
                                    <div class="progress-bar bg-green" role="progressbar"
                                         data-transitiongoal="40"></div>
                                </div>
                            </div>
                        </div>
                        <div>
                            <p>بیلبوردهای تبلیغاتی</p>
                            <div class="">
                                <div class="progress progress_sm" style="width: 76%;">
                                    <div class="progress-bar bg-green" role="progressbar"
                                         data-transitiongoal="50"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="clearfix"></div>
            </div>
        </div>

    </div>
    <br/>

    <div class="row">


        <div class="col-md-4 col-sm-4 col-xs-12">
            <div class="x_panel tile fixed_height_320">
                <div class="x_title">
                    <h2>نسخه های نرم افزار</h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">تنظیمات 1</a>
                                </li>
                                <li><a href="#">تنظیمات 2</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <h4>استفاده از نرم افزار در تمامی نسخه ها</h4>
                    <div class="widget_summary">
                        <div class="w_left w_25">
                            <span>0.1.5.2</span>
                        </div>
                        <div class="w_center w_55">
                            <div class="progress">
                                <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 66%;">
                                    <span class="sr-only">60% تکمیل</span>
                                </div>
                            </div>
                        </div>
                        <div class="w_right w_20">
                            <span>123k</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>

                    <div class="widget_summary">
                        <div class="w_left w_25">
                            <span>0.1.5.3</span>
                        </div>
                        <div class="w_center w_55">
                            <div class="progress">
                                <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 45%;">
                                    <span class="sr-only">60% تکمیل</span>
                                </div>
                            </div>
                        </div>
                        <div class="w_right w_20">
                            <span>53k</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="widget_summary">
                        <div class="w_left w_25">
                            <span>0.1.5.4</span>
                        </div>
                        <div class="w_center w_55">
                            <div class="progress">
                                <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 25%;">
                                    <span class="sr-only">60% تکمیل</span>
                                </div>
                            </div>
                        </div>
                        <div class="w_right w_20">
                            <span>23k</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="widget_summary">
                        <div class="w_left w_25">
                            <span>0.1.5.5</span>
                        </div>
                        <div class="w_center w_55">
                            <div class="progress">
                                <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 5%;">
                                    <span class="sr-only">60% تکمیل</span>
                                </div>
                            </div>
                        </div>
                        <div class="w_right w_20">
                            <span>3k</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="widget_summary">
                        <div class="w_left w_25">
                            <span>0.1.5.6</span>
                        </div>
                        <div class="w_center w_55">
                            <div class="progress">
                                <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 2%;">
                                    <span class="sr-only">60% تکمیل</span>
                                </div>
                            </div>
                        </div>
                        <div class="w_right w_20">
                            <span>1k</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>

                </div>
            </div>
        </div>

        <div class="col-md-4 col-sm-4 col-xs-12">
            <div class="x_panel tile fixed_height_320 overflow_hidden">
                <div class="x_title">
                    <h2>میزان استفاده از دستگاه</h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">تنظیمات 1</a>
                                </li>
                                <li><a href="#">تنظیمات 2</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <table class="" style="width:100%">
                        <tr>
                            <th style="width:37%;">
                                <p>5 تای اول</p>
                            </th>
                            <th>
                                <div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
                                    <p class="">دستگاه</p>
                                </div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <p class="">استفاده</p>
                                </div>
                            </th>
                        </tr>
                        <tr>
                            <td>
                                <canvas class="canvasDoughnut" height="140" width="140"
                                        style="margin: 15px 10px 10px 0"></canvas>
                            </td>
                            <td>
                                <table class="tile_info">
                                    <tr>
                                        <td>
                                            <p><i class="fa fa-square blue"></i>IOS </p>
                                        </td>
                                        <td>30%</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p><i class="fa fa-square green"></i>اندروید </p>
                                        </td>
                                        <td>10%</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p><i class="fa fa-square purple"></i>بلکبری </p>
                                        </td>
                                        <td>20%</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p><i class="fa fa-square aero"></i>سیمبین </p>
                                        </td>
                                        <td>15%</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p><i class="fa fa-square red"></i>دیگر </p>
                                        </td>
                                        <td>30%</td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>


        <div class="col-md-4 col-sm-4 col-xs-12">
            <div class="x_panel tile fixed_height_320">
                <div class="x_title">
                    <h2>تنظیمات سریع</h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">تنظیمات 1</a>
                                </li>
                                <li><a href="#">تنظیمات 2</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <div class="dashboard-widget-content">
                        <ul class="quick-list">
                            <li><i class="fa fa-calendar-o"></i><a href="#">تنظیمات</a>
                            </li>
                            <li><i class="fa fa-bars"></i><a href="#">اشتراک</a>
                            </li>
                            <li><i class="fa fa-bar-chart"></i><a href="#">تمدید خودکار</a></li>
                            <li><i class="fa fa-line-chart"></i><a href="#">دستاوردها</a>
                            </li>
                            <li><i class="fa fa-bar-chart"></i><a href="#">تمدید خودکار</a></li>
                            <li><i class="fa fa-line-chart"></i><a href="#">دستاوردها</a>
                            </li>
                            <li><i class="fa fa-area-chart"></i><a href="#">خروج</a>
                            </li>
                        </ul>

                        <div class="sidebar-widget">
                            <h4>مشخصات تکمیل</h4>
                            <canvas width="150" height="80" id="chart_gauge_01" class=""
                                    style="width: 160px; height: 100px;"></canvas>
                            <div class="goal-wrapper">
                                <span class="gauge-value pull-left">$</span>
                                <span id="gauge-text" class="gauge-value pull-left">3,200</span>
                                <span id="goal-text" class="goal-value pull-right">$5,000</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>فعالیت های اخیر
                        <small>جلسه ها</small>
                    </h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">تنظیمات 1</a>
                                </li>
                                <li><a href="#">تنظیمات 2</a>
                                </li>
                            </ul>
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
                                            <a>چه کسی نیاز به یک پنل مدیریت خوب دارد؟</a>
                                        </h2>
                                        <div class="byline">
                                            <span>13 ساعت پیش</span> توسط <a>مرتضی کریمی</a>
                                        </div>
                                        <p class="excerpt">این یک متن نمونه برای بخش داشبورد پنل مدیریت پارسی
                                            شده ی Gentelella می باشد که برای نمایش امکانات آن نوشته شده است و
                                            هیچ معنا و مفهوم خاصی ندارد… <a>بیشتر&nbsp;بخوانید</a>
                                        </p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="block">
                                    <div class="block_content">
                                        <h2 class="title">
                                            <a>چه کسی نیاز به یک پنل مدیریت خوب دارد؟</a>
                                        </h2>
                                        <div class="byline">
                                            <span>13 ساعت پیش</span> توسط <a>مرتضی کریمی</a>
                                        </div>
                                        <p class="excerpt">این یک متن نمونه برای بخش داشبورد پنل مدیریت پارسی
                                            شده ی Gentelella می باشد که برای نمایش امکانات آن نوشته شده است و
                                            هیچ معنا و مفهوم خاصی ندارد… <a>بیشتر&nbsp;بخوانید</a>
                                        </p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="block">
                                    <div class="block_content">
                                        <h2 class="title">
                                            <a>چه کسی نیاز به یک پنل مدیریت خوب دارد؟</a>
                                        </h2>
                                        <div class="byline">
                                            <span>13 ساعت پیش</span> توسط <a>مرتضی کریمی</a>
                                        </div>
                                        <p class="excerpt">این یک متن نمونه برای بخش داشبورد پنل مدیریت پارسی
                                            شده ی Gentelella می باشد که برای نمایش امکانات آن نوشته شده است و
                                            هیچ معنا و مفهوم خاصی ندارد… <a>بیشتر&nbsp;بخوانید</a>
                                        </p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="block">
                                    <div class="block_content">
                                        <h2 class="title">
                                            <a>چه کسی نیاز به یک پنل مدیریت خوب دارد؟</a>
                                        </h2>
                                        <div class="byline">
                                            <span>13 ساعت پیش</span> توسط <a>مرتضی کریمی</a>
                                        </div>
                                        <p class="excerpt">این یک متن نمونه برای بخش داشبورد پنل مدیریت پارسی
                                            شده ی Gentelella می باشد که برای نمایش امکانات آن نوشته شده است و
                                            هیچ معنا و مفهوم خاصی ندارد… <a>بیشتر&nbsp;بخوانید</a>
                                        </p>
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
                            <h2>محل بازدید کنندگان
                                <small>ارائه جغرافیایی</small>
                            </h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                       aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">تنظیمات 1</a>
                                        </li>
                                        <li><a href="#">تنظیمات 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="dashboard-widget-content">
                                <div class="col-md-4 hidden-small">
                                    <h2 class="line_30">125.7k بازدید از 60 کشور</h2>

                                    <table class="countries_list">
                                        <tbody>
                                        <tr>
                                            <td>ایالات متحده</td>
                                            <td class="fs15 fw700 text-right">33%</td>
                                        </tr>
                                        <tr>
                                            <td>فرانسه</td>
                                            <td class="fs15 fw700 text-right">27%</td>
                                        </tr>
                                        <tr>
                                            <td>آلمان</td>
                                            <td class="fs15 fw700 text-right">16%</td>
                                        </tr>
                                        <tr>
                                            <td>اسپانیا</td>
                                            <td class="fs15 fw700 text-right">11%</td>
                                        </tr>
                                        <tr>
                                            <td>بریتانیا</td>
                                            <td class="fs15 fw700 text-right">10%</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div id="world-map-gdp" class="col-md-8 col-sm-12 col-xs-12"
                                     style="height:230px;"></div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">


                <!-- Start to do list -->
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>فهرست کارها
                                <small>وظایف نمونه</small>
                            </h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                       aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">تنظیمات 1</a>
                                        </li>
                                        <li><a href="#">تنظیمات 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">

                            <div class="">
                                <ul class="to_do">
                                    <li>
                                        <p>
                                            <input type="checkbox" class="flat"> ملاقات با مشتری جدید </p>
                                    </li>
                                    <li>
                                        <p>
                                            <input type="checkbox" class="flat"> ایجاد ایمیل برای کارآموز جدید
                                        </p>
                                    </li>
                                    <li>
                                        <p>
                                            <input type="checkbox" class="flat"> آیا بخش IT پرینتر شبکه را تعمیر
                                            کرد</p>
                                    </li>
                                    <li>
                                        <p>
                                            <input type="checkbox" class="flat"> کپی نسخه های پشتیبان به محل
                                            offsite</p>
                                    </li>
                                    <li>
                                        <p>
                                            <input type="checkbox" class="flat"> خرید مواد خوراکی برای خانه</p>
                                    </li>
                                    <li>
                                        <p>
                                            <input type="checkbox" class="flat"> ملاقات با مشتری جدید </p>
                                    </li>
                                    <li>
                                        <p>
                                            <input type="checkbox" class="flat"> ایجاد ایمیل برای کارآموز جدید
                                        </p>
                                    </li>
                                    <li>
                                        <p>
                                            <input type="checkbox" class="flat"> آیا بخش IT پرینتر شبکه را تعمیر
                                            کرد</p>
                                    </li>
                                    <li>
                                        <p>
                                            <input type="checkbox" class="flat"> کپی نسخه های پشتیبان به محل
                                            offsite</p>
                                    </li>
                                    <li>
                                        <p>
                                            <input type="checkbox" class="flat"> خرید مواد خوراکی برای خانه</p>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End to do list -->

                <!-- start of weather widget -->
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>کاربران فعال روزانه
                                <small>جلسه ها</small>
                            </h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                       aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">تنظیمات 1</a>
                                        </li>
                                        <li><a href="#">تنظیمات 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="temperature"><b>دوشنبه</b>, 07:30 صبح
                                        <span>&deg;F</span>
                                        <span><b>&deg;C</b></span>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="weather-icon">
                                        <canvas height="84" width="84" id="partly-cloudy-day"></canvas>
                                    </div>
                                </div>
                                <div class="col-sm-8">
                                    <div class="weather-text">
                                        <h2>مشهد <br><i>روز نیمه ابری</i></h2>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12">
                                <div class="weather-text pull-left">
                                    <h3 class="degrees">23</h3>
                                </div>
                            </div>

                            <div class="clearfix"></div>

                            <div class="row weather-days">
                                <div class="col-sm-2">
                                    <div class="daily-weather">
                                        <h2 class="day">شنبه</h2>
                                        <h3 class="degrees">25</h3>
                                        <canvas id="clear-day" width="32" height="32"></canvas>
                                        <h5>15 <i>km/h</i></h5>
                                    </div>
                                </div>
                                <div class="col-sm-2">
                                    <div class="daily-weather">
                                        <h2 class="day">یکشنبه</h2>
                                        <h3 class="degrees">25</h3>
                                        <canvas height="32" width="32" id="rain"></canvas>
                                        <h5>12 <i>km/h</i></h5>
                                    </div>
                                </div>
                                <div class="col-sm-2">
                                    <div class="daily-weather">
                                        <h2 class="day">دوشنبه</h2>
                                        <h3 class="degrees">27</h3>
                                        <canvas height="32" width="32" id="snow"></canvas>
                                        <h5>14 <i>km/h</i></h5>
                                    </div>
                                </div>
                                <div class="col-sm-2">
                                    <div class="daily-weather">
                                        <h2 class="day">سه&nbsp;شنبه</h2>
                                        <h3 class="degrees">28</h3>
                                        <canvas height="32" width="32" id="sleet"></canvas>
                                        <h5>15 <i>km/h</i></h5>
                                    </div>
                                </div>
                                <div class="col-sm-2">
                                    <div class="daily-weather">
                                        <h2 class="day">چهارشنبه</h2>
                                        <h3 class="degrees">28</h3>
                                        <canvas height="32" width="32" id="wind"></canvas>
                                        <h5>11 <i>km/h</i></h5>
                                    </div>
                                </div>
                                <div class="col-sm-2">
                                    <div class="daily-weather">
                                        <h2 class="day">پنج&nbsp;شنبه</h2>
                                        <h3 class="degrees">26</h3>
                                        <canvas height="32" width="32" id="cloudy"></canvas>
                                        <h5>10 <i>km/h</i></h5>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- end of weather widget -->
            </div>
        </div>
    </div>


    <jsp:include page="section/singleFooter.jsp"/>
</div>
</div>

<jsp:include page="section/footer.jsp"/>
</body>
</html>