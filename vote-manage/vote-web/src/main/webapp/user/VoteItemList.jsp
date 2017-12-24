<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>

<html>
<head>
    <title>javaweb大作业</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/snow.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript">

        function selectPhoto() {
            var url = $("#select option:selected").val();
            $("#img").attr("src", url);
        }
    </script>
    <style>
        .wh_font{color:white;}
        tr td:first{text-align: center;}
        .rule{vertical-align: middle;}
        .Textarea{margin-top: 30px; padding: 10px; width:300px; height: 150px; font-size: 20px;}
        button{margin:20px auto; width:150px; height: 40px; color:white; font-size:15px; background-color:#03134E; border:none;}
    </style>
</head>
<body>
<div class="snow-container">
    <div class="snow foreground"></div>
    <div class="snow foreground layered"></div>
    <div class="snow middleground"></div>
    <div class="snow middleground layered"></div>
    <div class="snow background"></div>
    <div class="snow background layered"></div>
</div>

<div class="top-buttons-agileinfo">
    <a href="../Login.jsp" >管理员登录</a><a href="Vote.jsp" class="active">创建投票</a><a href="../Result.jsp">投票结果</a><a href="../Quit.jsp" >退出</a>
</div>
<h1>创建投票</h1>
<div class="main-agileits">
    <div class="form-w3-agile">
        <div class="row">
            <div class="col-xs-12 col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h1 style="color: white">选项列表</h1>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-striped">
                            <thead>
                            <tr style="color: white">
                                <th>选项名字</th>
                                <th>选项描述</th>
                                <th>投票id</th>
                            </tr>
                            </thead>

                            <tbody style="color: white">
                            <c:choose>
                                <c:when test="${voteList!= null}">
                                    <c:forEach var="item" items="${list}">
                                        <tr>
                                            <td>${item.name}</td>
                                            <td>${item.description}</td>
                                            <td>${item.parent}</td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise style="color: white">
                                    <h1>暂无选项，请添加!</h1>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>
                    <div class="submit-w3l">
                        <a href="/user/InsertVoteItemBefore.do"><button>查询选项</button></a>
                    </div>
                    <div class="submit-w3l">
                        <a href="success.jsp"><button>创建投票</button></a>
                    </div>
                    <div class="submit-w3l">
                        <<a href="success.jsp"><button>添加选项</button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>