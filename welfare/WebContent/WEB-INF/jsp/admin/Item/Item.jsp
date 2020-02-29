
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
  <meta charset="UTF-8">
  <title>物品信息</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">
  <link rel="stylesheet" type="text/css" href="${pwd}/staticAdmin/common/layui/css/layui.css" media="all">
  <link rel="stylesheet" type="text/css" href="${pwd}/staticAdmin/common/bootstrap/css/bootstrap.css" media="all">
  <link rel="stylesheet" type="text/css" href="${pwd}/staticAdmin/common/global.css" media="all">
  <link rel="stylesheet" type="text/css" href="${pwd}/staticAdmin/css/personal.css" media="all">
  <script src="${pwd}/staticAdmin/js/jquery-3.3.1.min.js"></script>
	<script src="${pwd}/staticAdmin/js/ajaxUtil.js"></script>
	<script src="${pwd}/staticAdmin/js/formatUtil.js"></script>
</head>

<body>
  <section class="layui-larry-box">
    <div class="larry-personal">
      <div class="layui-tab">
        <blockquote class="layui-elem-quote news_search">
          <form class="layui-form" id="dataForm" action="${pwd }/admin/Item/findItem" method="post">
					<div class="layui-inline">
					    <div class="layui-input-inline">
					    	<input name = "name" value="" placeholder="请输入物品名" class="layui-input search_input" type="text">
					    </div>
					    <input class="layui-btn search_btn" type = "submit" value = "查询">
					</div>
				</form>
        </blockquote>

        <div class="layui-tab-content larry-personal-body clearfix mylog-info-box">
          <!-- 操作日志 -->
          <div class="layui-tab-item layui-field-box layui-show">
            <table class="layui-table table-hover" lay-even="" lay-skin="nob">
              <thead>
                <tr>
                  <th><input type="checkbox" id="selected-all"></th>
                  <th>ID</th>
                  <th>物品名</th>
                  <th>数量</th>
                  <th>简介</th>
                  <th>捐赠者</th>
                  <th>物品类型</th>
                  <th>申请情况</th>
                  <th>上传时间</th>
                  <th>操作</th>
                </tr>
                <c:set var = "i" value = "0"/>
                <c:forEach items="${items}" var="Item" varStatus="stat">
					<tr>
						<td><input type="checkbox"></td>
						<td name="id">${Item.id }</td>
		                  <td name="itemname">${Item.itemname }</td>
		                  <td name="itemcount">${Item.itemcount }</td>
		                  <td name="introduce">${Item.introduce }</td>
						<td name="actid">${temp_users[i].username}</td>
						<td name="actid">${temp_itemtypes[i].itemname}</td>
						<td name="actid">${temp_audittypes[i].auditName}</td>
		                  <td name="createtime">${Item.createtime}</td>
						 <td>
	                    <a class="layui-btn layui-btn-mini news_edit" onclick="locationHref('${pwd }/admin/Item/updateItem?flag=1&id=${Item.id }')"><i class="iconfont icon-edit"></i> 编辑</a>
	                    <a class="layui-btn layui-btn-danger layui-btn-mini news_del" data-id="1"  onclick="delDataByUrl('${pwd }/admin/Item/removeItem?id=${Item.id}',this)"><i
	                        class="layui-icon"></i> 删除</a>
	                  </td>
					</tr>
				 <c:set var = "i" value = "${i+1 }"/>
				</c:forEach>
                
              </thead>
            </table>
            <div class="larry-table-page clearfix">
              <div id="page" class="page"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <script type="text/javascript" src="${pwd}/staticAdmin/common/layui/layui.js"></script>
</body>
</html>