function addClub() {
    var name = $("#name").val();
    var manager = $("#manager").val();
    var createDate = $("#createDate").val();
    var type = $("#type").val();
    var activitytimes = $("#activitytimes").val();
    var membercount = $("#membercount").val();
    var remarks = $("#remarks").val();
    var info = {
        name: name,
        manager: manager,
        createDate: createDate,
        type: type,
        activitytimes: activitytimes,
        membercount: membercount,
        remarks: remarks
    };
    $.ajax({
        type: "post",
        url: "/findClubByName",
        data: {name: name},//提交的数据
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        dataType: "json",
        success: function (data) {
            //若俱乐部名已存在，则提示
            if (data.length > 0) {
                $("#name_tips").text("用户名已存在！").show();
            } else {
                //若俱乐部名不存在，则进行新增操作
                $.ajax({
                    type: "post",
                    url: "/addClub",
                    data: JSON.stringify(info),//提交的数据
                    contentType: "application/json",
                    dataType: "json",
                    success: function (data) {

                        if (data.status) {  //新增成功
                            //新增成功处理代码...
                            $("#addTips").html("增加成功！").addClass("alert-success").show();
                            $("#myModal").modal("hide");
                            var t1 = window.setTimeout(function () {
                                $("#addTips").hide();
                                window.location.reload();
                            }, 1000);
                        } else {  //修改失败
                            //新增失败处理代码...
                            if (data.msg.name != null) {
                                $("#name_tips").text(data.msg.name).show();
                            }
                            if (data.msg.manager != null) {
                                $("#manager_tips").text(data.msg.manager).show();
                            }
                            if (data.msg.type != null) {
                                $("#type_tips").text(data.msg.type).show();
                            }
                            if (data.msg.createDate != null) {
                                $("#createDate_tips").text(data.msg.createDate).show();
                            }
                            if (data.msg.activitytimes != null) {
                                $("#activitytimes_tips").text(data.msg.activitytimes).show();
                            }
                            if (data.msg.membercount != null) {
                                $("#membercount_tips").text(data.msg.membercount).show();
                            }
                        }
                    }
                });
            }
        }
    });

}

function openUpdateWindow(that) {
    var content = $(that).parent().parent().children();
    $("#id2").val(content.get(0).textContent);
    $("#name2").val(content.get(1).textContent);
    $("#manager2").val(content.get(2).textContent);
    $("#type2").val(parseInt(content.get(3).textContent));
    $("#createDate2").val(content.get(4).textContent);
    $("#activitytimes2").val(content.get(5).textContent);
    $("#membercount2").val(content.get(6).textContent);
    $("#remarks2").val(content.get(8).textContent);
}

function updateClub() {
    var id = $("#id2").val();
    var name = $("#name2").val();
    var manager = $("#manager2").val();
    var createDate = $("#createDate2").val();
    var type = $("#type2").val();
    var activitytimes = $("#activitytimes2").val();
    var membercount = $("#membercount2").val();
    var remarks = $("#remarks2").val();
    var info = {
        id: id,
        name: name,
        manager: manager,
        createDate: createDate,
        type: type,
        activitytimes: activitytimes,
        membercount: membercount,
        remarks: remarks
    };
    $.ajax({
        type: "post",
        url: "/findClubByName",
        data: {name: name},//提交的数据
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        dataType: "json",
        success: function (data) {
            if (data.length <= 0) {
                //若俱乐部名不存在，则进行修改操作
                $.ajax({
                    type: "post",
                    url: "/updateClub",
                    data: JSON.stringify(info),//提交的数据
                    contentType: "application/json",
                    dataType: "json",
                    success: function (data) {
                        if (data.status) {  //修改成功
                            //修改成功处理代码...
                            $("#myModal2").modal("hide");
                            $("#updateTips").html("修改成功!").addClass("alert-success").show();
                            var t1 = window.setTimeout(function () {
                                $("#updateTips").hide();
                                window.location.reload();
                            }, 1000);
                        } else {  //修改失败
                            //修改失败处理代码...
                            if (data.msg.name != null) {
                                $("#name_tips2").text(data.msg.name).show();
                            }
                            if (data.msg.manager != null) {
                                $("#manager_tips2").text(data.msg.manager).show();
                            }
                            if (data.msg.membercount != null) {
                                $("#membercount_tips2").text(data.msg.membercount).show();
                            }
                        }
                    }
                });
            } else {
                //若俱乐部名已存在，则提示
                for (var i = 0; i < data.length; i++) {
                    if (data[i].id != id) {
                        $("#name_tips2").text("用户名已存在！").show();
                    } else {
                        //若俱乐部名不存在，则进行修改操作
                        $.ajax({
                            type: "post",
                            url: "/updateClub",
                            data: JSON.stringify(info),//提交的数据
                            contentType: "application/json",
                            dataType: "json",
                            success: function (data) {
                                if (data.status) {  //修改成功
                                    //修改成功处理代码...
                                    $("#myModal2").modal("hide");
                                    $("#updateTips").html("修改成功!").addClass("alert-success").show();
                                    var t1 = window.setTimeout(function () {
                                        $("#updateTips").hide();
                                        window.location.reload();
                                    }, 1000);
                                } else {  //修改失败
                                    //修改失败处理代码...
                                    if (data.msg.name != null) {
                                        $("#name_tips2").text(data.msg.name).show();
                                    }
                                    if (data.msg.manager != null) {
                                        $("#manager_tips2").text(data.msg.manager).show();
                                    }
                                    if (data.msg.membercount != null) {
                                        $("#membercount_tips2").text(data.msg.membercount).show();
                                    }
                                }
                            }
                        });
                    }
                }
            }

        }
    });
}

function deleteClub(that) {
    var content = $(that).parent().parent().children();
    var id = content.get(0).textContent;
    var info = {"id": parseInt(id)};
    $.ajax({
        type: "post",
        url: "/deleteClub",
        data: {id: id},
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        dataType: "json",
        success: function (data) {
            if (data.status) {

                $("#deleteTips").html("删除成功").addClass("alert-success").show();
            } else {

                $("#deleteTips").html(data.msg).addClass("alert-warning").show();
            }
            var t1 = window.setTimeout(function () {
                $("#deleteTips").hide();
                window.location.reload();
            }, 1000);
        }
    });
}