<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>用户的批量删除</title>
        <style type="text/css">
            td{
                text-align: center;
            }
        </style>
        <script type="text/javascript">
                
                //用来全选和取消全部选择
                function changeStatus(){
                    //获取第一行 (选择两字旁边 的那个复选框的状态)
                    var flag = $("#cheooseBox").is(":checked");
                    $("input").attr("checked",flag);
                }
                $(function(){
                    $("button").click(function(){
                        var checkedNum  = $("input:checked").length;
                        if(confirm("确定删除所选项？")){
                            var userIds = new Array();
                            $("input:checked").each(function(){
                                //将标签的值放入数组中
                                userIds.push($(this).val());//此处添加不能使用add  add不是一个function
                            });
                          
                            $.ajax({
                                type:"post",
                                url:"getdeall",
                                data:{"userIds":userIds},
                                dataType:"json",
                                //traditional:true,
                                success:function(data){
                                    if(data.status==200){
                                        if(confirm("恭喜你删除成功！点击确认刷新页面")){
                                           // $(location).attr("href","user/showUser");
                                        }    
                                    }
                                }
                            });
                        }
                    });
                });
        </script>
</head>
<body>
    
    <div class="user-info-form1" align="center">
                <form action="" method="post">
                    <table border="1" cellspacing="0" cellpadding="0" width="300ox" height="450px">
                        <tr>
                            <th>选择
                                <input type="checkbox" id="cheooseBox" value="-1" onclick="changeStatus()" size="7" />
                            </th>
                            <th>姓名</th>
                            <th>电话</th>
                        </tr>
                        <tr>
                            <td><input name="uname1" value="1" type="checkbox"/></td>
                            <td>张三1</td>
                            <td>123</td>
                        </tr>
                        <tr>
                            <td><input name="uname2" value="2" type="checkbox"/></td>
                            <td>张三2</td>
                            <td>123</td>
                        </tr>
                        <tr>
                            <td><input name="uname3" value="3" type="checkbox"/></td>
                            <td>张三3</td>
                            <td>123<
                        </tr>
                        <tr>
                            <td><input name="uname4" value="4" type="checkbox"/></td>
                            <td>张三4</td>
                            <td>123</td>
                        </tr>
                        <tr>
                            <td><input name="uname5" value="5" type="checkbox"/></td>
                            <td>张三5</td>
                            <td>123</td>
                        </tr>
                    </table>                    
                    <button style="width:90px;height:50px">提交</button>
                </form>
            </div>
</body>
</html>