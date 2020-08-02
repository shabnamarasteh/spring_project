<%--
  Created by IntelliJ IDEA.
  User: shabnamPC
  Date: 8/2/2020
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col hidden-print">
            <div class="left_col scroll-view">

                <div class="navbar nav_title" style="border: 0;">
                    <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>{{ __('lang.title')}}</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="{{asset('image/img.jpg')}}" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>{{ __('lang.welcome')}}</span>
                        <h2>مرتضی کریمی</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>{{ __('lang.common')}}</h3>
                        <ul class="nav side-menu">
                            <li><a href="/admin/"><i class="fa fa-home"></i> {{ __('lang.dashboard')}}</a>

                            </li>
                            <li><a><i class="fa fa-users"></i> {{ __('lang.admins.resellers')}}  <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/admin/resellers/"> {{ __('lang.admins.resellers')}} </a></li>
                                    <li><a href="/admin/admins">{{ __('lang.admins.admins')}} </a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-desktop"></i> {{ __('lang.orders.title')}}
                                <span class="fa fa-chevron-down"></span>
                            </a>
                                <ul class="nav child_menu">
                                    <li><a href="/admin/orders/"> {{ __('lang.orders.title')}} </a></li>

                                </ul>
                            </li>
                            <li><a><i class="fa fa-money"></i> {{ __('lang.transactions.title')}} <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/admin/invoices"> {{ __('lang.transactions.invoices')}} </a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bar-chart-o"></i> {{ __('lang.products.title')}} <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/admin/brands">{{ __('lang.brands.title')}} </a></li>
                                    <li><a href="/admin/product"> {{ __('lang.products.title')}}</a></li>
                                    <li><a href="/admin/attribute"> {{ __('lang.products.attribute')}}</a></li>
                                    <li><a href="/admin/promotion"> {{ __('lang.promotion.title')}}</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-cogs"></i> {{ __('lang.configs.title')}} <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/admin/fixed_sidebar"> {{ __('lang.configs.all')}} </a></li>
                                    <li><a href="/admin/fixed_footer"> {{ __('lang.configs.template')}} </a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="{{ __('lang.configs.title')}}">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="{{ __('lang.configs.fullScreen')}}" onclick="toggleFullScreen();">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="{{ __('lang.configs.lock')}}" class="lock_btn">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="{{ __('lang.logout')}}" href="login.html">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav hidden-print">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown"
                               aria-expanded="false">
                                <img src="../build/images/img.jpg" alt="">مرتضی کریمی
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                <li><a href="javascript:;"> نمایه</a></li>
                                <li>
                                    <a href="javascript:;">
                                        <span class="badge bg-red pull-right">50%</span>
                                        <span>تنظیمات</span>
                                    </a>
                                </li>
                                <li><a href="javascript:;">کمک</a></li>
                                <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> خروج</a></li>
                            </ul>
                        </li>

                        <li role="presentation" class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown"
                               aria-expanded="false">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-green">6</span>
                            </a>
                            <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                                <li>
                                    <a>
                                        <span class="image"><img src="../build/images/img.jpg"
                                                                 alt="Profile Image"/></span>
                                        <span>
                          <span>مرتضی کریمی</span>
                          <span class="time">3 دقیقه پیش</span>
                        </span>
                                        <span class="message">
                          فیلمای فستیوال فیلمایی که اجرا شده یا راجع به لحظات مرده ایه که فیلمسازا میسازن. آنها جایی بودند که....
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="../build/images/img.jpg"
                                                                 alt="Profile Image"/></span>
                                        <span>
                          <span>مرتضی کریمی</span>
                          <span class="time">3 دقیقه پیش</span>
                        </span>
                                        <span class="message">
                          فیلمای فستیوال فیلمایی که اجرا شده یا راجع به لحظات مرده ایه که فیلمسازا میسازن. آنها جایی بودند که....
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="../build/images/img.jpg"
                                                                 alt="Profile Image"/></span>
                                        <span>
                          <span>مرتضی کریمی</span>
                          <span class="time">3 دقیقه پیش</span>
                        </span>
                                        <span class="message">
                          فیلمای فستیوال فیلمایی که اجرا شده یا راجع به لحظات مرده ایه که فیلمسازا میسازن. آنها جایی بودند که....
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="../build/images/img.jpg"
                                                                 alt="Profile Image"/></span>
                                        <span>
                          <span>مرتضی کریمی</span>
                          <span class="time">3 دقیقه پیش</span>
                        </span>
                                        <span class="message">
                          فیلمای فستیوال فیلمایی که اجرا شده یا راجع به لحظات مرده ایه که فیلمسازا میسازن. آنها جایی بودند که....
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <div class="text-center">
                                        <a>
                                            <strong>مشاهده تمام اعلان ها</strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>