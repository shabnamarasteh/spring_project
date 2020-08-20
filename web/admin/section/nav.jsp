<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col hidden-print">
            <div class="left_col scroll-view">

                <div class="navbar nav_title" style="border: 0;">
                    <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>مدیریت سرور</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- /menu profile quick info -->

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <%--                        <h3>سرور ها</h3>--%>
                        <ul class="nav side-menu">
                            <li><a href="/admin"><i class="fa fa-home"></i> صفحه اصلی</a>

                            </li>
                            <li><a><i class="fa fa-users"></i> کاربران <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/admin/index.do">مدیران سیستم </a></li>
                                    <li><a href="/owner/index.do">صاحبان سرور </a></li>
                                </ul>
                            </li>

                            <li><a><i class="fa fa-money"></i> سرور ها <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">

                                    <li><a href="/admin/datacenter/index.do"> دیتاسنترها </a></li>
                                    <li><a href="/admin/deviceModel/index.do"> مدل سرور </a></li>
                                    <li><a href="/admin/deviceGroup/index.do"> گروه سرور </a></li>
                                    <li><a href="/admin/deviceModelProperty/index.do"> ویژگی مدل سرور </a></li>
                                    <li><a href="/admin/rack/index.do">رک ها </a></li>
                                    <li><a href="/admin/device/index.do">سرور ها </a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bar-chart-o"></i> گزارشات <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/admin/alarms">گزارش دستگاه ها</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bar-chart-o"></i> تنظیمات سیستم <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/admin/alarms">هشدار</a></li>
                                    <li><a href="/admin/config/index.do">تنظیمات کلی</a></li>

                                    <li><a href="/admin/state/all.do">استان</a></li>
                                    <li><a href="/admin/city/all.do">شهر</a></li>
                                </ul>
                            </li>

                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->
                
            </div>
        </div>

        <!-- /header content -->

        <!-- page content -->

