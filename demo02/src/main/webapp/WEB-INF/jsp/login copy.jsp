<!-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/css/fontawesome/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <link rel="stylesheet" href="/css/tempusdominus-bootstrap-4.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/css/icheck-bootstrap.min.css">
    <!-- JQVMap -->
    <link rel="stylesheet" href="/css/jqvmap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="/css/OverlayScrollbars.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="/css/daterangepicker.css">
    <!-- summernote -->
    <link rel="stylesheet" href="/css/summernote-bs4.min.css">
</head>

<body>
    <div class="container">
        <div class="login-box col-6 align-items-center mx-auto">
            <div class="login-logo text-center my-3">
                <a href="/admin/login"><b>Admin</b>Console</a>
            </div>

            <div class="container">
                <div class="card">
                    <div class="card-body login-card-body">
                        <p class="login-box-msg">後台登入</p>
                        <form action="/admin/login" method="post" onsubmit="doCheck">
                            <!-- @if ($errors->has("msg")) -->
                            <!-- <div class="alert alert-danger"> -->
                                <!-- {{ $errors->first("msg") }} -->
                            <!-- </div> -->
                            <!-- @endif -->

                            <!-- @if ($errors->has("code")) -->
                            <!-- <div class="alert alert-danger"> -->
                                <!-- {{ $errors->first("code") }} -->
                            <!-- </div> -->
                            <!-- @endif -->
                            
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="user_id" placeholder="User Id" value="" required>
                                <div class="input-group-append">
                                    <div class="input-group-text">
                                        <span class="fas fa-envelope"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="input-group mb-3">
                                <input type="password" class="form-control" name="password" placeholder="Password" required>
                                <div class="input-group-append">
                                    <div class="input-group-text">
                                        <span class="fas fa-lock"></span>
                                    </div>
                                </div>
                            </div>

                            <!-- <div class="input-group mb-3 row gx-0 d-flex justify-content-around">
                                <div class="col float-left">
                                    <input type="text" class="form-control" name="code" placeholder="Captcha" required>
                                </div> -->
                                <!-- 問號代表隨機方式 -->
                                <!-- <div class="col">
                                    <img src="/captcha/flat?" alt="captcha" width="100%" onclick="this.src='/captcha/flat?' + Math.random()" style="cursor: pointer" />
                                </div> -->
                            <!-- </div> -->

                            <div class="ml-2 d-flex">
                                <div class="col-7">
                                    <div class="icheck-primary">
                                        <input type="checkbox" id="remember" class="form-check-input">
                                        <label for="remember">
                                            Remember Me
                                        </label>
                                    </div>
                                </div>

                                <div class="col-4">
                                    <button type="submit" class="btn btn-primary btn-block">Sign In</button>
                                </div>

                            </div>
                        </form>
                        <!-- <p class="mb-1">
                            <a href="forgot-password.html">I forgot my password</a>
                        </p>
                        <p class="mb-0">
                            <a href="register.html" class="text-center">Register a new membership</a>
                        </p> -->
                    </div>

                </div>
            </div>
        </div>
    </div>


    <!-- Sweet Alert -->
    <script src="/js/sweetalert2.all.min.js"></script>
    <!-- jQuery -->
    <script src="/js/jquery.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="/js/jquery-ui.min.js"></script>

    <script>
        $(document).ready(function () {

            function doCheck()
            {
                var code = $("#code").val();
                if(code == "")
                {
                    alert("請輸入驗證碼");
                    return false;
                }
                return true;
            }
            
        });
    </script>
</body>

</html>