<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    - 编辑用户
</rapid:override>
<rapid:override name="header-style">
    <style>
        .layui-form-item .layui-input-inline {
            width: 300px;
        }
        .layui-form-label {
            width: 120px;
        }
        .layui-word-aux {
            color: #FF5722 !important;
        }

    </style>

    <link rel='stylesheet' id='login-css'  href='/plugin/login/login.min.css' type='text/css' media='all' />
</rapid:override>

<rapid:override name="content">


<%--    <form name="loginForm" id="loginForm"  method="post">--%>
    <%--layui-form--%>

    <br><br>
    <form name="loginForm" action="/registerSubmit" id="userForm"
          method="post">
        <input type="hidden" name="userId" id="userId" value="${user.userId}">
        <div class="layui-form-item">
            <label class="layui-form-label">头像</label>
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <div class="layui-upload-list" style="">
                        <img class="layui-upload-img" src="${user.userAvatar}" id="demo1" width="100"
                             height="100">
                        <p id="demoText"></p>
                    </div>
                    <button type="button" class="layui-btn" id="test1">上传图片</button>
                    <input type="hidden" name="userAvatar" id="userAvatar" value="${user.userAvatar}">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="text" value="${user.userName}" name="userName" id="userName" required
                       lay-verify="userName"
                       autocomplete="off" class="layui-input" onblur="checkUserNameReg()">
            </div>
            <div class="layui-form-mid layui-word-aux" id="userNameTips"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="password" name="userPass" value="${user.userPass}" id="userPass" required
                       autocomplete="off" class="layui-input" min="3" max="20">
            </div>
            <div class="layui-form-mid layui-word-aux"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="userNickname" value="${user.userNickname}" required
                       placeholder="" autocomplete="off" min="2" max="10"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">Email <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="email" name="userEmail" value="${user.userEmail}" id="userEmail" required
                       lay-verify="userEmail"
                       class="layui-input" onblur="checkUserEmailReg()">
            </div>
            <div class="layui-form-mid layui-word-aux" id="userEmailTips"></div>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="demo1" id="submit-btn">注册</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

<%--    </form>--%>


</rapid:override>
<rapid:override name="footer-script">

    <script>
        //上传图片
        layui.use('upload', function () {
            var $ = layui.jquery,
                upload = layui.upload;
            var uploadInst = upload.render({
                elem: '#test1',
                url: '/register/upload/img',
                before: function (obj) {
                    obj.preview(function (index, file, result) {
                        $('#demo1').attr('src', result);
                    });
                },
                done: function (res) {
                    $("#userAvatar").attr("value", res.data.src);
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    }
                },
                error: function () {
                    var demoText = $('#demoText');
                    demoText.html('' +
                        '<span style="color: #FF5722;">上传失败</span>' +
                        ' <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function () {
                        uploadInst.upload();
                    });
                }
            });

        });
    </script>
</rapid:override>

<%@ include file="Public/framework.jsp" %>