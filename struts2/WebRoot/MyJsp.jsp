<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Semantic UI </title>
    <!-- 使用CDN导入js和css 文件-->
    <link href="https://cdn.bootcss.com/semantic-ui/2.3.1/semantic.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.bootcss.com/semantic-ui/2.3.1/semantic.js"></script>
    <script>
        $(function () {
            $(".ui.green.button").on("click",function () {
                $(".ui.small.modal").modal("show");
            })
        })
    </script>
</head>
<body style="padding: 20px;">
    <div class="ui container">
        <div class="ui modal">
            <div class="header"><i class="user icon"></i>用户信息</div>
            <div class="content">
                <p>Staryjie，您好，欢迎来到XXXX!</p>
            </div>
        </div>
        <button class="ui green button">查看</button>
    </div>
</body>
</html>