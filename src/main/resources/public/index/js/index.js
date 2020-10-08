
getAllLog();
getAllEquipment();
function getAllLog() {
    $.ajax({
        url:'/getAllLog',
        type:'get',
        dataType:'json',
        success:function(data){
            console.log(data);
            //通过 js 控制 html 代码
            var html = ""
            for (var i=0;i<data.data.length;i++) {
                html+='<div class="row">'
                html+='        <div class="col-xs-1 ">'
                html+=(i+1)
                html+='        </div>'
                html+='       <div class="col-xs-4">'
                html+='             <span>'+data.data[i].admin.name+'</span>'
                html+='        </div>'
                html+='        <div class="col-xs-5">'
                html+=data.data[i].logintime.substr(0,21).replace("T","/")
                html+='        </div>'
                html+='        <div class="col-xs-2">'
                html+=data.data[i].ip
                html+='        </div>'
                html+='   </div>'
            }
            $("#logonlog_alllog").append(html)
        }
    })
}

function addEquipment() {
    $.ajax({
        url:'/addEquipment',
        type:'get',
        data:{
            name:$('#e_name').val(),
            person:$('#e_person').val(),
            brand:$('#e_brand').val(),
            number:$('#e_number').val()
        },
        dataType:'json',
        success:function (data){
            alert(data.msg);
            //清空元素下所有子节点
            $("#equipmentList").empty();
            //修改之后再重新获取数据
            getAllEquipment();

        }
    })

}

function getAllEquipment() {
    $.ajax({
        url:'/getAllEquipment',
        type:'get',
        dataType:'json',
        success:function(data){
            console.log(data);
            //通过 js 控制 html 代码
            var html = ""
            for (var i=0;i<data.data.length;i++) {
            html+='<div class="row">'
            html+='<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">'
            html+=(i+1)
            html+='</div>'
            html+='<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">'
            html+=data.data[i].name
            html+='</div>'
            html+='<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">'
            html+='<button class="btn btn-success btn-xs" data-toggle="modal" data-target="#changeSource" onclick="e_update('+data.data[i].id+')">详情</button>'
            html+='<button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSource" onclick="e_delete('+data.data[i].id+')">删除</button>'
            html+='</div>'
            html+='</div>'


            }
            //让设备列表在页面上显示
            $("#equipmentList").append(html)
        }
    })
}
getAllEquipment2();
function getAllEquipment2() {
    $.ajax({
        url:'/getAllEquipment',
        type:'get',
        dataType:'json',
        success:function(data){
            console.log(data);
            //通过 js 控制 html 代码
            var html = ""
            for (var i=0;i<data.data.length;i++) {
                html+='<div class="row">'
                html+='<div class="col-xs-1 ">'
                html+=(i+1)
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+=data.data[i].name
                html+='</div>'
                html+='<div class="col-xs-1">'
                html+=data.data[i].person
                html+='</div>'
                html+='<div class="col-xs-1">'
                html+=data.data[i].brand
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+=data.data[i].number
                html+='</div>'

                html+='<div class="col-xs-2">'
                html+='<button class="btn btn-success btn-xs" data-toggle="modal" data-target="#reviseSchool" onclick="e_update2('+data.data[i].id+')">修改</button>'
                html+='<button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSchool" onclick="e_delete2('+data.data[i].id+')">删除</button>'
                html+='</div>'
                html+='</div>'


            }
            //让设备列表在页面上显示
            $("#equipmentList2").append(html)
        }
    })
}

function e_update(id) {

    $.ajax({
        url: '/getEquipmentById',
        type: 'get',
        data: {
            id: id
        },
        dataType: 'json',
        success: function (data) {
            console.log(data);
            $("#e_update_name").val(data.data.name);
            $("#e_update_person").val(data.data.person)
            $("#e_update_brand").val(data.data.brand)
            $("#e_update_number").val(data.data.number)
            $("#e_update_bc").attr("onclick","e_update_bc("+data.data.id+")");

        }
    })
}

function e_update_bc(id) {
    $.ajax({
        url: '/updateEquipmentById',
        type: 'get',
        data: {
            id: id,
            name:$("#e_update_name").val(),
            person:$("#e_update_person").val(),
            brand:$("#e_update_brand").val(),
            number:$("#e_update_number").val()
        },
        dataType: 'json',
        success: function (data) {
            console.log(data);
          alert(data.msg);
             //清空元素下所有子节点
           $("#equipmentList").empty();
             //修改之后再重新获取数据
           getAllEquipment();

        }
    })
}
function e_delete(id) {
    console.log(id);
    $("#e_delete_qd").attr("onclick","e_delete_qd("+id+")");
}
function e_delete_qd(id) {
    console.log(id);
    $.ajax({
        url: '/deleteEquipmentById',
        type: 'get',
        data: {
            id: id
        },
        dataType: 'json',
        success: function (data) {
            console.log(data);
            alert(data.msg);
            //清空元素下所有子节点
            $("#equipmentList").empty();
            //修改之后再重新获取数据
            getAllEquipment();

        }
    })
}
function e_update2(id) {

    $.ajax({
        url: '/getEquipmentById',
        type: 'get',
        data: {
            id: id
        },
        dataType: 'json',
        success: function (data) {
            console.log(data);
            $("#e_update_name2").val(data.data.name);
            $("#e_update_person2").val(data.data.person)
            $("#e_update_brand2").val(data.data.brand)
            $("#e_update_number2").val(data.data.number)
            $("#e_update_bc2").attr("onclick","e_update_bc2("+data.data.id+")");

        }
    })
}

function e_update_bc2(id) {
    $.ajax({
        url: '/updateEquipmentById',
        type: 'get',
        data: {
            id: id,
            name:$("#e_update_name2").val(),
            person:$("#e_update_person2").val(),
            brand:$("#e_update_brand2").val(),
            number:$("#e_update_number2").val()
        },
        dataType: 'json',
        success: function (data) {
            console.log(data);
            alert(data.msg);
            //清空元素下所有子节点
            $("#equipmentList2").empty();
            //修改之后再重新获取数据
            getAllEquipment2();

        }
    })
}

function e_delete2(id) {
    console.log(id);
    $("#e_delete_qd2").attr("onclick","e_delete_qd2("+id+")");
}
function e_delete_qd2(id) {
    console.log(id);
    $.ajax({
        url: '/deleteEquipmentById',
        type: 'get',
        data: {
            id: id
        },
        dataType: 'json',
        success: function (data) {
            console.log(data);
            alert(data.msg);
            //清空元素下所有子节点
            $("#equipmentList2").empty();
            //修改之后再重新获取数据
            getAllEquipment2();

        }
    })
}
admin_list();
function admin_list() {
    $.ajax({
        url:'/getAllAdmin',
        type:'get',
        dataType:'json',
        success:function(data){
            console.log(data);
            //通过 js 控制 html 代码
            var html = ""
            for (var i=0;i<data.data.length;i++) {
                html+='<div class="row">'
                html+='<div class="col-xs-2 ">'
                html+=data.data[i].jobnumber
                html+='</div>'
                html+='<div class="col-xs-1">'
                html+=data.data[i].name
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+=data.data[i].department
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+=data.data[i].username
                html+='</div>'
                html+='<div class="col-xs-2">'
                if (data.data[i].power==0){
                    html+='超级管理员'
                }else {
                    html+='普通用户'
                }
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+=data.data[i].job
                html+='</div>'
                html+='<div class="col-xs-1">'
                html+='<button class="btn btn-success btn-xs" data-toggle="modal" data-target="#reviseSchool" onclick="admin_update('+data.data[i].id+')">修改</button>'
                html+='</div>'
                html+='</div>'
            }
            //让设备列表在页面上显示
            $("#admin_list").append(html)
        }
    })
}
function addAdmin() {
    $.ajax({
        url: '/addAdmin',
        type: 'post',
        data: {
            jobnumber: $('#add_jobnumber').val(),
            name: $('#add_name').val(),
            department: $('#add_department').val(),
            username: $('#add_username').val(),
            password: $('#add_password').val(),
            power: $('#add_power').val(),
            job: $('#add_job').val()
        },
        dataType: 'json',
        success: function (data) {
            alert(data.msg);
            //清空元素下所有子节点
            $("#admin_list").empty();
            //修改之后再重新获取数据
            admin_list();

        }
    })
}
// function admin_update() {
//     $.ajax({
//         url: '/getAdminById',
//         type: 'get',
//         data: {
//             id: id
//         },
//         dataType: 'json',
//         success: function (data) {
//             console.log(data);
//             $("#admin_update_jobnumber").val(data.data.jobnumber);
//             $("#admin_update_name").val(data.data.name)
//             $("#admin_update_department").val(data.data.department)
//             $("#admin_update_username").val(data.data.username)
//             $("#admin_update_password").val(data.data.password)
//             $("#admin_update_power").val(data.data.power)
//             $("#admin_update_job").val(data.data.job)
//             //$("#admin_update_bc").attr("onclick","e_update_bc("+data.data.id+")");
//
//         }
//     })
