<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
<style type="text/css">
    body {
        /*keyframes一开始会出现白屏的情况是因为图片加载中间过过渡
        解决方案: 可以把本地的图片之间添加到background:url(“”)中 这样就不会出现白屏
        */
        background: url("../../static/img/bg_1.jpg"),url("../../static/img/bg_2.jpg"),url("../../static/img/bg_3.jpg") no-repeat;
        background-size: cover;
        animation-name: myfirst;
        animation-duration: 12s;
        /*变换时间*/
        animation-delay: 2s;
        /*动画开始时间*/
        animation-iteration-count: infinite;
        /*下一周期循环播放*/
        animation-play-state: running;
        /*动画开始运行*/
    }

    @keyframes myfirst {
        0% {
            background: url("../../static/img/bg_1.jpg");
            background-size: cover;
        }
        40% {
            background: url("../../static/img/bg_2.jpg");
            background-size: cover;
        }
        80% {
            background: url("../../static/img/bg_3.jpg");
            background-size: cover;
        }
        100% {
            background: url("../../static/img/bg_1.jpg");
            background-size: cover;
        }
    }
</style>

<div class="container" align="center">
    <div class="row">
        <div class="col-md-4 col-md-offset-4" style="margin: 380px 380px">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" style="text-align: center;">登录</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="#" method="post" id="login_form">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="用户名:admin" name="username" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码:1234" name="password" type="password"
                                       value="">
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <a href="javascript:void(0)" class="btn btn-lg btn-success btn-block" id='login_btn'>登录</a>
                        </fieldset>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    $(function () {
        $("#login_btn").click(function () {
            $.ajax({
                url: "/xjl/dologin",
                type: "POST",
                data: $("#login_form").serialize(),
                success: function (result) {
                    if (result.code == 100) {
                        window.location.href = "/xjl/main";
                    } else {
                        alert(result.extendInfo.login_error);
                    }
                }

            });
        });
    });
</script>
</body>
</html>
