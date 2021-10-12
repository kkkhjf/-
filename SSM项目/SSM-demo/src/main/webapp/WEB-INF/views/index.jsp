<%--
  Created by IntelliJ IDEA.
  User: hjf
  Date: 2021/9/30
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!--引入JQuery-->
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- Bootstrap -->
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
<body>
<!--bootstrap的栅格样式-->
<div class="container">

    <!-- 员工新增Modal -->
    <div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加员工</h4>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group row">
                            <label for="empName_add_input" class="col-sm-2 control-label center-block">员工姓名</label>
                            <div class="col-sm-6">
                                <input type="text" name="lastName" class="form-control" id="empName_add_input" placeholder="Jack">
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="empEmail_add_input" class="col-sm-2 control-label text-center">邮箱</label>
                            <div class="col-sm-6">
                                <input type="text" name="email" class="form-control" id="empEmail_add_input" placeholder="jackcheng@163.com">
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 control-label text-center">性别</label>
                            <div class="col-sm-6">
                                <label class="radio-inline">
                                    <input type="radio" name="gender" value="1" id="gender1_add_input" checked="checked">男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="gender" value="0" id="gender2_add_input">女
                                </label>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 control-label text-center">所属部门</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="dId" id="dept_add_select">
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div id="form_bottom" class="modal-footer">
                    <label id="form_bottom_label"></label>
                    <button id="emp_save_button" type="button" class="btn btn-primary">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 员工修改Modal -->
    <div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">添加员工</h4>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group row">
                            <label for="empName_add_input" class="col-sm-2 control-label center-block">员工姓名</label>
                            <div class="col-sm-6">
                                <p class="form-control-static" id="empName_update_static"></p>
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="empEmail_add_input" class="col-sm-2 control-label text-center">邮箱</label>
                            <div class="col-sm-6">
                                <input type="text" name="email" class="form-control" id="empEmail_update_input" placeholder="jackcheng@163.com">
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 control-label text-center">性别</label>
                            <div class="col-sm-6">
                                <label class="radio-inline">
                                    <input type="radio" name="gender" value="1" id="gender1_update_input">男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="gender" value="0" id="gender2_update_input">女
                                </label>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 control-label text-center">所属部门</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="dId" id="dept_update_select">
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div id="updateForm_bottom" class="modal-footer">
                    <label id="updateForm_bottom_label"></label>
                    <button id="emp_update_button" type="button" class="btn btn-primary">修改</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>

    <!--标题-->
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <!--按钮-->
    <div class="row">
        <!--col-md-offset-8: 偏移8列-->
        <div class="col-md-4 col-md-offset-9">
            <button class="btn btn-primary" id="btn_add_emp_modal">新增</button>
            <button class="btn btn-danger" id="btn_del_selected_emp">删除</button>
        </div>
    </div>
    <br/>
    <!--表格-->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered text-center table-hover" id="emps_table">
                <thead>
                    <tr>
                        <th class="text-center">
                            <input type="checkbox" id="check_all"/>
                        </th>
                        <th class="text-center">#</th>
                        <th class="text-center">empName</th>
                        <th class="text-center">gender</th>
                        <th class="text-center">email</th>
                        <th class="text-center">departName</th>
                        <th class="text-center">操作</th>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
    <!--分页栏-->
    <div class="row text-center">
        <img src="..." alt="..." class="img-rounded">
        <div class="col-md-3" id="page_info_area">
        </div>
        <div class="col-md-6" id="page_nav_area">
        </div>
    </div>
</div>

<%--页面上的方法--%>
<script type="text/javascript">
    var totalRecord;
    var checkName;
    var curPageNum;

    //页面加载完成后发送ajax请求，要到分页数据
    $(function (){
        to_page(1);
    });

    //解析员工数据
    function build_emps_table(result){
        //每次解析员工是都将上一次解析的数据清空，不然会出现数据积累的情况
        $("#emps_table tbody").empty();
        var emps = result.extend.pageInfo.list;
        $.each(emps, function (index,item){
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            var empIdTd = $("<td></td>").append(item.id);
            var empLastNameTd = $("<td></td>").append(item.lastName);
            var empGenderTd = $("<td></td>").append(item.gender == 1 ? "男":"女");
            var empEmailTd = $("<td></td>").append(item.email);
            var empDeptNameTd = $("<td></td>").append(item.department.deptName);
            /**
             *   <button class="btn btn-primary btn-sm">
                     <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                     新增
                 </button>
                 <button class="btn btn-danger btn-sm">
                     <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                     删除
                 </button>
             * @type {*|jQuery}
             *
             * 动态创建<button>标签，并将其内部的属性和子标签都动态生成，并在最后加入到table中
             */
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm update_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil").attr("aria-hidden", "true"))
                .append("修改");
            editBtn.attr("edit_id", item.id);
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash").attr("aria-hidden", "true"))
                .append("删除");
            delBtn.attr("del_id", item.id);
            var btnTd = $("<td></td>").append(editBtn).append("  ").append(delBtn);
            /**
             *  append方法执行完后返回原来的元素;
             *  通过appendTo()方法将<tr>标签添加进<table>标签中，#emps_table代表table的id，tbody代表插入的位置，
             *      即插入到<tbody>标签下;
             */
            $("<tr></tr>").append(checkBoxTd).append(empIdTd).append(empLastNameTd).append(empGenderTd)
                .append(empEmailTd).append(empDeptNameTd)
                .append(btnTd).appendTo("#emps_table tbody");
        });

    }

    //解析分页信息
    function build_page_info(result){
        //清除上一次请求留下的数据
        $("#page_info_area").empty();
        $("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页, 总" + result.extend.pageInfo.pages +
            "页, 共" + result.extend.pageInfo.total + "条记录");
        totalRecord = result.extend.pageInfo.total;
    }

    //解析分页条和分页条中的超链接
    function build_page_nav(result){
        curPageNum = result.extend.pageInfo.pageNum;
        //清除上一次请求留下的数据
        $("#page_nav_area").empty();
        //父标签ul
        var ul = $("<ul></ul>").addClass("pagination");
        //构造首页、上一页、下一页和末页的<li>标签
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
        var prePageLi = $("<li></li>").append($("<a></a>").attr("aria-label", "Previous")
            .append($("<span></span>").attr("aria-hidden", "true").append("&laquo;")));
        //如果没有上一页就将首页和上一页设置为不可点击
        if(result.extend.pageInfo.hasPreviousPage == false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为首页和上一页添加单机事件
            firstPageLi.click(function (){
                to_page(1);
            });
            prePageLi.click(function (){
                if(result.extend.pageInfo.pageNum > 1){
                    to_page(result.extend.pageInfo.pageNum - 1);
                }
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").attr("aria-label", "Next")
            .append($("<span></span>").attr("aria-hidden", "true").append("&raquo;")));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
        //如果没有下一页就将下一页和末页设置为不可点击
        if(result.extend.pageInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            //为末页和下一页添加单击事件
            nextPageLi.click(function (){
                if(result.extend.pageInfo.pageNum < result.extend.pageInfo.navigateLastPage){
                    to_page(result.extend.pageInfo.pageNum + 1);
                }
            });
            lastPageLi.click(function (){
                to_page(result.extend.pageInfo.navigateLastPage)
            });
        }

        //将首页和上一页<li>标签添加进<ul>标签中
        ul.append(firstPageLi).append(prePageLi);
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item){
            //构造具体页码的<li>标签
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            //当前浏览页面的分页高亮显示
            if(result.extend.pageInfo.pageNum == item){
                numLi.addClass("active");
            }
            //给numLi绑定单击事件、
            numLi.click(function (){
               to_page(item);
            });
            //将具体页码<li>标签添加进<ul>标签中
            ul.append(numLi);
        });
        //将下一页和末页<li>标签添加进<ul>标签
        ul.append(nextPageLi).append(lastPageLi);

        var navEle = $("<nav></nav>").attr("aria-label", "Page navigation").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    //发送Ajax请求，参数为页码数
    function to_page(pn){
        $.ajax({
            url:"${APP_PATH}/emps",
            data:"pn=" + pn,
            type:"get",
            success:function (result){
                // 显示员工数据
                build_emps_table(result);
                //显示分页信息
                build_page_info(result);
                //显示导航条
                build_page_nav(result);
            }
        });
    }

    //给“新增”按钮绑定单击事件
    $("#btn_add_emp_modal").click(function (){
        //清除上一次请求的输入信息和验证信息
        $("#empName_add_input").val("");
        $("#empEmail_add_input").val("");
        $("#empName_add_input").parent().removeClass("has-success has-error");
        $("#empName_add_input").next("span").text("");
        $("#empEmail_add_input").parent().removeClass("has-success has-error");
        $("#empEmail_add_input").next("span").text("");
        //清空保存员工的提示信息
        $("#empAddModal #form_bottom_label").empty();
        //取出保存按钮上的"ajax-va"属性
        $("#emp_save_button").removeAttr("ajax-va");
        //发送Ajax请求，查出部门信息，显示在下拉列表中
        getDepts("#empAddModal select");
        //弹出模态框
        $("#empAddModal").modal({
            backdrop:true,
            keyboard:true
        });
    });

    //查出所有部门信息
    function getDepts(ele){
        //每次请求前都要将上一次请求的数据清空
        $("#empAddModal select").empty();

        $.ajax({
            url:"${APP_PATH}/depts",
            type:"GET",
            success:function (result){
                $("dept_add_select").append();
                $.each(result.extend.depts, function (){
                    var optionEle = $("<option></option>").append(this.deptName).attr("value", this.id);
                    optionEle.appendTo(ele);
                });
            }
        });
    }

    //校验表单数据
    function validate_add_form(){
        if(checkName){
            //校验用户名
            var empName = $("#empName_add_input").val();
            //使用正则表达式筛选英文和中文
            var regName = /(^[a-zA-Z0-9]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
            if(!regName.test(empName)){
                showMsg("#empName_add_input", "error", "用户名必须是2-5位中文或6-16位英文");
                return false;
            }else{
                showMsg("#empName_add_input", "success", "");
            }

        }
        //校验邮箱
        var email = $("#empEmail_add_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if(!regEmail.test(email)){
            showMsg("#empEmail_add_input", "error", "邮箱格式不正确");
            return false;
        }else{
            showMsg("#empEmail_add_input", "success", "");
        }
        return true;
    }
    //错误信息提醒
    function showMsg(ele, status, msg){
        //清除上一次请求的提示信息
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        //添加提示信息
        if("error"==status){
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }else{
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }
    }

    //给员工输入框绑定change事件作重复姓名的校验
    $("#empName_add_input").change(function (){
        //获取员工姓名输入框里的数据(this.val()为什么不行？这个this指的不是$("#empName_add_input")吗？)
        var lastName = $(this).val();
        //发送Ajax请求，验证用户名是否可用
        $.ajax({
            url:"${APP_PATH}/checkUser",
            data:"empName="+lastName,
            type:"GET",
            success:function (result){
                if(result.code == 100){
                    showMsg("#empName_add_input", "success", "用户名可用");
                    $("#emp_save_button").attr("ajax-va", "sueecss");
                    checkName = true;
                }else{
                    showMsg("#empName_add_input", "error", result.extend.va_msg);
                    $("#emp_save_button").attr("ajax-va", "error");
                    checkName = false;
                }
            }
        });
    });

    //“保存”按钮绑定单击事件
    $("#emp_save_button").click(function (){
        //将模态框中的数据提交给数据库
        //发送Ajax请求，保存新员工
        // alert(decodeURIComponent($("#empAddModal form").serialize(), true));

        //发送请求前验证用户名和邮箱的格式有没有填写错误
        if(!validate_add_form()){
            return false;
        }
        //校验一下保存按钮中的"ajax-va"属性
        if($(this).attr("ajax-va") == "error"){
            return false;
        }

        $.ajax({
           url:"${APP_PATH}/emp",
           type:"POST",
           data:decodeURIComponent($("#empAddModal form").serialize(), true),
           success:function (result){
               if(result.code == 100){
                   //显示操作的提示信息
                   if(result.extend.status == "s"){
                       // <label class="col-sm-2"><span class="label label-success">新增成功</span></label>
                       $("#form_bottom_label").addClass("col-sm-2").append($("<span></span>")
                           .addClass("label label-success").append("新增成功")).appendTo("#empAddModal #form_bottom");
                   }else{
                       $("#form_bottom_label").addClass("col-sm-2").append($("<span></span>")
                           .addClass("label label-danger").append("新增失败")).appendTo("#empAddModal #form_bottom");
                   }
                   //关闭模态框
                   $("#empAddModal").modal('hide');
                   //来到最后一页，显示刚才保存的数据
                   //发送Ajax请求，显示最后一页的数据
                   to_page(totalRecord);
               }else{
                    if(undefined != result.extend.errorFields.email){
                        showMsg("#empEmail_add_input", "error", result.extend.errorFields.email);

                    }
                    if(undefined != result.extend.errorFields.lastName){
                        showMsg("#empName_add_input", "error", result.extend.errorFields.lastName);
                    }
               }
           }
        });
    });

    //给更新按钮绑定事件
    $(document).on("click", ".update_btn", function (){
        $("#empName_update_input").val("");
        $("#empEmail_update_input").val("");
        $("#empName_update_input").parent().removeClass("has-success has-error");
        $("#empName_update_input").next("span").text("");
        $("#empEmail_update_input").parent().removeClass("has-success has-error");
        $("#empEmail_update_input").next("span").text("");
        //查出员工信息
        getEmp($(this).attr("edit_id"));
        //查出部门信息
        getDepts("#empUpdateModal select");
        //将id传入到模态框中保存
        $("#emp_update_button").attr("inner_edit_id", $(this).attr("edit_id"));
        //打开更新操作的模态框
        $("#empUpdateModal").modal({
            backdrop:true,
            keyboard:true
        });
    });
    //获取员工信息
    function getEmp(id){
        $.ajax({
            url:"${APP_PATH}/emp/" + id,
            type:"GET",
            success:function (result){
                var emp = result.extend.emp;
                $("#empName_update_static").text(emp.lastName);
                $("#empEmail_update_input").val(emp.email);
                $("#empUpdateModal input[name=gender]").val([emp.gender]);
                $("#empUpdateModal select").val([emp.dId]);
            }
        });
    }

    //给更新按钮修改模态框的修改按钮绑定单击事件
    $("#emp_update_button").click(function (){

        //校验邮箱
        var email = $("#empEmail_update_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if(!regEmail.test(email)){
            showMsg("#empEmail_update_input", "error", "邮箱格式不正确");
            return false;
        }else{
            showMsg("#empEmail_update_input", "success", "");
        }
        console.log(decodeURIComponent($("#empUpdateModal form").serialize(), true))
        //发送Ajax请求
        //HiddenHttpMethodFilter会将POST请求转换成_method参数指定的类型
        //添加HttpPutFormContentFilter过滤器，则可以直接使用Ajax发送PUT请求，不需要传递_method参数
        $.ajax({
            url:"${APP_PATH}/emp/"+$(this).attr("inner_edit_id"),
            type:"POST",
            data:decodeURIComponent($("#empUpdateModal form").serialize(), true) + "&_method=PUT",
            success:function (result){
                //关闭模态框
                $("#empUpdateModal").modal('hide');
                //来到最后一页，显示刚才保存的数据
                //发送Ajax请求，更新当前页的数据
                to_page(curPageNum);
            }
        });
    });


    //给删除按钮绑定事件(单个删除)
    $(document).on("click", ".delete_btn", function (){
        var delEmpName = $(this).parent().parent().children("td").eq(2).text();
        to_page(curPageNum);
        if(confirm("确定删除【" + delEmpName +"】吗？")){
            $.ajax({
                url:"${APP_PATH}/emp/" + $(this).attr("del_id"),
                type:"POST",
                data:"_method=DELETE",
                success:function (result){
                    to_page(curPageNum);
                }
            });
        }
    });

    //全选/全不选绑定事件
    $("#check_all").click(function (){
        //使用prop后去dom原生的属性，使用attr获取自定义的属性
        //使用attr获取原生的dom属性可能会出现undefined情况
        $(".check_item").prop("checked", $(this).prop("checked"));
    });

    //为每一个动态生成的checkBox也添加单击事件
    $(document).on("click", ".check_item", function (){
        if($(".check_item:checked").length == $(".check_item").length){
            $("#check_all").prop("checked", true);
        }else{
            $("#check_all").prop("checked", false);
        }
    });

    //给表格外的删除按钮绑定单击事件
    $("#btn_del_selected_emp").click(function (){
        var empNames = "";
        var empIds = "";
        $.each($(".check_item:checked"), function (){
            empNames += $(this).parent().parent().children("td").eq(2).text() + ",";
            empIds += $(this).parent().parent().children("td").eq(1).text() + "-";
        });
        empNames = empNames.substring(0, empNames.length - 1);
        empIds = empIds.substr(0, empIds.length - 1);
        if(confirm("确定删除【"+ empNames +"】吗？")){
            $.ajax({
                url:"${APP_PATH}/emp/" + empIds,
                type:"POST",
                data:"_method=DELETE",
                success:function (result){
                    console.log(result.msg);
                }
            })
        }
    });

</script>
</body>
</html>
